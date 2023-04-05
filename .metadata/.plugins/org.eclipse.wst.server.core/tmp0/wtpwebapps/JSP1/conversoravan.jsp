<%-- areacuadrado.jsp --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Conversor de Monedas</h1>
El cambio actual es:
<p>1 euro = 1,09 dolares</p>
<p>1 euro = 5.056,38 pesos colombianos</p>
<p>1 euro =  4,20 soles peruanos</p>
<p>1 euro = 11,10  dirham</p>
<p>1 euro = 74,24  rublos</p>
<form method="get" action="Cambio.jsp">
Pon la cantidad que quieres cambiar:
<input type="text" name="numeroIntro">
<p>En que moneda la quieres 
<input type ="button" name="dolares" value="Dolares">
<input type ="button" name="Rublos" value="Rublos">
<input type ="button" name="Pesos" value="Pesos">
<input type ="button" name="Soles" value="Soles">
<input type ="button" name="Dirham" value="Dirham">
</p>
</form>
</body>
</html>