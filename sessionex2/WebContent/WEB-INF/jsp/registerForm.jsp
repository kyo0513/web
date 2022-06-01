
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*" %>
<%
User user=(User)session.getAttribute("registerUser");
String meil  =(user==null) ?"":user.getMeil();
String query=(user==null) ?"":user.getQuery();
String name=(user==null) ?"":user.getName();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
<link rel="stylesheet" href="/sessionex2/css/main.css">
</head>
<body>
<h1>お問い合わせフォーム</h1>

<div id="container">
<form action="/sessionex2/RegisterUser" method="post">
<table border="1">
<tr>
<td class="pink" >名前:</td>
<td><input type="text" name="name" value="<%=name %>"></td>
</tr>
<tr>
 <td>メールアドレス:</td>
 <td><input type="text" name="meil" value="<%=meil %>"></td>
</tr>
<tr>
 <td>お問い合わせ内容:</td>
 <td><textarea name="query"><%=query%></textarea></td>
</tr>
</table>

<input type="submit" value="確認">
</form>
</div>
</body>
</html>