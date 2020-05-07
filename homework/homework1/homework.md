# ２つの数値の和を求めるプログラム Sum.java を作成せよ。

## 実行例 {.unnumbered}

```bash
>java Sum 1 2
3
>java Sum 3 5
8
```
# 複数の数値の合計を求めるプログラム Total.java を作成せよ。

## 実行例 {.unnumbered}

```bash
>java Total 1 2
3
>java Total 2 3 4
10
>java Total 
0
```
 
# 複数の数値の平均値を求めるプログラム Average.java を作成せよ。

## 実行例 {.unnumbered}
```bash
>java Average 1 2
1.5
>java Average 2 4 20
13
```
# 入力した文字列をすべて連結した文字列を表示するプログラム Concat.java を作成せよ。 

## 実行例 {.unnumbered}
```bash
>java Concat abc edf  
abcedf
>java Concat i love java   
ilovejava
```

# 入力した数値を小さい順にソートして表示するプログラム Sort.java を作成せよ。

## 実行例 {.unnumbered}
```bash
>java Sort 3 2 10 5 20 13 
2 3 5 10 13 20
>java Sort 100 50 30 20 10 
10 20 30 50 100
```

# 以下のような、四則演算（足し算、引き算、掛け算、割り算）可能な計算プログラム Calc.java を作成せよ。１つ目の入力値に、演算記号、２つ目と３つ目に数値を入力できること。演算記号は、「+」が足し算、「-」が引き算、「m」が掛け算、「/」が割り算を表すものとする。

## 実行例 {.unnumbered}
```bash
>java Calc + 1 2
3
>java Calc - 3 1
2
>java Calc m 3 5
15
>java Calc / 4 2
>2
```

# フルーツ名と価格が記載された下のCSVファイル（fruits.csv)がある。
```
りんご,200
バナナ,100
みかん,150
ぶどう,300
もも,400
```

## フルーツの名前を入力すると、その価格を返すプログラム、Fruits.java を作成せよ。

### 実行例 {.unnumbered}
```bash 
>java Fruits りんご  
200
>java Fruits ぶどう
300
```

## フルーツの名前を複数入力すると、それらのフルーツの価格の平均値を求めるプログラム FruitsAvg.java を作成せよ。

### 実行例 {.unnumbered}
```bash
>java FruitsAvg ぶどう みかん
225
>java FruitsAvg りんご ぶどう もも
300
```

## 価格を入力するとその価格以上のフルーツのリストを出力するプログラム SearchFruits.java を作成せよ。

### 実行例 {.unnumbered}

```bash
>java SearchFruits 200  
りんご、ぶどう、もも
>java SearchFruits 400
もも
>java SearchFruits 500
```
