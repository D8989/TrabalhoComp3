<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    GestorInvalidoException excecao = (GestorInvalidoException) request.getAttribute("excecao");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Sistema de Gerenciamento de Museus - Solicitação Inválida</title>
</head>
<body>
<h1>O gestor é invalido!</h1>
<p>Motivo: <%= excecao.getMotivo() %></p>
<a href="/criar-museu">Voltar a listagem de solicitações</a>
</body>
</html>