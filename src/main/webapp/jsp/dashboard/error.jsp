<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />
<div class="container my-5">
	<div class="alert alert-danger" role="alert">
		<h4 class="alert-heading">Error</h4>
		<p>${requestScope.errorMessage}</p>
		<hr>
		<p class="mb-0">Por favor, intenta nuevamente más tarde.</p>
	</div>
</div>

<jsp:include page="../../templates/footer.jsp" />