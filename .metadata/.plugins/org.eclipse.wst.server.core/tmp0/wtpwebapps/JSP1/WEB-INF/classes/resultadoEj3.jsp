<%-- resultEj5.jsp --%>
<%@page cont3ntType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
int altura = Integer.parseInt(request.getParameter("altura"));
String simbolo = request.getParameter("simbolo");
String blanco = ("<br>");
int mitad = altura/2;
for (int i = 1; i < altura; i = i+1) {
	for (int j = 0; j < i; j++) {
		if(j < mitad + i && j > mitad -i){
			out.print(simbolo);
		}
		else{
			out.print(blanco);
		}
	}
	out.print(blanco);
}
%>
</body>
</html>