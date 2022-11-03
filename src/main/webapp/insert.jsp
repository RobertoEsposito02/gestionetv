<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	
		<%if(request.getAttribute("messaggioDiErrore") != null) {%>
			<p style="color: red"><%=request.getAttribute("messaggioDiErrore") %></p>
		<%}else {%>
			<p>Riempi i campi per inserire un nuovo televisore</p>
		<%} %>
		
		<form action="ExecuteInsertTelevisoreServlet" method="post">
			<label for="marcaInputId">Marca</label><br>
			<input type="text" name="marcaInput" id="marcaInputId"><br>
			<label for="modelloInputId">Modello</label><br>
			<input type="text" name="modelloInput" id="modelloInputId"><br>
			<label for="prezzoInputId">Prezzo</label><br>
			<input type="number" name="prezzoInput" id="prezzoInputId"><br>
			<label for="numeroPolliciInputId">Numero Pollici</label><br>
			<input type="number" name="numeroPolliciInput" id="numeroPolliciInputId"><br>
			<label for="codiceInputId">Codice</label><br>
			<input type="text" name="codiceInput" id="codiceInputId"><br><br>
			<input type="submit" value="conferma">
		</form> 
		
		<a href="home.jsp">Home</a>
		
	</body>
</html>