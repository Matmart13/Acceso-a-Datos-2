<%-- resultEj2.jsp --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<%
int[] matriz = {8,3,8,6,1,4,5,7,8,2};
int mayor = 0;
int contador = 0;
for(int i = 0; i< matriz.length; i++){
	for(int j = matriz.length-1; j>=0;j--){
		if(matriz[i]>matriz[j] ){
			mayor = matriz[i];
			if(matriz[i] == matriz[j]){
				contador = contador +1;
				i = i +1;
			}
		}else{
			i = i+1;
		}
	}
}
out.print("El mayor es " + mayor );
%>
</body>
</html>