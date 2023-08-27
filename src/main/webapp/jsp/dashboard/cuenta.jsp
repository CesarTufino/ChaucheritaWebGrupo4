<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h2>Dashboard</h2>
</div>

<h2>Cuentas</h2>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>Cuenta</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cuentas}" var="cuenta">
				<tr>
					<td>${cuenta.nombre}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<button class="btn btn-success" id="agregarCuentaBtn">Agregar Cuenta</button>


<!-- Formulario para agregar cuenta -->
<div id="agregarCuentaForm" style="display: none;">
	<input type="text" placeholder="Nombre de la cuenta" id="nombreCuenta">
	<button class="btn btn-primary" id="guardarCuentaBtn">Guardar</button>
	<button class="btn btn-secondary" id="cancelarCuentaBtn">Cancelar</button>
</div>
<!--<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>/-->
<script>
	// Mostrar formulario al hacer clic en "Agregar Cuenta"
	document
			.getElementById("agregarCuentaBtn")
			.addEventListener(
					"click",
					function() {
						document.getElementById("agregarCuentaForm").style.display = "block";
						document.getElementById("agregarCuentaForm").
					});

	// Ocultar formulario y limpiar campo al hacer clic en "Cancelar"
	document
			.getElementById("cancelarCuentaBtn")
			.addEventListener(
					"click",
					function() {
						document.getElementById("agregarCuentaForm").style.display = "none";
						document.getElementById("nombreCuenta").value = "";
					});

	// Agregar la l�gica para guardar la cuenta al hacer clic en "Guardar"
	document.getElementById("guardarCuentaBtn")
			.addEventListener(
					"click",
					function() {
						var nombreCuenta = document
								.getElementById("nombreCuenta").value;
						// Aqu� puedes agregar la l�gica para guardar la cuenta en la tabla
						// y luego actualizar la interfaz seg�n sea necesario.
						// Por ejemplo, puedes agregar una nueva fila a la tabla con el nombre de la cuenta.
						// Luego, puedes ocultar el formulario y limpiar el campo.
					});
</script>


<jsp:include page="../../templates/footer.jsp" />