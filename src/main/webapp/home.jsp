<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
	</head>
	<body>
		<h2>HomePage</h2>
		
		<%if(request.getAttribute("messaggioDiErrore_attr") != null) {%>
			<p style="color: red"><%=request.getAttribute("messaggioDiErrore_attr") %></p>
		<%}else {%>
			<p>Inserire valori da ricercare</p>
		<%} %>
		<form action="ExecuteShowAllTelevisore">
			<label for="marcaInputId">Marca</label><br>
			<input type="text" name="marcaInput" id="marcaInputId"><br>
			<label for="mdoelloInputId">Modello</label><br>
			<input type="text" name="modelloInput" id="modelloInputId"><br><br>
			<input type="submit" value="conferma">
		</form>
		
		<a href="insert.jsp">Inserisci un nuovo televisore</a>
		
	</body>
</html>