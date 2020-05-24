<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First Web Application</title>
</head>
<body>
<h2>JSPとは</h2>
<p>
    JSP(Java Server Page)は動的にWebページ（HTML）を生成する仕様・技術。
    HTTPリクエストを受け付けると、HTMLの中に埋め込まれたJavaコードが実行される。
    内部的には、JSPはサーブレットに変換されており、サーブレットと同等の機能を持つ。
</p>

<h3>JSPファイルの特徴</h3>
<ul>
    <li>リクエストを受け付けて実行される</li>
    <li>様々なJSPタグやEL式を使ってHTMLの中にコードを埋め込む</li>
</ul>

<h2>JSPタグ</h2>
<p>
    JSPの中で利用できる特殊なタグ。カスタムタグを作成することもできる。
</p>
<div>
    <img src="/firstweb/jsptag.png" width="50%">
</div>
※ Wikiからの抜粋。

<h3>JSTL</h3>

JSTL（JavaServer Pages Standard Tag Library、JSP標準タグライブラリ）は、JSPでよく用いられる標準的な機能を定義したカスタムタグライブラリである。

<ul>
    <li><a href="https://tomcat.apache.org/taglibs/standard/apidocs/">APIの公式ドキュメント</a></li>
    <li><a href="http://struts.wasureppoi.com/jstl/00_jstl.html">参考</a></li>
</ul>
<h2>EL式</h2>

EL式（Expression Language、式言語）を使うと、JSPタグよりも簡潔にコードを記述できる。

<ul>
    <li><a href="http://www.ne.jp/asahi/hishidama/home/tech/java/jsp/el.html">参考</a></li>
</ul>

</body>
</html>
