<%-- pruebaVariable2 --%>
<%-- Martin Mancini --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<% int x = 3; %>
<h1><% out.print(x); %>hola<% out.print(x); %></h1>
</body>
</html>