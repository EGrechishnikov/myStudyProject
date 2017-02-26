<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="bodyBasket">
    <div class="btn-group">
        <button type="button" class="btn btn-default basket">Корзина</button>
        <button type="button" class="btn btn-default oldOrders">Прошлые заказы</button>
        <button type="button" class="btn btn-default edit-but">Изменить профиль</button>
    </div>
    <div class="navbar-collapse collapse searchBar">
        <h1>Моя корзина:<br>
            <small>Выберите количество трубок и подтвердите заказ. Что бы убрать позицию нажмите - "удалить"</small></h1>
    </div>

    <nav class="navBar navy buy-panel">
        <form action="<c:url value="/buy"/>" method="post">
            <div>
                <input name="all" value="all" type="hidden">
                <h3>Всего к оплате: $<b id="count"></b></h3>
                <button type="submit" class="btn btn-info">Подтвердить заказ</button>
            </div>
        </form>
    </nav>


    <div class="catalog">
        <c:forEach var="list" items="${ordersList}">
            <div class="ad">
                <div class="img">
                    <img src="${catalog.get(list.getGoods().getId() - 1).getImg()}" alt="обои">
                </div>
                <ul class="description">
                    <li>
                        <c:out value="${catalog.get(list.getGoods().getId() - 1).getName()}"/>
                    </li>
                    <li>
                        <c:out value="${catalog.get(list.getGoods().getId() - 1).getCollection()}"/>
                    </li>
                    <li>
                        <c:out value="${catalog.get(list.getGoods().getId() - 1).getDescription()}"/>
                    </li>
                    <li>
                        <c:out value="${catalog.get(list.getGoods().getId() - 1).getSize()}"/>
                    </li>
                    <li>
                        <c:out value="${catalog.get(list.getGoods().getId() - 1).getCountry()}"/>
                    </li>
                    <li>
                        Арт.<c:out value="${catalog.get(list.getGoods().getId() - 1).getVendorCode()}"/>
                    </li>
                    <li>
                        № заказа:${list.getId()}
                    </li>
                </ul>
                <div class="box">
                    <div class="price">
                        <c:if test="${catalog.get(list.getGoods().getId() - 1).getSale() != 0}">
                            <p class="newPrice">
                                Новая цена: $<b class="sum">${catalog.get(list.getGoods().getId() - 1).getSalePrice()}</b>
                            </p>
                            <p class="oldPrice">
                                Старая цена: $${catalog.get(list.getGoods().getId() - 1).getPrice()}
                            </p>
                            <p class="sale">
                                Скидка ${catalog.get(list.getGoods().getId() - 1).getSale()}%!
                            </p>
                        </c:if>
                        <c:if test="${catalog.get(list.getGoods().getId() - 1).getSale() == 0}">
                            <p class="newPrice">Цена: $<b class="sum"><c:out value="${catalog.get(list.getGoods().getId() - 1).getPrice()}"/></b></p>
                        </c:if>
                    </div>
                    <div class="buy" id="${list.getId()}">
                        <p>Количество трубок:</p>
                        <input class="amount" type="number" value=${list.getAmount()} min="0" max="99">
                        <br>
                        <button type="button" class="btn btn-success delete">Удалить</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div id="bodyOld">
    <div class="btn-group">
        <button type="button" class="btn btn-default basket">Корзина</button>
        <button type="button" class="btn btn-default oldOrders">Прошлые заказы</button>
        <button type="button" class="btn btn-default edit-but">Изменить профиль</button>
    </div>
    <div class="navbar-collapse collapse searchBar">
        <h1>Мои прошлые заказы:</h1>
    </div>
    <table class="table table-hover">
        <tr>
            <th>№ заказа</th>
            <th>Название</th>
            <th>Коллекция</th>
            <th>Размер</th>
            <th>Артикул</th>
            <th>Скидка</th>
            <th>шт.</th>
            <th>Итоговая цена</th>
        </tr>
        <c:forEach var="order" items="${oldOrders}">
            <tr>
                <td><c:out value="${order.getId()}"/></td>
                <td><c:out value="${catalog.get(order.getGoods().getId() - 1).getName()}"/></td>
                <td><c:out value="${catalog.get(order.getGoods().getId() - 1).getCollection()}"/></td>
                <td><c:out value="${catalog.get(order.getGoods().getId() - 1).getSize()}"/></td>
                <td><c:out value="${catalog.get(order.getGoods().getId() - 1).getVendorCode()}"/></td>
                <td><c:out value="${catalog.get(order.getGoods().getId() - 1).getSale()}"/>%</td>
                <td><c:out value="${order.getAmount()}"/></td>
                <td><c:out value="${catalog.get(order.getGoods().getId() - 1).getSalePrice() * order.getAmount()}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>