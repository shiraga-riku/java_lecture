Herokuにデプロイしてみよう
=============================================

# 本番環境用のプロパティファイルを作成する。

Spring Bootには**プロファイル**という機能があり、環境毎にプロパティファイルを切り替えることができる。
[公式ドキュメント](https://spring.pleiades.io/spring-boot/docs/2.1.11.RELEASE/reference/html/boot-features-profiles.html)

アプリケーションのプロパティファイル```application.properties```とは別に、```application-{環境名}.properties```とすることで環境毎のプロパティファイルを作成できる。
このように作成したプロパティファイルは以下のように```spring.profiles.active```システムプロパティに指定することで有効になる。

```
$ java  -Dspring.profiles.active=環境名 -jar target/demo-0.0.1-SNAPSHOT.jarjava.runtime.version=13
```

今回は本番環境用の以下プロパティファイルを作成する。ファイル名は```application-production.properties```とする。

```
doma.sql-file-repository=GREEDY_CACHE
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driverClassName=com.mysql.jdbc.Driver
```

## 考えてみよう
上記のプロパティファイル内で用いられている```${DB_URL}```は、環境変数DB_URLの値に置換される。
直接プロパティファイルにURLを指定せずに環境変数から取得している理由を考えてみよう。

# Herokuにアカウントを作成する。

[登録ページ](https://signup.heroku.com/login)

# Heroku CLIのインストール。
 
[インストールページ](https://devcenter.heroku.com/articles/heroku-cli)

# Herokuにアプリケーションを登録する。

作成中のプロジェクト直下に移動し、```heroku create```によりHerokuにアプリケーションを作成する。

```
$ cd to-your-application-path
$ heroku create 
Creating app... done, ⬢ quiet-lake-44586
https://quiet-lake-44586.herokuapp.com/ | https://git.heroku.com/quiet-lake-44586.git
```

上記の実行後に自動的にHeroku上にアプリケーションのGitリポジトリが作成され、リモートリポジトリの１つとして登録される。
以下のコマンドで確認できる。

```
$ git remote -v
heroku  https://git.heroku.com/fast-fortress-27415.git (fetch)
heroku  https://git.heroku.com/fast-fortress-27415.git (push)
origin  https://github.com/pebblip/simple-menu-app.git (fetch)
origin  https://github.com/pebblip/simple-menu-app.git (push)
```

コマンドの実行後にアプリケーション名が表示される（上の例では、**quiet-lake-44586**)ので控えておく。

# ```system.properties```ファイルを作成する。

HerokuのJDKバージョンは標準では8であるが、プロジェクト直下の```system.properties```ファイルによりバージョンを変更できる。
ファイルには以下のようにJDKバージョンを記載する。

```
java.runtime.version=13
```

# ```Procfile```ファイルを作成する。

今回はHeroku標準の方法でデプロイするのでなし。
 
# HerokuにMySQLをセットアップする。

## アドオンを登録する。

Heroku標準のDBはPostgreSQLであるため、MySQL用のアドオンを導入する。
アドオンを導入するためにはHerokuにクレジットカードの登録が必要・・・（無料だが）

```
$ heroku addons:create jawsdb --version=8.0
```
 
※アプリケーション名は、heroku create で作成されたアプリケーション名。

## 作成されたデータベースの接続情報の確認。

```heroku config```により、作成されたデータベースの接続情報を確認する。

```
$ heroku config --app アプリケーション名
JAWSDB_URL:  mysql://ms41ocshk0989u4b:kmz3jqef6up2lb58@phtfaw4p6a970uc0.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/t53rngqioysngu2f
```

ここで、JAWSDB_URLというのがアドオンで登録したデータベースの接続情報となる。この情報をもとに、Herokuに環境変数を設定する。
以下は、上記の接続情報の例であるので、各自の接続情報に合わせて変更すること。

```
$ heroku config:set DB_URL=jdbc:mysql://ms41ocshk0989u4b:kmz3jqef6up2lb58@phtfaw4p6a970uc0.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/t53rngqioysngu2f --app アプリケーション名
$ heroku config:set DB_USERNAME: ms41ocshk0989u4b --app アプリケーション名
$ heroku config:set DB_PASSWORD=kmz3jqef6up2lb58 --app アプリケーション名
```

ここで設定した環境変数は、```application-production.properties```内で参照している値であることに注意。


# Herokuにアプリケーションをデプロイする。

以下のGitコマンドを実行してHerokuにアプリケーションをpushする。
これにより、Herokuは自動的にアプリケーションのビルドとデプロイを行う。

```
$ git push heroku master
```

# デプロイされたアプリケーションを確認する。

以下のコマンドによりデプロイされたアプリケーションがブラウザに表示される。

```
$ heroku open
```   
