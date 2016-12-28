<%--
  Created by IntelliJ IDEA.
  User: mykola.dekhtiarenko
  Date: 12.12.16
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel='stylesheet' href='<c:url value="/resources/css/popupinput.css" />' type='text/css' media='all'/>
    <script src="/resources/javascript/add.js"></script>
    <title>Додати дисципліну</title>
</head>
<body>
<div id="popup" class="popupinput">
    <div class="popup-content">
        <h3>Змініть дані</h3>
        <form:form method="POST" modelAttribute="DisciplineForm" action="${pageContext.request.contextPath}/discipline/edit/${discipline.id}">
        <div class="form-group">
            <label for="name"> Назва:</label>
            <form:input id="name" class="form-control" value="${discipline.name}" type="text" path="name"/>
            <br>
            <label for="credits">Кількість кредитів: </label>
            <form:input class="form-control" value="${discipline.credits}" path="credits"/><br>
            <form:checkbox class="recommended" value="${discipline.recommended}" path="recommended"/>Рекомендована
            <br>
            <div id="close" class="btn btn-default">Відмінити</div>
            <form:button id="add" type="submit" class="btn btn-primary">Змінити</form:button>
        </div>
        </form:form>
    </div>
</div>
</body>
</html>
