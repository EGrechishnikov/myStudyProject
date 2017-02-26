<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/index"/>">Империя обоев</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown" id="link">
                    <a href="<c:url value="/catalog"/>" class="dropdown-toggle" data-toggle="dropdown">
                        Каталог
                        <b class="caret"></b>
                    </a>
                    <ul id="catalog" class="dropdown-menu">
                        <li><a href="<c:url value="/catalog"/>">Общий каталог</a></li>
                        <li><a href='<c:url value="/catalog"/>?g&country=Германия'>Немецкие обои</a></li>
                        <li><a href='<c:url value="/catalog"/>?country=Италия'>Итальянские обои</a></li>
                        <li><a href='<c:url value="/catalog"/>?country=Россия'>Российские обои</a></li>
                        <li><a href='<c:url value="/catalog"/>?country=Бельгия'>Бельгийские обои</a></li>
                        <li><a href='<c:url value="/catalog"/>?country=Украина'>Украинские обои</a></li>
                    </ul>
                </li>
                <li><a href="<c:url value="/sale"/>">Акции</a></li>
                <li><a href="<c:url value="/contacts"/>">Контакты</a></li>
            </ul>
            <c:if test="${user == null}">
                <form class="navbar-form navbar-right" action="<c:url value="/signUp"/>" method="get">
                    <button type="submit" class="btn btn-success">Зарегистрироваться</button>
                </form>
                <form class="navbar-form navbar-right" action="<c:url value="/login"/>" method="get">
                    <button type="submit" class="btn btn-info">Войти</button>
                </form>
            </c:if>
            <c:if test="${user != null}">
                <form class="navbar-form navbar-right" action="<c:url value="/logout"/>" method="get">
                    <button type="submit" class="btn btn-danger">Выйти</button>
                </form>
                <form class="navbar-form navbar-right" action="<c:url value="/my"/>" method="get">
                    <button type="submit" class="btn btn-info"><c:out value="${user.getLogin()}"/></button>
                </form>
            </c:if>
        </div>
    </div>
</div>