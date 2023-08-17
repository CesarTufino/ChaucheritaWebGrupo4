<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Detalle Movimiento</h1>
</div>

<div class="container">
	<p>
		<strong class="text-primary"><i
			class="bi bi-file-arrow-up-fill"></i> Cuenta Origen:</strong> Banco
	</p>
	<p>
		<strong class="text-primary"><i
			class="bi bi-file-arrow-down-fill"></i> Cuenta Destino:</strong> Efectivo
	</p>
	<p>
		<strong class="text-primary"><i
			class="bi bi-cash-stack"></i> Monto:</strong> $ 1000
	</p>
	<p>
		<strong class="text-primary"><i
			class="bi bi-calendar3"></i> Fecha y hora:</strong> 01/01/2021 8:56 am
	</p>
	<p>
		<strong class="text-primary">Tipo movimiento</strong>: Transferencia
	</p>
	<p>
		<strong class="text-primary"><i
			class="bi bi-card-text"></i> Concepto:</strong> Lorem ipsum dolor sit amet
		consectetur adipisicing elit. Eius officiis quis, provident dolorem
		iusto velit accusamus, odio at incidunt id doloremque sint corporis
		eum ab reprehenderit fugit hic commodi distinctio!
	</p>
</div>
<jsp:include page="../../templates/footer.jsp" />