CircleCIでデプロイしてみよう
=============================================

# CircleCIにGitHubアカウントでログインする。

# CircleCIの管理画面にて、作成したGitHubのアプリケーションを登録する。

# GitHubにCircleCIのビルド設定ファイルを作成する。

プロジェクト直下に```.circleci```ディレクトリを作成し、```config.yml```という名前のファイルを作成する。
これがCircleCIのビルド設定となる。

```xml
version: 2.1
jobs:
  build:
    docker:
      - image: circleci/openjdk:13-jdk-buster-browsers
    steps:
      - checkout
      - restore_cache:
          key: maven-v1-{{ checksum "pom.xml" }}
      - run:
          name: ./mvnw install
          command: ./mvnw install
      - save_cache:
          key: maven-v1-{{ checksum "pom.xml" }}
          paths: ~/.m2
      - persist_to_workspace:
          root: .
          paths: .

  test:
    docker:
      - image: circleci/openjdk:13-jdk-buster-browsers
    steps:
      - checkout
      - attach_workspace:
          at: .
      - run:
          name: unit test
          command: ./mvnw test

  deploy:
    docker:
      - image: buildpack-deps:trusty
    steps:
      - checkout
      - run:
          name: deploy to heroku
          command: |
            git push https://heroku:$HEROKU_API_KEY@git.heroku.com/$HEROKU_APP_NAME.git master

workflows:
  version: 2.1
  build_and_test:
    jobs:
      - build
      - test:
          requires:
            - build
      - deploy:
          requires:
            - test
          filters:
            branches:
              only: master

```

# CircleCIの環境変数にHerokuへの接続情報を設定する。

CircleCIの管理画面にて、下記の２つの環境変数を設定する。それぞれの値は、Herokuの管理画面から取得する。

|環境変数|意味|
|:--:|:--:|
|HEROKU_API_KEY|Herokuのアプリケーションキー|
|HEROKU_APP_NAME|Herokuに登録したアプリケーション名|

上記はそれぞれ、```config.yml```の下記デプロイジョブの中で参照されていることに注意。

```
git push https://heroku:$HEROKU_API_KEY@git.heroku.com/$HEROKU_APP_NAME.git master
```

# CircleCIを実行する。

コミットしてGitHubにプッシュすることで、自動的にCircleCIのジョブが実行される。





