<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" action="<c:url value="/editProfile"/>" method="post">
    <fieldset><h1>Редактирование профиля:<br>
        <small>Введите новые данные, которые вы хотите заменить и нажмите отправить</small></h1><br>
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Логин</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" class="form-control input-md">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Пароль</label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="password" placeholder="" class="form-control input-md">

            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="Email">Email</label>
            <div class="col-md-4">
                <input id="Email" name="Email" type="email" class="form-control input-md">

            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="Phone">Телефон</label>
            <div class="col-md-4">
                <input id="Phone" name="Phone" type="tel" class="form-control input-md">

            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="push"></label>
            <div class="col-md-4">
                <button id="push" class="btn btn-primary">Отправить</button>
            </div>
        </div>
    </fieldset>
</form>