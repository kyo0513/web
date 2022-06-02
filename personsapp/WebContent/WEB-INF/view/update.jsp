<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
Persons persons=(Persons)request.getAttribute("persons");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/personsapp/Update" method="Post">
名前:<input type="text" name="name" value="<%= persons.getName() %>"><br>
年齢:<input type="text" name="age" value="<%= persons.getAge() %>"><br>
<input type="hidden" name="id" value="<%=persons.getId() %>">
<button type="submit">更新</button>
</form>
</body>
</html>