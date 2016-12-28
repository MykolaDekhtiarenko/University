<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/resources/javascript/table.js"></script>
    <script src="/resources/javascript/index.js"></script>

</head>
<body>
<div class="header">
    <center><button id="login" type="button" class="btn btn-primary">Вхід</button></center>
</div>
<div class="container">
<c:if test="${not empty list}">
    <%--<div><div id="recommendedButton" class="btn-s">Лише рекомендовані</div> <div class="btn-w" id="allButton">Усі</div></div>--%>
    <form>
        <input name="disciplines" id="recommendedButton" type="radio" > Рекомендовані
        <input name="disciplines" id="allButton" type="radio" checked> Усі<br>
    </form>
    <table class="table">
        <tr>
            <th>Назва</th>
            <th>Кредити</th>
            <th>Рекомендована</th>
            <th>Викладач</th>
            <th>Аннотація</th>
            <th>Студенти</th>
        </tr>
    <c:forEach items="${list}" var="object">
        <tr>
            <td>${object.name}</td>
            <td>${object.credits}</td>
            <td class="recommended">${object.recommended}</td>
            <td>${object.teacher}</td>
            <td>${object.description}</td>
            <td>
                <c:forEach items="${object.studentsNames}" var="objectList">
                    ${objectList}
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</div>
</body>
</html>