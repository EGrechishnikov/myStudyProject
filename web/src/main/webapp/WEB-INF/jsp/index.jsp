<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="jumbotron">
    <div class="container">
        <h1 id="test">Добро пожаловать в "Империю обоев"!</h1>
        <p>Мы рады приветствовать вас на страницах нашего магазина. У нас представлен огромный выбор обоев любого класса,
            так что даже самый требовательный и придирчевый покупатель уйдет от нас удовлетворенным. Больше об ассартименте
            вы можете узнать в нашем каталоге.</p>
        <p><a class="btn btn-primary btn-lg" href="<c:url value="/catalog"/>" role="button">Узнать больше &raquo;</a></p>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h2>Новое поступление</h2>
            <p>Мы рады представить вам абсолютно новые коллекции обоев, с которыми вы можете ознакомиться в нашем каталоге.</p>
            <p><a class="btn btn-default" href="<c:url value="/catalog"/>" role="button">Узнать больше &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>Контакты</h2>
            <p>Узнать расположение наших магазинов можно в разделе контакты.</p>
            <p><a class="btn btn-default" href="<c:url value="/contacts"/>" role="button">Узнать больше &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>Акции</h2>
            <p>Скидки, акции и специальные предложения вы можете просмотреть в нашем каталоге.</p>
            <p><a class="btn btn-default" href="<c:url value="/sale"/>" role="button">Узнать больше &raquo;</a></p>
        </div>
    </div>
</div>