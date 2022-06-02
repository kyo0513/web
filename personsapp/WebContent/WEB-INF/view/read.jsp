<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%
List<Persons> list=(List<Persons>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/personsapp/Create">新規追加</a>
<%if(list !=null && list.size()>0){ %>
<table border="1">

<%for(Persons persons:list){ %>
<tr>
<td><%=persons.getId() %></td>
<td><%=persons.getName() %></td>
<td><%=persons.getAge() %></td>
<td>
<a href="/personsapp/Update?id=<%=persons.getId() %>">更新</a>
<a href="/personsapp/Delete?id=<%=persons.getId() %>" onclick="return confirm('id=<%=persons.getId()%>を削除してよろしいですか？');">削除</a>
</td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>