<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" action="<c:url value="/login"/>" method="post">
    <fieldset>

        <h1>Вход в систему</h1>

        <div class="form-group" id="first">
            <label class="col-md-4 control-label" for="Login"></label>
            <div class="col-md-4">
                <input autofocus id="Login" name="Login" type="text" placeholder="Логин" class="form-control input-md">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="Password"></label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="password" placeholder="Пароль" class="form-control input-md">
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <p class="text-danger">
                <span id="answerText">
                <c:if test="${answer!=null}">
                    <c:out value="${answer}"/>
                </c:if>
                </span>
                </p>
            </div>
        </div>

        <div class="form-group" id="b">
            <label class="col-md-4 control-label" for="b1"></label>
            <div class="col-md-4">
                <button id="b1" name="b1" class="btn btn-primary">Войти</button>
            </div>
        </div>

    </fieldset>
</form>

<footer>
    <a href="<c:url value="/index"/>">Вернуться на главную</a>
</footer>