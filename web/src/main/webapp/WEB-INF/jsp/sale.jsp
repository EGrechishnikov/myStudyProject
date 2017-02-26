<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar-collapse collapse" id="searchBar">
    <form class="navbar-form navbar-right" action="<c:url value="/search"/>" method="post">
        <div class="form-group">
            <input id="search" name="search" type="search" placeholder="пример: Marburg" class="form-control">
        </div>
        <button type="submit" class="btn btn-success">Поиск</button>
    </form>
    <h1>Акции:<br>
        <small>Подробности вы можете узнать у сотрудников нашего магазина.</small>
    </h1>
    <c:if test="${user==null}">
        <p id="hint">Что-бы добавить товар в козину - войдите, или зарегистрируйтесь.</p>
    </c:if>
</div>
<nav class="navBar navy">
    <div class="list-group">
        <a href="<c:url value="/catalog"/>" class="list-group-item">Общий каталог</a>
        <a id="sale" href="<c:url value="/sale"/>" class="list-group-item">Акции</a>
        <a href="<c:url value="/catalog"/>?country=Германия" class="list-group-item">Немецкие обои</a>
        <a href="<c:url value="/catalog"/>?country=Италия" class="list-group-item">Итальянские обои</a>
        <a href="<c:url value="/catalog"/>?country=Россия" class="list-group-item">Российские обои</a>
        <a href="<c:url value="/catalog"/>?country=Бельгия" class="list-group-item">Бельгийские обои</a>
        <a href="<c:url value="/catalog"/>?country=Украина" class="list-group-item">Украинские обои</a>
    </div>
</nav>
<div id="dialog">
    Товар добавлен в корзину
</div>
<div class="catalog">
    <c:forEach var="goods" items="${catalog}">
        <div class="ad">
            <div class="img">
                <img src="${goods.getImg()}" alt="обои">
            </div>
            <ul class="description">
                <li>
                    <c:out value="${goods.getName()}"/>
                </li>
                <li>
                    <c:out value="${goods.getCollection()}"/>
                </li>
                <li>
                    <c:out value="${goods.getDescription()}"/>
                </li>
                <li>
                    <c:out value="${goods.getSize()}"/>
                </li>
                <li>
                    <c:out value="${goods.getCountry()}"/>
                </li>
                <li>
                    Арт.<c:out value="${goods.getVendorCode()}"/>
                </li>
            </ul>
            <div class="price">
                <p class="newPrice">
                    Новая цена: $${goods.getSalePrice()}
                </p>
                <p class="oldPrice">
                    Старая цена: $${goods.getPrice()}
                </p>
                <p class="sale">
                    Скидка ${goods.getSale()}%!
                </p>
            </div>
            <c:if test="${user!=null}">
                <button type="button" id="${goods.getId()}" class="btn btn-success buy">В корзину</button>
            </c:if>
        </div>
    </c:forEach>
</div>
<ul class="pagination">
    <c:set var="page" value="${page}"/>
    <c:forEach var="count" begin="1" end="${pagesCount}">
        <c:if test="${page == count}">
            <li class="active"><a href="<c:url value="/sale"/>?page=${count}">${count}</a></li>
        </c:if>
        <c:if test="${page != count}">
            <li><a href="<c:url value="/sale"/>?page=${count}">${count}</a></li>
        </c:if>
    </c:forEach>
</ul>