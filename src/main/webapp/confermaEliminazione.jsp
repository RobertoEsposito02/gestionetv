<%@page import="it.prova.gestionetv.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>confermaEliminazione</title>
	</head>
	<body>
		<%Televisore result = (Televisore)request.getAttribute("elementoDaEliminare"); %>
		<table border="3px">
			<thead>
				<tr>
					<th>Marca</th>
					<th>Modello</th>
					<th>Prezzo</th>
					<th>Numero pollici</th>
					<th>Codice</th>
				</tr>
			</thead>
			<tr>
				<td><%=result.getMarca() %></td>
				<td><%=result.getModello() %></td>
				<td><%=result.getPrezzo() %></td>
				<td><%=result.getNumeroPollici() %></td>
				<td><%=result.getCodice() %></td>
			</tr>
		</table>
		
		<form action="ExecuteDeleteTelevisoreServlet" method="post">
			<input type="submit" value="conferma">
			<input type="hidden" name="idTelevisore" value="<%=result.getId() %>">
		</form>
		
		<a href="home.jsp">Home</a>
		<a href="ExecuteShowAllTelevisoreServlet">Torna Indietro</a>
		
	</body>
</html>