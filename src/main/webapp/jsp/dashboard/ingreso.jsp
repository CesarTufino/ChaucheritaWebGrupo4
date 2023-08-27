<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />
<div class="container">
	<h1 class="heading">Registro de Ingreso</h1>
	<form action="MovimientoController?ruta=registrarIngreso" method="post">
		<div class="form-row">
			<div class="form-group">
				<label for="cuenta">Cuenta:</label> <select
					id="cuenta" name="cuenta">
					<c:forEach items="${cuentas}" var="cuenta">
						<option value="${cuenta.id}">${cuenta.nombre}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="categoria">Categoría:</label> <select
					id="categoria" name="categoria">
					<c:forEach items="${categoriasIngreso}" var="categoria">
						<option value="${categoria.id}">${categoria.nombre}</option>
					</c:forEach>
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
				<input type="submit" value="Registrar Ingreso">
			</div>
		</div>
	</form>
</div>
<jsp:include page="../../templates/footer.jsp" />