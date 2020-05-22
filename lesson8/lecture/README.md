JDBC/Domaの基本サンプルプログラム
================================

# Docker起動

```
$ docker-compose up -d
```

# JDBCサンプルの実行

## コンパイル・jar生成

```
$ docker-compose run jdk mvn clean package -f jdbc/pom.xml
```

## 生成したjarの実行

```
$ docker-compose run jdk java -jar jdbc/target/jdbc-1.0-SNAPSHOT-jar-with-dependencies.jar 
```

# Domaサンプルの実行

## コンパイル・jar生成

```
$ docker-compose run jdk mvn clean package -f doma/pom.xml
```

## 生成したjarの実行

```
$  docker-compose run jdk java -jar doma/target/doma-1.0-SNAPSHOT-jar-with-dependencies.jar  
```

