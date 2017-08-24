<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
            integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
            integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Casa do Código</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${s:mvcUrl('PC#listar').build()}">Lista de Produtos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${s:mvcUrl('PC#form').build()}">Cadastro de Produtos</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="container">
    <h1>Cadastro de Produtos</h1>
    <form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" enctype="multipart/form-data"
               commandName="produto">
        <div class="form-group">
            <label for="titulo">Título*</label>
            <form:input id="titulo" path="titulo" cssClass="form-control"/>
            <form:errors path="titulo"/>
        </div>
        <div class="form-group">
            <label for="descricao">Descrição*</label>
            <form:textarea id="descricao" path="descricao" cssClass="form-control"/>
            <form:errors path="descricao"/>
        </div>
        <div class="form-group">
            <label for="paginas">Páginas*</label>
            <form:input id="paginas" path="paginas" cssClass="form-control"/>
            <form:errors path="paginas"/>
        </div>
        <div class="form-group">
            <label for="data-lancamento">Data de Lançamento*</label>
            <form:input id="data-lancamento" path="dataLancamento" cssClass="form-control"/>
            <form:errors path="dataLancamento"/>
        </div>
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div class="form-group">
                <label>${tipoPreco}</label>
                <form:input path="precos[${status.index}].valor" cssClass="form-control"/>
                <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}"/>
            </div>
        </c:forEach>
        <div class="form-group">
            <label for="sumario">Sumário</label>
            <input id="sumario" type="file" name="sumario" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form:form>
</div>
</body>
</html>
