<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Menu</title>
</head>
<body>

	<div class="container flex-column">		
			<a style="min-width: 200px" href="cadastrarContato.jsp"><button class="btn">Cadastrar novo contato</button></a>
			<form style="min-width: 200px" action="ListarContatosServlet" method="post">
				<button class="btn" type="submit">Listar contatos salvos</button>
			</form>
			<a style="min-width: 200px" href="verDetalhes.jsp"><button class="btn">Ver detalhes do contato</button></a>
			<a style="min-width: 200px" href="excluirUsuario.jsp"><button class="btn">Excluir um contato</button></a>
	</div>
</body>
</html>