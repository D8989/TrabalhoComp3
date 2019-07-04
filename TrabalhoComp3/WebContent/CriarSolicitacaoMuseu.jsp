<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sistema de Gerenciamento de Museu - Criar Solicitação de Museu</title>
</head>
<body>
<form action="solicitacao-museu" method="post">
    <label for="nomeMuseu">Nome do Museu:</label><input type="text" id="nomeMuseu" name="nomeMuseu"/><br/>
    <label for="dataCriacao">Data de Criação:</label><input type="date" id="dataCriacao" name="dataCriacao"/><br/>
    <label for="cidade">Cidade:</label><input type="text" id="cidade" name="cidade"/><br/>
    <label for="estado">Estado:</label><input type="text" id="estado" name="estado"/><br/>
    <label for="nomeGestor">Nome do Gestor do Museu:</label><input type="text" id="nomeGestor" name="nomeGestor"/><br/>
    <label for="cpfGestor">CPF do Gestor do Museu:</label><input type="text" id="cpfGestor" name="cpfGestor"/><br/>
    <label for="senhaGestor">Senha do Gestor do Museu:</label><input type="password" id="senhaGestor" name="senhaGestor"/><br/>
    <input type="submit" value="Enviar"/>
</form>
</body>
</html>