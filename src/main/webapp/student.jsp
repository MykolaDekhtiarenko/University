<%--
  Created by IntelliJ IDEA.
  User: mykola.dekhtiarenko
  Date: 03.12.16
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>



    <script src="/resources/javascript/table.js"></script>
    <script src="/resources/javascript/student.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Студент</title>
</head>
<body>
<div class="container-fluid">
    <center><h2>Користувач: ${name}</h2></center>
    <center><h3>Кількість кредитів: ${credits}</h3></center>
    <center><a class="btn btn-default" href="${pageContext.request.contextPath}/logout">Вийти з системи</a></center>
</div>



</div>
    <div class="container">
        <c:if test="${not empty color}">
            <div class="alert ${color}">
                <strong>${responce}</strong>
            </div>
        </c:if>
        <div class="col-md-9">

            <c:if test="${not empty alldisciplines}">
                <form>
                    <input name="disciplines" id="recommendedButton" type="radio" > Рекомендовані
                    <input name="disciplines" id="allButton" type="radio" checked> Усі<br>
                </form>
                <table class="table">
                    <tr>
                        <th>Записатися</th>
                        <th>Назва</th>
                        <th>Кредити</th>
                        <th>Рекомендована</th>
                        <th>Викладач</th>
                        <th>Аннотація</th>
                        <th>Студенти</th>
                    </tr>
                    <c:forEach items="${alldisciplines}" var="object">
                        <tr>
                            <td><c:if test="${period=='sign_in'}"><c:if test="${object.recommended}"><a class="signin" userId="${userId}" disciplineId="${object.id}">Записатися</a></c:if></c:if></td>
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
        <div class="col-md-3">
                <table>
                    <tr>
                        <th>Мої Дисципліни</th>
                    </tr>
                    <c:forEach items="${mydisciplines}" var="object">
                        <tr>
                            <td>${object}</td>
                        </tr>
                    </c:forEach>
                </table>
        </div>
        </div>
    </div>
</div>

</body>
</html>
