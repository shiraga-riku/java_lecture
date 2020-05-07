# 整数のペア(2つの値の組、順序保存)を保持できるクラス```Pair```を作成せよ。

## 使用例 {.unnumbered}

```java
Pair p = new Pair(1,2);
int first = p.first(); //1
int second = p.second(); //2
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

# JUnit4のソースコードを読み、デザインパターンが適用 されている箇所を3つ抽出せよ
[参照](https://github.com/junit-team/junit4) 

# SOLID原則と呼ばれる設計原則について調べてみよ。


