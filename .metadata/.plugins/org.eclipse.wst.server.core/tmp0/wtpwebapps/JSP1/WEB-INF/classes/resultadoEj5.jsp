<%-- resultEj5.jsp --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
0,1,
<%
int ultimo = Integer.parseInt(request.getParameter("ultimo"));
int resultado = 0;
int cero = 0;
for(int i = 1; i <= ultimo; i++){
	resultado = resultado + i;
	out.print(resultado +",");
}

%>
</body>
</html>