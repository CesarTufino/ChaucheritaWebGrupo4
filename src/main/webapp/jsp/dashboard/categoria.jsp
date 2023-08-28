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

<form id="agregarCategoriaForm" method="post" action="ruta_del_servidor">
    <div class="mb-3">
        <label for="nombreCategoria" class="form-label">Nombre de la categoría</label>
        <input type="text" class="form-control" id="nombreCategoria" name="nombreCategoria" placeholder="Nombre de la categoría">
    </div>
    <div class="mb-3">
        <label for="tipoCategoria" class="form-label">Tipo de categoría</label>
        <select class="form-select" id="tipoCategoria" name="tipoCategoria">
            <option value="ingreso">Ingreso</option>
            <option value="egreso">Egreso</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary" id="guardarCategoriaBtn">Guardar</button>
    <button type="button" class="btn btn-secondary" id="cancelarCategoriaBtn">Cancelar</button>
</form>

<!--<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>/-->



<jsp:include page="../../templates/footer.jsp" />