<%-- resultEj1.jsp --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<%
double resultado;
double numero1;
double numero2;
double numero3;
numero1 = Double.parseDouble(request.getParameter("numero1"));
numero2 = Double.parseDouble(request.getParameter("numero2"));
numero3 = Double.parseDouble(request.getParameter("numero3"));
resultado = (numero1 + numero2 + numero3)/3;
if(resultado >= 5){
	out.print("La media es " + resultado + " y esta aprobado");
}else if(resultado < 5){
	out.print("La media es "+ resultado + " y esta suspenso");
}
%>
</body>
</html>