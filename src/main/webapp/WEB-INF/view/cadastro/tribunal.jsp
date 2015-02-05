<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Page Heading -->
<div class="row">
	<div class="col-xs-12">
		<h1 class="page-header"><s:message code="form.cadastro.titulo" />  </h1>
	</div>
</div>
<div class="row">
	<div class="col-md-8">
		<f:form modelAttribute="tribunal" action="${pageContext.request.contextPath}/tribunal/salvar" method="POST">
		<f:hidden path="id"/>
			<div class="form-group">
				<label for="nome"><s:message code="form.tribunal.tribunal" />
				</label> <input type="text" class="form-control" name="nome"
					id="nome" value="${tribunal.nome}"
					placeholder="<s:message code="form.tribunal.tribunal.info" />">
			</div>
			<div class="row">
				<div class="col-xs-8">
					<button type="submit" class="btn btn-primary"><s:message code="form.btn.salvar"/></button>
				</div>
			</div>
		</f:form>
	</div>
</div> 