<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav side-nav">
			<li><a href="#" data-toggle="collapse" data-target="#cad"><i
					class="fa fa-fw fa-edit"></i> Cadastro <i
					class="fa fa-fw fa-caret-down"></i></a>
				<ul id="cad" class="collapse">
					<li><a href="${pageContext.request.contextPath}/tribunal/"><i
							class="fa fa-fw fa-table"></i> Tribunal</a></li>
					<li><a href="${pageContext.request.contextPath}/assunto/"><i
							class="fa fa-fw fa-table"></i> Assunto</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</body>
</html>