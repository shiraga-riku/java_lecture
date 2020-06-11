マイグレーションの実践
=============================================

# pom.xmlファイルに以下の依存を追加する。

```xml
<dependency>
   <groupId>org.flywaydb</groupId>
   <artifactId>flyway-core</artifactId>
</dependency>
```

Springはflywayを内部的に利用しており、上の依存を追加するだけでflywayが有効になる。
[公式ドキュメント](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-use-a-higher-level-database-migration-tool)

# マイグレーションファイルを作成する。

マイグレーションファイルはSQLかJavaのいずれかで作成することができる。今回はSQLで作成しよう。
マイグレーションファイルは```resources/db/migration```ディレクトリに作成すればよい。
デフォルトでは```resources/db/migration```ディレクトリ内のマイグレーションファイルがflywayによって検知される。

## マイグレーションファイル名のルール

マイグレーションファイルのファイル名は以下のように、**V**で始まり{バージョン}と{説明}を含む。{バージョン}と{説明}は２つのアンダースコアで連結する。
[公式ドキュメント](https://flywaydb.org/documentation/migrations#naming)

```
V{バージョン}__{説明}.sql
```

具体的な例は以下の通り。
```
V1_create_users_table.sql
V2_create_recipe_table.sql
```

## マイグレーションファイルの例

```sql
CREATE TABLE `users`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `name`      varchar(255) NOT NULL,
    `email`     varchar(255) NOT NULL,
    `is_active` tinyint(1)   NOT NULL DEFAULT '1',
    `password`  varchar(255) NOT NULL DEFAULT 'aaa',
    `login_id`  varchar(255) NOT NULL,
    `role`      varchar(32)  NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
```

# マイグレーションファイルを実行する。

デフォルトではSpring Bootアプリケーションの起動時に自動的にマイグレーションファイルがバージョン順に実行される。
ただし、一度実行されたマイグレーションファイルは実行されない。

# flyway_schema_historyテーブルを確認する。

flywayによりマイグレーションが実行されると、flyway_schema_historyテーブルが自動的に作成される。
このテーブルがマイグレーションファイルの実行履歴を管理する。
