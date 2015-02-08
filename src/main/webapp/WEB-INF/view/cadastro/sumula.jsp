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
			<s:message code="form.cadastro.titulo" />
		</h1>
	</div>
</div>

<div class="row">
	<div class="col-md-8">
		<f:form commandName="combinedCommand" enctype="multipart/form-data"
			action="${pageContext.request.contextPath}/sumula/salvar"
			method="POST">
			<f:hidden path="sumula.id" />
			<div class="form-group">
				<label for="numero"><s:message code="form.sumula.numero" />
				</label> 
				<input type="text" class="form-control" name="sumula.numero" id="numero"
					value="${sumula.numero}" tipo="numerico"
					placeholder="<s:message code="form.sumula.numero.hint"/>">
			</div>
			<div class="form-group">
				<label for="nome"><s:message code="form.sumula.titulo" /> </label>
				<input type="text" class="form-control" name="sumula.titulo" id="titulo"
					value="${sumula.titulo}" placeholder="Informe o título se houver">
			</div>
			<div class="form-group">
				<label for="texto"><s:message code="form.sumula.texto" /> </label><br />
				<f:textarea id="texto" class="form-control" rows="4" path="sumula.texto" />

			</div>
			<div class="form-group">
				<label for="file"><s:message code="form.sumula.texto" /> </label>
				<input type="file" name="file" id="id">
			</div>
			
			<div class="row">
				<div class="col-xs-8">
					<button type="submit" class="btn btn-primary">
						<s:message code="form.btn.salvar" />
					</button>
				</div>
			</div>
		</f:form>
	</div>
</div>
