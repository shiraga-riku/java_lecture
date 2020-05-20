# homework2で作成した```ListUtil```を含むプログラムをStreamとラムダ式使ってリファクタリングしてみよ。単体テストを実行しながらリファクタリングすること。

# homework3で作成した```MenuSpec```はメソッドを１つだけ含むファンクショナルインターフェースである。```MenuSet```クラスの```getMenusBySpec```に以下のラムダ式を引数として渡して実行せよ。

1. 和食のメニューのみを抽出するラムダ式。
2. 100Kカロリー以上のメニューを抽出するラムダ式。
3. 和食かつ100Kカロリー以上のメニューを抽出するラムダ式。

# ```java.util.function.Function<T,R>```は１つの値を受け取り別の値を返す関数を表すファンクショナルインターフェースである。```FunctionSample```クラスのメイン関数にこのインターフェースの以下のラムダ式を変数に代入せよ。また、定義したラムダ式を実行してみよ。

1. 文字列を受け取り、その長さを返すラムダ式。
2. 文字列を受け取り、大文字のみの文字列を返すラムダ式。
3. 数値を受け取り、数値が偶数ならばtrue、それ以外ならばfalseを返すラムダ式。
4. boolean値を受け取り、trueならば1、それ以外ならば0を返すラムダ式。
5. 3.と4.を合成したラムダ式。```Function<T,R>```インターフェースのデフォルトメソッドを利用すること。
6. homework3で作成したメニュー```Menu```オブジェクトを受け取り、そのカロリーを返すラムダ式。
7. homework3で作成したメニュー```Menu```オブジェクトを受け取り、そのメニューを構成するレシピ名のリストを返すラムダ式。
 
# ```java.util.function.Predicate<T>```は１つの値がある条件を満たす場合にtrueとなる関数（述語）を表すファンクショナルインターフェースである。このインターフェースの以下のラムダ式を定義せよ。```PredicateSample```クラスのメイン関数にこのインターフェースの以下のラムダ式を変数に代入せよ。また、定義したラムダ式を実行してみよ。
 
1. 文字列を受け取り、その文字列が大文字のみならばtrueを返すラムダ式。
2. 文字列を受け取り、其の文字列が小文字のみならばtrueを返すラムダ式。
3. 数値を受け取り、その数値が3の倍数ならばtrueを返すラムダ式。
4. 数値を受け取り、その数値が5の倍数ならばtrueを返すラムダ式。
5. 数値を受け取り、その数値が15の倍数ならばtrueを返すラムダ式。```Predicate<T>```のデフォルトメソッドを利用すること。
6. homework3で作成したメニュー```Menu```オブジェクトを受け取り、和食ならばtrueを返すラムダ式。
7. homework3で作成したメニュー```Menu```オブジェクトを受け取り、100Kカロリー以上ならばtrueを返すラムダ式。
8. homework3で作成したメニュー```Menu```オブジェクトを受け取り、和食かつ100Kカロリー以上ならばtrueを返すラムダ式。