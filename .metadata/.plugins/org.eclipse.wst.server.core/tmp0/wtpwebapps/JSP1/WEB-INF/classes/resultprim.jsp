<%-- resultprim.jsp (proyecto Incrementa5) --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style> .red {color:red} </style>

</head>
<body>
( Los primos estan en rojo)
<br>
Los numeros generados son:
<br>
<%
int resultado;
for(int i = 0; i <= 100; i++){
resultado = (int)(Math.random()*200 +1);
if(resultado / 1 == resultado && resultado / resultado == 1 && resultado % 2 == 0 ){
	out.print(resultado + "\n");
}else{
	out.print("<span class=\"red\">" + resultado + "</span>" + "\n");
}
}
%>
</body>
</html>