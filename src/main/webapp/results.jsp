<%@page import="it.prova.gestionetv.model.Televisore"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	
		<%List<Televisore> result = (List<Televisore>)request.getAttribute("listMarcaEModello_attr"); %>
		<table border="3px">
			<thead>
				<tr>
					<th>Marca</th>
					<th>Modello</th>
					<th>Azione</th>
				</tr>
			</thead>
		<%for(Televisore televisore : result) {%>
			<tr>
				<th><%=televisore.getMarca() %></th>
				<th><%=televisore.getModello() %></th>
				<th>
					<a href="ExecuteShowOneTelevisoreServlet?idTelevisoreParametro=<%=televisore.getId() %>">Dettaglio</a>
					<a href="PrepareUpdateTelevisoreServlet?idTelevisoreParametro=<%=televisore.getId() %>">Modifica</a>
					<a href="PrepareDeleteTelevisoreServlet?idTelevisoreParametro=<%=televisore.getId() %>">Elimina</a>
				</th>
			</tr>
		<%} %>
		</table>
		
		<a href="home.jsp">Home</a>
	</body>
</html>