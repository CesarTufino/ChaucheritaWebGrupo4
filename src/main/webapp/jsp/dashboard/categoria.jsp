<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h2>Dashboard</h2>
</div>

<h2>Categorías</h2>

<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>Categoría</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${categorias}" var="categoria">
				<tr>
					<td>${categoria.nombre}</td>
					<td>${categoria.tipo.descripcion}</td>
				</tr>
			</c:forEach>
        </tbody>
    </table>
</div>

<!-- Botón para mostrar formulario de agregar categoría -->
<button class="btn btn-success" id="agregarCategoriaBtn">Agregar Categoría</button>

<!-- Formulario para agregar categoría -->
<div id="agregarCategoriaForm" style="display: none;">
    <input type="text" placeholder="Nombre de la categoría" id="nombreCategoria">
    <select id="tipoCategoria">
        <option value="ingreso">Ingreso</option>
        <option value="egreso">Egreso</option>
    </select>
    <button class="btn btn-primary" id="guardarCategoriaBtn">Guardar</button>
    <button class="btn btn-secondary" id="cancelarCategoriaBtn">Cancelar</button>
</div>
<!--<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>/-->

<script>
    // Mostrar formulario al hacer clic en "Agregar Categoría"
    document.getElementById("agregarCategoriaBtn").addEventListener("click", function() {
        document.getElementById("agregarCategoriaForm").style.display = "block";
    });

    // Ocultar formulario y limpiar campos al hacer clic en "Cancelar"
    document.getElementById("cancelarCategoriaBtn").addEventListener("click", function() {
        document.getElementById("agregarCategoriaForm").style.display = "none";
        document.getElementById("nombreCategoria").value = "";
        document.getElementById("tipoCategoria").value = "ingreso";
    });

    // Agregar la lógica para guardar la categoría al hacer clic en "Guardar"
    document.getElementById("guardarCategoriaBtn").addEventListener("click", function() {
        var nombreCategoria = document.getElementById("nombreCategoria").value;
        var tipoCategoria = document.getElementById("tipoCategoria").value;
        // Aquí puedes agregar la lógica para guardar la categoría en la tabla
        // y luego actualizar la interfaz según sea necesario.
        // Por ejemplo, puedes agregar una nueva fila a la tabla con el nombre y tipo de la categoría.
        // Luego, puedes ocultar el formulario y limpiar los campos.
    });
</script>

<jsp:include page="../../templates/footer.jsp" />