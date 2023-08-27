<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />

<div class="btn-group">
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=1"><button class="btn btn-secondary">Enero</button></a>
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=2"><button class="btn btn-secondary">Febrero</button></a>
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=3"><button class="btn btn-secondary">Marzo</button></a>
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=4"><button class="btn btn-secondary">Abril</button></a>
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=5"><button class="btn btn-secondary">Mayo</button></a>
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=6"><button class="btn btn-secondary">Junio</button></a>
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=7"><button class="btn btn-secondary">Julio</button></a>
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=8"><button class="btn btn-secondary">Agosto</button></a>
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=9"><button class="btn btn-secondary">Septiembre</button></a>
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=10"><button class="btn btn-secondary">Octubre</button></a>
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=11"><button class="btn btn-secondary">Noviembre</button></a>
	<a href="MovimientoController?ruta=vizualizarPorMes&mes=12"><button class="btn btn-secondary">Diciembre</button></a>
</div>

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Movimientos</h1>
</div>
<div class="table-responsive small">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Concepto</th>
				<th scope="col">Valor</th>
				<th scope="col">Fecha</th>
				<th scope="col">Cuenta</th>
				<th scope="col">Categoria</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${movimientos}" var="movimiento">
				<tr>
					<td>${movimiento.id}</td>
					<td>${movimiento.concepto}</td>
					<td>${movimiento.valor}</td>
					<td>${movimiento.fecha}</td>
					<td>${movimiento.categoria.nombre}</td>
					<td>${movimiento.cuenta.nombre}</td>
					<!-- <td><a href="detalle-movimiento.html" class="btn btn-outline-primary"><i class="bi bi-eye-fill"></i></a></td> -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="../../templates/footer.jsp" />