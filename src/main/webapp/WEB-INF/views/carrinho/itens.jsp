<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Livros de Java, Android, IOs, Mobile e muito mais...">

    <header id="layout-header">
        <div class="clearfix container">
            <a href="/" id="logo">
            </a>
            <div id="header-content">
                <nav id="main-nav">

                    <ul class="clearfix">
                        <li><a href="${s:mvcUrl('CCC#itens').build()}" rel="nofollow">Carrinho
                            ( ${carrinhoCompras.quantidade} )</a></li>

                        <li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">Sobre Nós</a></li>

                        <li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas Frequentes</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>
    <nav class="categories-nav">
        <ul class="container">
            <li class="category"><a href="http://www.casadocodigo.com.br">Home</a></li>
            <li class="category"><a href="/collections/livros-de-agile">
                Agile </a></li>
            <li class="category"><a href="/collections/livros-de-front-end">
                Front End </a></li>
            <li class="category"><a href="/collections/livros-de-games">
                Games </a></li>
            <li class="category"><a href="/collections/livros-de-java">
                Java </a></li>
            <li class="category"><a href="/collections/livros-de-mobile">
                Mobile </a></li>
            <li class="category"><a
                    href="/collections/livros-desenvolvimento-web"> Web </a></li>
            <li class="category"><a href="/collections/outros"> Outros </a></li>
        </ul>
    </nav>

    <section class="container middle">
        <h2 id="cart-title">Seu carrinho de compras</h2>


        <table id="cart-table">
            <colgroup>
                <col class="item-col"/>
                <col class="item-price-col"/>
                <col class="item-quantity-col"/>
                <col class="line-price-col"/>
                <col class="delete-col"/>
            </colgroup>
            <thead>
            <tr>
                <th class="cart-img-col"></th>
                <th width="65%">Item</th>
                <th width="10%">Preço</th>
                <th width="10%">Quantidade</th>
                <th width="10%">Total</th>
                <th width="5%"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${carrinhoCompras.itens }" var="item">
                <tr>
                    <td class="cart-img-col">
                        <img src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145"
                             width="71px" height="100px"/>
                    </td>
                    <td class="item-title">${item.produto.titulo}</td>
                    <td class="numeric-cell">${item.preco}</td>
                    <td class="quantity-input-cell">
                        <input type="number" min="0" readonly="readonly" id="quantidade" name="quantidade"
                               value="${carrinhoCompras.getQuantidade(item) }"/>
                    </td>
                    <td class="numeric-cell">${carrinhoCompras.getTotal(item)}</td>
                    <td class="remove-item">
                        <form:form action="${s:mvcUrl('CCC#remover').arg(0, item.produto.id).arg(1, item.tipoPreco).build() }" method="post">
                            <input type="image" src="/excluir.png" alt="Excluir" title="Excluir" />
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="3">
                    <form:form action="${s:mvcUrl('PC#finalizar').build()}" method="post">
                        <input type="submit" class="checkout" name="checkout" value="Finalizar compra" />
                    </form:form>
                </td>
                <td class="numeric-cell">${carrinhoCompras.total}</td>
                <td></td>
            </tr>
            </tfoot>
        </table>

        <h2>Você já conhece os outros livros da Casa do Código?</h2>
        <ul id="collection" class="related-books">
            <li class="col-left">
                <a href="/products/livro-plsql" class="block clearfix book-suggest"
                   data-book="PL/SQL: Domine a linguagem do banco de dados Oracle">
                    <img width="113px" height="160px"
                         src="http:////cdn.shopify.com/s/files/1/0155/7645/products/plsql-featured_compact.png?v=1434740236"
                         alt="PL/SQL: Domine a linguagem do banco de dados Oracle"/>
                </a>
            </li>
        </ul>

        <h2><a href="http://www.casadocodigo.com.br">Veja todos os livros que publicamos!</a></h2>
    </section>

</tags:pageTemplate>
