<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />
<div class="container">
	<h1 class="heading">Transferencia entre Cuentas</h1>
	<form action="procesar_transferencia.php" method="post">
		<div class="form-row">
			<div class="form-group">
				<label for="cuenta_origen">Cuenta Origen:</label> <select
					id="cuenta_origen" name="cuenta_origen">
					<option value="N�mina">N�mina</option>
					<option value="OtraCuenta1">Otra Cuenta 1</option>
					<option value="OtraCuenta2">Otra Cuenta 2</option>
					<!-- Agrega m�s opciones seg�n tus necesidades -->
				</select>
			</div>
			<div class="form-group">
				<label for="cuenta_destino">Cuenta Destino:</label> <select
					id="cuenta_destino" name="cuenta_destino">
					<option value="Alimentaci�n">Alimentaci�n</option>
					<option value="Transporte">Transporte</option>
					<option value="Ocio">Ocio</option>
					<!-- Agrega m�s opciones seg�n tus necesidades -->
				</select>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group">
				<label for="concepto">Concepto:</label> <input type="text"
					id="concepto" name="concepto">
			</div>
			<div class="form-group">
				<label for="fecha">Fecha:</label> <input type="date" id="fecha"
					name="fecha">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group">
				<label for="valor">Valor:</label> <input type="number" id="valor"
					name="valor" step="0.01">
			</div>
			<div class="form-group" style="align-self: flex-end;">
				<input type="submit" class="btn-transferencia"
					value="Realizar Transferencia">
			</div>
		</div>
	</form>
</div>
<jsp:include page="../../templates/footer.jsp" />