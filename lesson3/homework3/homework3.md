# お惣菜を表すレシピクラス```Recipe```を作成せよ。レシピクラスは、お惣菜名（文字列）とカロリー（Kcal、実数）をデータとして持つ。レシピクラスのメソッドは以下の通り。

|メソッド|振舞い|
|:-:|:-:|
|コンストラクタ|惣菜名とカロリーを受取ってレシピインスタンスを生成する|
|getName|お惣菜名を返す|
|getCal|お惣菜のカロリーを返す|

## 使用例 {.unnumbered}

```java
Recipe r1 = new Recipe("ハンバーグ", 200.5);
Recipe r2 = new Recipe("サーモン", 120);

System.out.println(r1.getName()); //ハンバーグ
System.out.println(r1.getCal()); //200.5
```

# 献立を表す献立クラス```Menu```を作成せよ。献立クラスは、献立名、献立タイプ、レシピオブジェクトの集合データとして持つ。献立クラスのメソッドは以下の通り。

|メソッド|振舞い|
|:-:|:-:|
|コンストラクタ|献立名、献立タイプ、レシピのリスト```Lsit```を受取って献立インスタンスを生成する|
|getName|献立名を返す|
|getType|献立タイプを返す|
|getRecipes|献立が持つすべてのレシピをリスト```List```として返す|
|getCal|献立のカロリー、すなわち、献立が持つ全てのお惣菜のカロリー合計、を返す|

ここで、献立タイプは```"和食", "洋食", "中華"```のいずれかの文字列で表されるものとする。

## 使用例 {.unnumbered}

```java
Recipe r1 = new Recipe("ハンバーグ", 200.5);
Recipe r2 = new Recipe("目玉焼き", 120);

Menu menu = new Menu("ハンバーグ弁当", "洋食", List.of(r1, r2));
System.out.println(menu.getName()); //ハンバーグ弁当
System.out.println(menu.getType()); //洋食
System.out.println(menu.getCal()); //320.5
System.out.println(menu.getRecipes().get(0).getName()); //ハンバーグ
```

# 前回の課題で作成した、四則演算（足し算、引き算、掛け算、割り算）可能な計算プログラム```Calc.java```を演算子のポリモルフィズムを用いて改良せよ。

# 献立インスタンスを複数保持する献立集合クラス```MenuSet```を作成せよ。献立集合クラスは、献立インスタンスのリストをデータとして持つ。献立集合クラスのメソッドは以下の通り。

|メソッド|振舞い|
|:-:|:-:|
|コンストラクタ|献立インスタンスのリストを受け取り、献立集合インスタンスを生成する|
|getMenus|献立インスタンスのリストを返す|

## 使用例 {.unnumbered}

```java
Menu menu1 = new Menu("ハンバーグ弁当", "洋食", List.of(r1, r2));  //r1とr2はレシピインスタンスとする
Menu menu2 = new Menu("鮭弁当", "和食", List.of(r3, r4)); //r3とr4はレシピインスタンスとする
MenuSet menuSet = new MenuSet(List.of(menu1, menu2));
var menus = menuSet.getMenus(); //メニュー一覧を取得
```

# 献立集合クラス```MenuSet```に指定した献立タイプのメニューリスト```List```のみを返すメソッド```getMenusByType```を追加せよ。

## 使用例 {.unnumbered}

```java
Menu menu1 = new Menu("ハンバーグ弁当", "洋食", List.of(r1, r2));  //r1とr2はレシピインスタンスとする
Menu menu2 = new Menu("鮭弁当", "和食", List.of(r3, r4)); //r3とr4はレシピインスタンスとする
Menu menu3 = new Menu("のり弁当", "和食", List.of(r4, r5)); //r4とr5はレシピインスタンスとする
MenuSet menuSet = new MenuSet(List.of(menu1, menu2, menu3));
var menus = menuSet.getMenusByType("和食"); //menusは、menu2とmenu2のみのリスト
```

