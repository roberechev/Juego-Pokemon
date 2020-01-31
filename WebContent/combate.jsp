<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td></td>
			<td></td>
			<td>
				<%
					String imagenP1 = "<img width=\"150px\" src=\"" + (String) request.getAttribute("ruta") + "\"/>";
					out.print(imagenP1);
				%>
			</td>
		</tr>
		<tr>
			<td>
				<%
					String imagenP2 = "<img width=\"150px\" src=\"" + (String) request.getAttribute("pokemonSeleccionado")
							+ "\"/>";
					out.print((String) request.getAttribute("pokemonSeleccionadoHP") + "\n" + imagenP2);
				%>
			</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="button" value="ATACAR" id="ataque"
				name="ataque" /></td>
			<!--   onclick="document.form1.action = 'nuevo.jsp'; document.form1.submit()" -->
			<td></td>
		</tr>
	</table>
</body>
</html>