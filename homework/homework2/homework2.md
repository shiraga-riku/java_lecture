# 整数のペア(2つの値の組、順序保存)を保持できるクラス```Pair```を作成せよ。

## 使用例 {.unnumbered}

```java
Pair p = new Pair(1,2);
int first = p.first(); //1
int second = p.second(); //2
```

## 発展課題（余裕があれば）  {.unnumbered}

```Pair```を任意の型の組を保持できるようにせよ。

```java
var p = new Pair(1,"foo");
int first = p.first(); //1
String second = p.second(); //foo

var p = new Pair(true, new Pair(1,2));
boolean first = p.first();
var second = p.second();
int secondFirst = second.first(); //1
int secondSecond = second.second(); //2
```

# 与えられた整数のリスト```List```から偶数のみを抽出するメソッド```evensof```を```ListUtil```クラスに作成せよ。

## 使用例 {.unnumbered}

```java
List<Integer> intList = List.of(1,2,3,4,5,6)
List<Integer> evens = ListUtil.evensOf(intList); //2,4,6
```

# 指定した大きさと文字列のみからなるリスト```List```を生成するメソッド```replicate```を```ListUtil```クラスに作成せよ。

## 使用例 {.unnumbered}

```java
List<String> hogeList = ListUtil.replicate(3, “hoge”); //大きさ3で全ての要素が文字列”hoge”のリストを生成する。
List<String> hogeList = ListUtil.replicate(2, “java”); //大きさ2で全ての要素が文字列”java”のリストを生成する。
```

# 二つの整数のリスト```List```を受け取り、それぞれのリストの対応する要素をペア```Pair```とするリストを返すメソッド```zip```を```ListUtil```クラスに作りなさい。ただし、リストのサイズが異なる場合は、小さいリストのサイズに合わせること。

## 実行のイメージ {.unnumbered}
```java
ListUtil.zip(List.of(1,2,3), List.of(2,3,4));// [(1,2), (2,3), (3,4)]
ListUtil.zip(List.of(1,2,3), List.of(10,9)); //[(1,10), (2,9)]
```

# 与えられた数の約数を求めてリストとして返すメソッド```factors```を```ListUtil```クラスに作成せよ。

## 実行のイメージ {.unnumbered}
```java
ListUtil.factors(15); //[1, 3, 5, 15]
ListUtil.factors(7); // [1, 7]
```

# 自分自身を除く約数の和が自分自身と等しい時、その数を完全数とよぶ。与えられた数を上限とし、その数までの完全数の一覧をリスト```List```として返すメソッドを```ListUtil```クラスに作成せよ。メソッド名は```perfects```とせよ。ただし、上記で作成したfactorsメソッドを利用すること。

## 実行のイメージ {.unnumbered}

```java
ListUtil.perfects(500) --> [6, 28, 496]
```

# 整数のリスト```List```を受け取り、隣あう要素をペア```Pair```とするリストを返すメソッドを```ListUtil```クラスに作成せよ。メソッド名は、```pairs```とせよ。

## 実行のイメージ {.unnumbered}

```java
ListUtil.pairs(List.of(1,2,3,4));  // [(1,2), (2,3), (3,4)]
ListUtil.pairs(List.of("a", "b", "c")); // [("a","b"), ("b","c")]
```

# 与えられた整数のリスト```List```が、昇順にソートされていれば```true```を返し、そうでなければ```false```を返すメソッドを```ListUtil```クラスに作成せよ。メソッド名は、```sorted```とせよ。ただし、上記で作成した```pairs```メソッドを利用すること。

## 実行のイメージ {.unnumbered}
```java
ListUtil.sorted(List.of(1,2,3,4)); //true
ListUtil.soreted(List.of(3,2,5,6)); //false
```
# 整数のリストと整数値を受け取り、その値のリスト内の位置（インデックス）をリストとして返すメソッドを```ListUtil```クラスに作成せよ。メソッド名は```positions```とせよ。ただし、上記で作成した```zip```メソッドを利用せよ。

## 実行のイメージ {.unnumbered}
```java
ListUtil.positions(10 List.of(10, 15, 20, 10, 10, 33)); //[0,3,4]
ListUtil.positions(3, List.of(1, 2, 3, 4, 5]); //[2]
```

# ２つのベクトル（リスト）の内積は対応する各要素の積の和で表せる。```[1,2,3]```と```[4,5,6]```の内積は、```1*4 + 2*5 + 3*6```である。２つのリストを受け取りその内積を計算するメソッド```scalarProduct```を```ListUtil```に実装せよ。

## 実行のイメージ {.unnumbered}
```java
ListUtil.scalarProduct(List.of(1,2,3), List.of(4,5,6)); // 32
``` 
# ４つの整数のリスト```List```を受け取り、４つ組のリストに変換するメソッド```zip4```を```ListUtil```クラスに作成せよ。ここで、４つ組```(1,2,3,4)```は```new Pair(1, new Pair(2, new Pair(3,4)))```で表されるものとする。

## 実行のイメージ {.unnumbered}
```java
var tetrads = ListUtil.zip4(List.of(1,2,3), List.of(10,20,30), List.of(100,200,300), List.of(1000,2000,3000));
var firstTetrad = tetrads.get(0);  //リストの最初の４つ組
var first = firstTetrad.first(); //1
var tuple = firstTetrad.second(); 
var second = tuple.first(); //10
var pair = tuple.second(); 
var thrid = pair.first(); //100
var fourh = pair.second(); //1000
```

new Pair(1, new Pair(2)) 

# 3目並べのプログラム```ThreeInRow```を途中まで作成した。これを完成させよ。3目並べのルールは[wiki](https://ja.wikipedia.org/wiki/%E4%B8%89%E7%9B%AE%E4%B8%A6%E3%81%B9)を参照。

## 満たすべき仕様 {.unnumbered}

以下のステップでできるところまで実装してみよ。

* ステップ１）先手・後手とも人がプレイヤーとなって対戦できる。
* ステップ２）人が先手、コンピュータが後手として対戦できる。
* ステップ３）人の先手・後手を選択できる。
* ステップ４）コンピュータのアルゴリズム（次の手の計算方法）を切り替えられる。
* ステップ５）JavaFXなどを使ってGUIゲームにする。

## 途中まで作成したプログラム {.unnumbered}

```java
import java.util.Scanner;

/**
* このような入力値の評価と出力を繰り返すプログラムをREPL(Read, Eval, Print, Loop)と呼ぶ。
*/
public class ThreeInRow
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("何か入力してください:");
            var line = sc.nextLine();
            if (line.equals("quit")) {
                System.out.print("bye");
                break;
            }
            System.out.println(line);
        }
    }
}
```

## 実行のイメージ {.unnumbered}
```shell
３目並べにようこそ
先手・後手を選んでください。先手(1),後手(2):1

次の手を入力してください(行 列):0 0
×−−
−−−
−−−

コンピュータの番です...(0 1)
×○−
−−−
−−−

次の手を入力してください(行 列):1 1
×○−
−×−
−−−

コンピュータの番です...(0 2) 
×○○
−×−
−−−

次の手を入力してください(行 列):2 2
×○○
−×−
−−×
先手の勝ち!
```