# 献立集合クラス```MenuSet```に指定したカロリー以上のメニューリスト```List```のみを返すメソッド```getMenusByOverCalorie```を追加せよ。

## 使用例 {.unnumbered}

```java
Menu menu1 = new Menu("ハンバーグ弁当", "洋食", List.of(r1, r2));  //r1とr2はレシピインスタンスとする
Menu menu2 = new Menu("鮭弁当", "和食", List.of(r3, r4)); //r3とr4はレシピインスタンスとする
Menu menu3 = new Menu("のり弁当", "和食", List.of(r4, r5)); //r4とr5はレシピインスタンスとする
MenuSet menuSet = new MenuSet(List.of(menu1, menu2, menu3));
var menus = menuSet.getMenusByCalorie(100); //menusは、100カロリー以上の献立のリスト
```

# 上のように、それぞれの条件ごとにメニューの抽出メソッドを追加するのは汎用的ではない。献立集合クラス```MenuSet```に、任意の条件を満たす献立リスト```List```を返すメソッド```getMenusBySpec```を追加せよ。

## ヒント {.unnumbered}

* ```getMenusBySpec```は以下のような条件を表すインターフェースを受け取り、この条件を満たすメニューのみを返すと考える。
```java
/**
 * 献立の仕様。
 */
interface MenuSpec {  
  /**
   * 献立がある条件を満たせばtrueを返す。
   * @param menu 献立
   */
  public boolean satisfiedBy(Menu menu);
}
```
* このインターフェースを実装する具象クラスを切り替えれば、条件を変更することができる。
* 具象クラスとして、メニュータイプを条件とする```MenuBySpec```と、指定カロリー以上を条件とする```CalorieOverSpec```を実装せよ。

## 使用例 {.unnumbered}

```java
Menu menu1 = new Menu("ハンバーグ弁当", "洋食", List.of(r1, r2));  //r1とr2はレシピインスタンスとする
Menu menu2 = new Menu("鮭弁当", "和食", List.of(r3, r4)); //r3とr4はレシピインスタンスとする
Menu menu3 = new Menu("のり弁当", "和食", List.of(r4, r5)); //r4とr5はレシピインスタンスとする
MenuSet menuSet = new MenuSet(List.of(menu1, menu2, menu3));
var menus1 = menuSet.getMenusBySpec(new MenuTypeSpec("和食")); //和食のみのメニュー一覧を抽出
var menus2 = menuSet.getMenusBySpec(new CalorieOverSpec(100));  //100カロリー以上のメニュー一覧を抽出
```

# 上記のメニュー仕様インターフェース```MenuSpec```を実装する以下の具象クラスを作成してみよ。

|クラス|振舞い|
|:-:|:-:|
|AndSpec|２つの```MenuSpec```が満たす場合にのみ```true```となる条件。論理積|
|OrSpec|２つの```MenuSpec```のいずれかを満たす場合にのみ```true```となる条件。論理和|
|NotSpec|```MenuSpec```が満たさない場合にのみ```true```となる条件。否定|

## 使用例 {.unnumbered}

```java
Menu menu1 = new Menu("ハンバーグ弁当", "洋食", List.of(r1, r2));  //r1とr2はレシピインスタンスとする
Menu menu2 = new Menu("鮭弁当", "和食", List.of(r3, r4)); //r3とr4はレシピインスタンスとする
Menu menu3 = new Menu("のり弁当", "和食", List.of(r4, r5)); //r4とr5はレシピインスタンスとする
MenuSet menuSet = new MenuSet(List.of(menu1, menu2, menu3));
var menus = menuSet.getMenusBySpec(new AndSpec(new MenuTypeSpec("和食"), new CalorieOverSpec(100)));  //和食かつ100カロリー以上のメニュー一覧を抽出
```

# JUnit4のソースコードを読み、デザインパターンが適用 されている箇所を3つ抽出せよ
[参照](https://github.com/junit-team/junit4) 

# SOLID原則と呼ばれる設計原則について調べてみよ。


