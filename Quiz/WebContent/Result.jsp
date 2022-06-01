<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String ans=request.getParameter("ans");
    String path="laugh.png";
    String msg="正解！";
    if(!ans.equals("634")){
    	path="cry.png";
    	msg="残念、、、正解は634ｍ";
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Quiz/css/main.css">
</head>
<body>
<div id="container">
 <div id="boxA">
 <p><%=msg %></p>
 <a href="/Quiz/index.html">もう一度</a>
  <form action="/Quiz/Result.jsp" method="post">

  <!--  -->
  <input type="text" name="ans">
  <input type="submit" value="送信">

 </form>
 </div>
 <div id="boxB">
 <div class="imgBox">
 <img src="/Quiz/imges/<%=path %>" alt=""   >
 </div>
 </div>
</div>

</body>
</html>