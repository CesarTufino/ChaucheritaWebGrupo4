<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Movimientos</h1>
</div>
<div class="table-responsive small">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Cuenta Origen</th>
				<th scope="col">Cuenta Destino</th>
				<th scope="col">Concepto</th>
				<th scope="col">Fecha</th>
				<th scope="col">Valor</th>
				<!--<th scope="col">Ver</th> -->
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1,001</td>
				<td>random</td>
				<td>data</td>
				<td>placeholder</td>
				<td>text</td>
				<td>text</td>
				<!-- <td><a href="detalle-movimiento.html" class="btn btn-outline-primary"><i class="bi bi-eye-fill"></i></a></td> -->
			</tr>
		</tbody>
	</table>
</div>
<jsp:include page="../../templates/footer.jsp" />