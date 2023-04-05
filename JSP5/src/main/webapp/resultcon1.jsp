<%-- resultcua.jsp (proyecto Incrementa5) --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
El valor en dolares son 
<%
double resultado;
resultado = Double.parseDouble(request.getParameter("numeroIntro")) * 1.08 ;
out.print(resultado + " Dolares");
%>
</body>
</html>