<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Sistema de Gerenciamento de Museus - Usuário já existe</title>
</head>
<body>
<h1>Esse usuário já existe!</h1>
<!--<h2>Deseja converter ele para gestor?</h2>
<form action="criar-gestor" method="post">
    Nome do Usuario: <%= usuario.getNome() %><br/>
    CPF do Usuario: <%= usuario.getCpf() %><br/>
    <input type="hidden" value="Transforma" name="cmd"/>
    <input type="submit" value="Confirmar"/>
</form>-->
</body>
</html>