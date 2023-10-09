<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Cadastrar Contato</title>
</head>
<body>
	<div class="container">
		<form class="form" action="CadastroServlet" method="post">
			<h3 class="text-center">Novo Contato</h3>
			<label for="nome">Nome*</label>
			<input name="nome" type="text" placeholder="Digite o nome"/>
			
			<label for="telefoneCelular">Telefone Celular*</label>
			<input name="telefoneCelular" type="text" placeholder="(XX) XXXXX-XXXX"/>
			
			<label for="telefoneResidencial">Telefone Residencial*</label>
			<input name="telefoneResidencial" type="text" placeholder="(XX) XXXX-XXXX"/>
			
			<label for="email">E-mail*</label>
			<input name="email" type="email" placeholder="test@test.com"/>
			
			<label for="dataNascimento">Data de Nascimento*</label>
			<input name="dataNascimento" type="text" placeholder="dd/MM/yyyy"/>
		
			<button class="btn" type="submit">Enviar</button>
			<button class="btn" type="reset">Limpar</button>
		</form>
	</div>
</body>
</html>