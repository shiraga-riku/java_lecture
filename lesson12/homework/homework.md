# lesson11で作成したメニューの簡易登録アプリケーションにユーザ認証機能を追加したい。。以下のステップで進めよ。

## 前提
* 管理者ユーザと一般ユーザの２つの権限があるものとする。
* レシピ、メニューの登録ができるのは管理者ユーザのみとする。一般ユーザは一覧参照のみができる。

## MavenのpomファイルにSpring Security関連の以下の定義を追加せよ。

```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.security</groupId>
      <artifactId>spring-security-test</artifactId>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.thymeleaf.extras</groupId>
      <artifactId>thymeleaf-extras-springsecurity5</artifactId>
      <version>3.0.4.RELEASE</version>
    </dependency>
```

## DBにユーザテーブルを追加せよ。

## 管理者ユーザのデータを初期値としてDBに直接追加せよ。

## 一般ユーザの会員登録機能を作成せよ。管理者ユーザの会員登録はできない。

## ユーザのログイン機能を作成せよ。一般ユーザおよび管理者とも同じログイン機能を使う。

## ユーザのログアウト機能を作成せよ。
