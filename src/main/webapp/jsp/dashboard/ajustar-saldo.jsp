<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />
<div class="container">
	<h1>Ajustar cuenta #NOMBRE DE LA CUENTA</h1>

	<form id="ajusteForm">
		<div class="mb-3 input-group">
			<label for="valorAjustar" class="input-group-text">Valor a Ajustar:</label>
			<input type="number" class="form-control" id="valorAjustar"
				name="valorAjustar" required>
		</div>
		<button type="submit" class="btn btn-primary">Ajustar Cuenta</button>
	</form>
</div>

<jsp:include page="../../templates/footer.jsp" />