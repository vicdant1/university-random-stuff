<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Detalhes do Contato</title>
</head>
<body>
	<div class="container">	
		<form class="form" method="post" action="VerDetalhesServlet">
			<h3 class="text-center">Digite o nome do contato</h3>
			<input name="nome" placeholder="Nome"/>
			<button class="btn" type="submit">Pesquisar</button>
		</form>
	</div>
</body>
</html>