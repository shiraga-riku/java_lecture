# mavenことはじめ

## mavenコンテナを立ち上げる。

```
$ docker-compose up -d
$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS               NAMES
92999bacbda7        mvnlecture_dev      "/usr/local/bin/mvn-…"   9 seconds ago       Up 8 seconds                            mvnlecture_dev_1
```

## mavenコンテナにアタッチ。

```
$ docker-compose exec dev bash
bash-4.2#
bash-4.2# pwd
/local/app
bash-4.2# ls
docker-compose.yml  Dockerfile
```

## mavenコンテナ内でmvnコマンドを実行してmavenプロジェクトを作成する。

```
bash-4.2# mvn archetype:generate -DarchetypeArtifiactId=maven-archetype-quickstart -DinteractiveMode=false -DgroupId=aivick -DartifactId=mavenlecture
--- 中略 --- 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:12 min
[INFO] Finished at: 2020-05-14T15:09:03Z
[INFO] ------------------------------------------------------------------------
bash4.2# ls
docker-compose.yml  Dockerfile mavenlecture
```
## 生成された```pom.xml```を確認する。

```
bash-4.2# cd mavenlecture/
bash-4.2# cat pom.xml 
<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>aivick</groupId>
  <artifactId>mavenlecture</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>mavenlecture</name>
  <url>http://maven.apache.org</url>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

</project>
```

## 初期生成されているプログラム```App.java```と```AppTest```は削除する。

## Javaのコンパイルバージョンを13に変更する。

以下の設定を```pom.xml```に追加する。

```xml
<build>
    <pluginManagement>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.1</version>
          <configuration>
            <release>13</release>
          </configuration>
        </plugin>
      </plugins>
    </pluginManagement>
</build>
```

## サンプルプログラムを作成する。

```java
package aivick;

public class Sum
{
    public static void main(String[] args) {
        System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
    }
}
```

## mvnコマンドでコンパイルしてみる。

```
bash-4.2# mvn compile
bash-4.2# ls target
classes  generated-sources  maven-status
```

## mvnコマンドでjarを生成してみる。

```
bash-4.2# mvn package
bash-4.2# ls target
classes  generated-sources  generated-test-sources  maven-archiver  mavenlecture-1.0-SNAPSHOT.jar  maven-status
```

## 生成したjarを実行してみる。

```
bash-4.2# java -cp target/mavenlecture-1.0-SNAPSHOT.jar aivick.Sum 1 2
3
```

## jar作成時にManifestファイルを作成するようにビルド方法を変える。

以下のプラグインを```pom.xml```に追加する。

```xml
<plugin>
   <groupId>org.apache.maven.plugins</groupId>
   <artifactId>maven-jar-plugin</artifactId>
   <version>3.2.0</version>
   <configuration>
     <archive>
       <manifest>
         <mainClass>aivick.Sum</mainClass>
       </manifest>
     </archive>
   </configuration>
</plugin>
```

## 生成したjarを再度実行してみる。

今度はクラスを指定する必要がない。

```
bash-4.2# java -jar target/mavenlecture-1.0-SNAPSHOT.jar 1 2
3
```

# JUnitことはじめ

## ```pom.xml```にJUnit5を設定する。

```xml
  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-engine</artifactId>
      <version>5.6.2</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
```

```xml
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.0</version>
      </plugin>
    </plugins>
  </build>
```

## 単体テストを書いてみる。

### テスト対象のクラス

```src/main/java/aivick```に以下のクラスを作成する。

```java
package aivick;

public class Sum
{
    public static int sum(int x, int y) {
        return x + y;
    }
}
```

### テストクラス

```src/test/java/aivick```に以下のクラスを作成する。

```java
package aivick;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SumTest
{
    @Test
    void 足し算できること() {
        int actual = Sum.sum(1, 2);
        assertEquals(3, actual);
    }
}
```

## テストを実行してみる。

```
bash-4.2# mvn test
//省略
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.853 s
[INFO] Finished at: 2020-05-14T23:53:56Z
[INFO] ------------------------------------------------------------------------
```






