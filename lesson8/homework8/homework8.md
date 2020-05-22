# homework7の課題と同じSQLをJDBCを使って実装してみよ。

# homework7で課題と同じSQLをDoma2を使って作成してみよ。

# Doma2を使い、homework7で作成したデータベースに新しい原材料を登録するコマンドラインプログラムを作成せよ。

## 実行例

```
$ java -jar doma.jar MATERIAL 豆腐 20 //豆腐 20kcalを登録
id=20  //登録後の自動採番された原材料IDを表示
$ java -jar doma.jar MATERIAL ごま 10 //ごま 20kcalを登録
id=21 //登録後の自動採番された原材料IDを表示
```

# Doma2を使い、homework7で作成したデータベースに新しいレシピを登録するコマンドラインプログラムを作成せよ。

```
$ java -jar doma.jar RECIPE 肉豆腐 20:90 15:13 //レシピ名が肉豆腐で、原材料ID20が90g、原材料ID15が13g
id=8 //登録後の自動採番されたレシピIDを表示
$ java -jar doma.jar RECIPE ごまサラダ 21:30 12:40 5:30  //レシピ名がごまサラダで、原材料ID21が30g、原材料ID14が40g、原材料ID5が30g
id=9 //登録後の自動採番されたレシピIDを表示
```

