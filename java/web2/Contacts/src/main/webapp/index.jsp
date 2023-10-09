<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Login</title>
</head>
<body>
	<div class="container">
		<form class="form" action="TelaLoginServlet" method="post">
			<h3 class="text-center">Realizar Login</h3>
			<label for="usuario">Usuário*</label>
			<input name="usuario" type="text" placeholder="Digite seu usuário"/>
			
			<label for="senha">Senha*</label>
			<input name="senha" type="password" placeholder="*********"/>
		
			<button class="btn" type="submit">Enviar</button>
		</form>
	</div>
</body>
</html>