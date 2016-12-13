<html>
<body>
	<h2>Hello World!</h2>
	<form action="novaEmpresa" method="POST">
		Nome:
		<input type="text" name="nome">
		<input type="submit" value="Enviar">
	</form>

	<form action="login" method="POST">
		Email:
		<input type="text" name="email" />
		Senha:
		<input type="password" name="senha" />
		<input type="submit" value="Logar" />
	</form>

	<form action="logout" method="POST">
		<input type="submit" value="deslogar" />
	</form>
</body>
</html>
