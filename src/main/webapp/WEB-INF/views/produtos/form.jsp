<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>
    <form action="/produtos" method="post">
        <div>
            <label for="titulo">Título</label>
            <input id="titulo" type="text" name="titulo"/>
        </div>
        <div>
            <label for="descricao">Descrição</label>
            <textarea id="descricao" name="descricao" cols="20" rows="10"></textarea>
        </div>
        <div>
            <label for="paginas">Páginas</label>
            <input id="paginas" type="text" name="paginas"/>
        </div>
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div>
                <label>${tipoPreco}</label>
                <input type="text" name="precos[${status.index}].valor" />
                <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}" />
            </div>
        </c:forEach>
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
