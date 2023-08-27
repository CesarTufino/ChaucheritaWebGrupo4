<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h2>Dashboard</h2>
</div>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>Cuentas</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cuentasTotalDTO}" var="cuentaTotalDTO">
				<tr>
					<td>${cuentaTotalDTO.nombre}</td>
					<td>${cuentaTotalDTO.total}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div class="btn-group">
	<a href="DashboardController?ruta=iniciar&mes=1"><button class="btn btn-secondary">Enero</button></a>
	<a href="DashboardController?ruta=iniciar&mes=2"><button class="btn btn-secondary">Febrero</button></a>
	<a href="DashboardController?ruta=iniciar&mes=3"><button class="btn btn-secondary">Marzo</button></a>
	<a href="DashboardController?ruta=iniciar&mes=4"><button class="btn btn-secondary">Abril</button></a>
	<a href="DashboardController?ruta=iniciar&mes=5"><button class="btn btn-secondary">Mayo</button></a>
	<a href="DashboardController?ruta=iniciar&mes=6"><button class="btn btn-secondary">Junio</button></a>
	<a href="DashboardController?ruta=iniciar&mes=7"><button class="btn btn-secondary">Julio</button></a>
	<a href="DashboardController?ruta=iniciar&mes=8"><button class="btn btn-secondary">Agosto</button></a>
	<a href="DashboardController?ruta=iniciar&mes=9"><button class="btn btn-secondary">Septiembre</button></a>
	<a href="DashboardController?ruta=iniciar&mes=10"><button class="btn btn-secondary">Octubre</button></a>
	<a href="DashboardController?ruta=iniciar&mes=11"><button class="btn btn-secondary">Noviembre</button></a>
	<a href="DashboardController?ruta=iniciar&mes=12"><button class="btn btn-secondary">Diciembre</button></a>
</div>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>Categorías</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${categoriasTotalDTO}" var="categoriaTotalDTO">
				<tr>
					<td>${categoriaTotalDTO.nombre}</td>
					<td>${categoriaTotalDTO.total}</td>
				</tr>
			</c:forEach>
			</tr>
		</tbody>
	</table>
</div>

<!--<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>/-->

<jsp:include page="../../templates/footer.jsp" />