<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="solicitacao-museu" method="post">
    <label for="nomeMuseu">Nome do museu:</label><input type="text" id="nomeMuseu" name="nomeMuseu"/><br/>
    <label for="dataCriacao">Data de criação:</label><input type="date" id="dataCriacao" name="dataCriacao"/><br/>
    <label for="cidade">Cidade:</label><input type="text" id="cidade" name="cidade"/><br/>
    <label for="estado">Estado:</label><input type="text" id="estado" name="estado"/><br/>
    <label for="nomeGestor">Nome do gestor:</label><input type="text" id="nomeGestor" name="nomeGestor"/><br/>
    <label for="cpfGestor">CPF do gestor:</label><input type="text" id="cpfGestor" name="cpfGestor"/><br/>
    <label for="senhaGestor">Senha do gestor:</label><input type="password" id="senhaGestor" name="senhaGestor"/><br/>
    <input type="submit" value="Enviar"/>
</form>
</body>
</html>