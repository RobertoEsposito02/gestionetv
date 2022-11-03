<%@page import="it.prova.gestionetv.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%Televisore result = (Televisore)request.getAttribute("caricaSingolo_attr"); %>
		<table border="1px">
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
				<th><%=result.getMarca() %></th>
				<th><%=result.getModello() %></th>
				<th><%=result.getPrezzo() %></th>
				<th><%=result.getNumeroPollici() %></th>	
				<th><%=result.getCodice() %></th>
			</tr>
		</table>
		
		<a href="home.jsp">Home</a>
		<a href="ExecuteShowAllTelevisoreServlet">Torna Indietro</a>
	</body>
</html>