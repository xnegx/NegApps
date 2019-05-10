<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<jsp:include page="\head.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>

<body>
	<span></span>
	<div class="container">
		<main role="main">
		<div class="row">
			<div class="col-lg-6 align-content-center">
				<h2>Selecione uma CSR ou Certificado para analisar</h2>
				<p></p>
				<form method="POST" action="/header" enctype="multipart/form-data">
					<div class="form-group">
						<label for="file">Escolha um arquivo </label> 
						<input type="file" name="file" /><br/><br/>
						<p class="form-text">Selecione um arquivo para analisar.</p>
						<input type="submit" value="Enviar" />
					</div>
					

				</form>
				<p></p>
				<p></p>
			</div>
			<div class="col-lg-6 align-content-center">
				<h2>Resultado:</h2>
				<p></p>
				<textarea class="form-control" rows="15" title="resultado"
					data-pg-name="resultado" readonly>${retorno}</textarea>
			</div>
		</div>
	</div>
	</main>
</body>
</html>