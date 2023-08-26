<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h2>Dashboard</h2>
</div>

<!-- Agregar los botones para cambiar entre meses -->
<div class="btn-group">
    <button class="btn btn-secondary">Enero</button>
    <button class="btn btn-secondary">Febrero</button>
    <button class="btn btn-secondary">Marzo</button>
    <button class="btn btn-secondary">Abril</button>
    <button class="btn btn-secondary">Mayo</button>
    <button class="btn btn-secondary">Junio</button>
    <button class="btn btn-secondary">Julio</button>
    <button class="btn btn-secondary">Agosto</button>
    <button class="btn btn-secondary">Septiembre</button>
    <button class="btn btn-secondary">Octubre</button>
    <button class="btn btn-secondary">Noviembre</button>
    <button class="btn btn-secondary">Diciembre</button>
    <!-- Agregar más botones para otros meses -->
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
            <tr>
                <td>Cuenta 1</td>
                <td>Total 1</td>
            </tr>
            <!-- Agregar más filas de cuentas aquí -->
        </tbody>
    </table>
</div>

<!--<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>/-->



<jsp:include page="../../templates/footer.jsp" />