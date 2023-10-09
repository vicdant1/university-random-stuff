<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Excluir Usuário</title>
</head>
<body>
	<div class="container">	
		<form class="form" method="post" action="ExcluirUsuarioServlet">
			<h3 class="text-center">Digite o nome do contato</h3>
			<input name="nome" placeholder="Nome"/>
			<button class="btn" type="submit">Excluir</button>
		</form>
	</div>
</body>
</html>