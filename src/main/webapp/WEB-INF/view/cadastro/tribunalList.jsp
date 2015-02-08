<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Page Heading -->
<div class="row">
	<div class="col-xs-12">
		<h1 class="page-header">
			<s:message code="form.tribunal.tribunal" />
		</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-6">
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/tribunal/novo"><s:message
				code="form.btn.novo" /></a>
	</div>
</div>
<div class="row">
	<div class="col-lg-6">
		<h2>Lista de Tribunais</h2>
		<div class="table-responsive">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>Tribunal</th>
						<th>Editar</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tribunais}" var="tribinal">
						<tr>
							<td><c:out  value="${tribinal.nome}" /> </td>
							<td><a
								href="${pageContext.request.contextPath}/tribunal/editar/${tribinal.id}">Editar</a></td>
							<td><a
								href="${pageContext.request.contextPath}/tribunal/apagar/${tribinal.id}">Apagar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
