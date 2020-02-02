<%@page import="pokemons.Pokemon"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.jugador {
	transform: scaleX(-1);
}
</style>
</head>
<body>
	<%
		Pokemon random = (Pokemon) request.getAttribute("pokemonRandom");
		Pokemon seleccionado = (Pokemon) request.getAttribute("pokemonSeleccionado");
	%>
	<%
		if (random.getHp() <= 0 || seleccionado.getHp() <= 0) {
	%>
	<h1 align="center">

		<%
			if (random.getHp() > seleccionado.getHp()) {
					out.print("Ganador: " + random.getNombre());
				} else {
					out.print("Ganador: " + seleccionado.getNombre());
				}
		%>
	</h1>
	<%
		}
	%>
	<table align="center">
		<tr>
			<td></td>
			<td></td>
			<td>
				<%
					String imagenP1 = "<img width=\"150px\" src=\"" + random.getImg() + "\"/>";
					String hp1 = String.valueOf(random.getHp());
					String hp1MAX = String.valueOf(random.getHpMAX());
					String nombre1 = String.valueOf(random.getNombre());
					out.print(imagenP1);
				%>
				<p align="center">
					<%
						out.print(nombre1 + "\n" + hp1 + "/" + hp1MAX);
					%>
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<%
					String imagenP2 = "<img width=\"150px\" class=\"jugador\" src=\"" + seleccionado.getImg() + "\"/>";
					String hp = String.valueOf(seleccionado.getHp());
					String hpMAX = String.valueOf(seleccionado.getHpMAX());
					String nombre = String.valueOf(seleccionado.getNombre());
					out.print(imagenP2);
				%>
				<p align="center">
					<%
						out.print(nombre + "\n" + hp + "/" + hpMAX);
					%>
				</p>
			</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<form action="MiServlet" method="get">
					<input type="submit" value="ATACAR" id="ataque" name="accion" />
				</form>
			</td>


			<!--   onclick="document.form1.action = 'nuevo.jsp'; document.form1.submit()" -->
			<td></td>
		</tr>
	</table>
</body>
</html>