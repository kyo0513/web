
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*" %>
<%
User registerUser = (User) session.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<p>下記のユーザーを登録します</p>
<p>
名前:          <%= registerUser.getName() %><br>
メールアドレス:<%= registerUser.getMeil()   %><br>
お問い合わせ内容:<%= registerUser.getQuery() %><br>
</p>
<a href="/sessionex2/RegisterUser">戻る</a>
<a href="/sessionex2/RegisterUser?action=done">登録</a>
</body>
</html>