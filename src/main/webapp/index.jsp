<%@ page import="java.util.ArrayList"%>
<%@ page import="es.roberechev.serverPrueba.Pokemon"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style='text-align:center'>
	<%
	ArrayList<Pokemon> arrayListPokemons = (ArrayList<Pokemon>) request.getAttribute("pokemones");

	String table = "<table style='text-align:center;' border=1>";
	int i = 1;
	for (Pokemon p : arrayListPokemons) {
		String imagenP = p.getImg();
		String nombre = p.getNombre();
		String hp = String.valueOf(p.getHp());
		if (i == 1) {
			table += "<tr>";
		}
		table += "<td><a href=\"MiServlet?accion=combate " + nombre + "\">" + "<img width=\"60px\" src=\"" + imagenP
		+ "\"/>" + "\n " + nombre + "</a></td>";
		if (i == 9) {
			table += "</tr>";
			i = 0;
		}
		i++;

	}
	table += "</table>";
	out.print(table);
	%>
</body>
</html>