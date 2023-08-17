<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />
<div class="container">
	<h1 class="heading">Registro de Gasto</h1>
	<form action="procesar_gasto.php" method="post">
		<div class="form-row">
			<div class="form-group">
				<label for="cuenta_destino">Cuenta Destino:</label> <select
					id="cuenta_destino" name="cuenta_destino">
					<option value="Alimentación">Alimentación</option>
					<option value="Transporte">Transporte</option>
					<option value="Ocio">Ocio</option>
					<!-- Agrega más opciones según tus necesidades -->
				</select>
			</div>
			<div class="form-group">
				<label for="concepto">Concepto:</label> <input type="text"
					id="concepto" name="concepto">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group">
				<label for="fecha">Fecha:</label> <input type="date" id="fecha"
					name="fecha">
			</div>
			<div class="form-group">
				<label for="valor">Valor:</label> <input type="number" id="valor"
					name="valor" step="0.01">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group" style="flex-basis: 100%;">
				<input type="submit" value="Registrar Gasto">
			</div>
		</div>
	</form>
</div>
<jsp:include page="../../templates/footer.jsp" />