# homework2で作成した```ListUtil```を含むプログラムのパッケージを```jp.co.aivick.homework3```にしてみよ。

# 上記のパッケージ化したプログラムのjarファイル```homework2```を生成してみよ。

# 生成したjarを実行してみよ。

## 実行例 {.unnumbered}

```bash
$java -jar homework3
//以下は実行結果
```
# 生成したjarに含まれる```ListUtil```クラスを利用するプログラムを作成し、それを実行してみよ。

# homework2で作成したペアクラス```Pair```を任意の型が保持できるジェネリッククラスにせよ。

# HTTPステータスコードは、HTTPリクエストの結果を表す。結果に応じた多種のステータスコードが定義されている。プログラムの引数として、ステータスコードを与えるとそのメッセージを返すクラス```StatusCode```を作成せよ。ステータスコードは[MDN](https://developer.mozilla.org/ja/docs/Web/HTTP/Status)を参考にせよ。ただし、全てのコードではなく、上記から選んだ任意の10個のコードで良い。

## 実行例 {.unnumbered}

```bash
$java StatusCode 200
OK
$java StatusCode 404
Not Found
```

# コレクションフレームワークには[```Stack```クラス](https://docs.oracle.com/javase/jp/13/docs/api/java.base/java/util/Stack.html)がある。Stack（スタック）とはLIFOを実現する抽象データ型[wiki](https://ja.wikipedia.org/wiki/スタック)である。標準ライブラリの```Stack```と同じ振舞いをする```MyStack```を独自に実装してみよ。

# 指定されたテキストファイルの中に含まれる文字をカウントして集計して降順に出力するクラス```CountCharacter```を作成せよ。

## 実行例 {.unnumbered}

```bash
$java CountCharacter /tmp/something.txt
a 200
b 100
z 50
あ 10
```

# 与えられたディレクトリパスの中から指定された文字列を含むファイルを検索するクラス```Grep```を作成せよ。

## 仕様 {.unnumbered}

* パラメータとしてディレクトリパスと検索文字列を受け取る。
* 指定されたディレクトリのサブディレクトリも再帰的に検索する。
* 探索ファイルはテキストファイルのみを対象とすればよい。
* 対象文字列を含むファイルの絶対パス、および、その文字列の行番号のリストを出力すること。 

## 実行例 {.unnumbered}

```bash
$java Grep /tmp/ abc 
/tmp/hoge.txt 123 350 
/tmp/foo.txt 20
/tmp/subdir/piyo.txt 12 55
```

# 上記で作成したペアクラス```Pair```は任意の型を保持できるが、数値の型だけが保持できる```NumPair```クラスを作成してみよ。ヒント：型パラメータは、境界付けることができる。数値の基底クラスは```Number```クラスである。[Qiita](https://qiita.com/pebblip/items/1206f866980f2ff91e77)
