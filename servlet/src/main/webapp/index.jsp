<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
	<h2>Bem vindo à minha página legal</h2>

	<c:if test="${not empty usuarioLogado}">
	Logado com ${usuarioLogado.email}<br />
	</c:if>
	<form action="executa" method="POST">
		<input type="hidden" value="NovaEmpresa" name="tarefa" />
		Nome:
		<input type="text" name="nome">
		<input type="submit" value="Enviar">
	</form>

	<form action="executa" method="POST">
		<input type="hidden" value="Login" name="tarefa"/>
		Email:
		<input type="text" name="email" />
		Senha:
		<input type="password" name="senha" />
		<input type="submit" value="Logar" />
	</form>

	<form action="executa" method="POST">
		<input type="hidden" value="Logout" name="tarefa" />
		<input type="submit" value="deslogar" />
	</form>
</body>
</html>
