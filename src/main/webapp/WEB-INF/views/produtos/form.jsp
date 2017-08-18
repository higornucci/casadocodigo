<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>
    <form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" enctype="multipart/form-data" commandName="produto">
        <div>
            <label for="titulo">Título*</label>
            <form:input id="titulo" path="titulo"/>
            <form:errors path="titulo" />
        </div>
        <div>
            <label for="descricao">Descrição*</label>
            <form:textarea id="descricao" path="descricao" cols="20" rows="10"/>
            <form:errors path="descricao"/>
        </div>
        <div>
            <label for="paginas">Páginas*</label>
            <form:input id="paginas" path="paginas"/>
            <form:errors path="paginas"/>
        </div>
        <div>
            <label for="data-lancamento">Data de Lançamento*</label>
            <form:input id="data-lancamento" path="dataLancamento"/>
            <form:errors path="dataLancamento"/>
        </div>
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div>
                <label>${tipoPreco}</label>
                <form:input path="precos[${status.index}].valor" />
                <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}" />
            </div>
        </c:forEach>
        <div>
            <label for="sumario">Sumário</label>
            <input id="sumario" type="file" name="sumario"/>
        </div>
        <button type="submit">Cadastrar</button>
    </form:form>
</body>
</html>
