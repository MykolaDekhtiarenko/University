<%--
  Created by IntelliJ IDEA.
  User: mykola.dekhtiarenko
  Date: 04.12.16
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Latest compiled and minified CSS -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


    <link rel='stylesheet' href='<c:url value="/resources/css/popupinput.css" />' type='text/css' media='all'/>

    <script src="/resources/javascript/table.js"></script>
    <script src="/resources/javascript/supervisor.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Методист</title>
</head>
<body>


<div class="container-fluid">
    <center><h2>Користувач: ${name}</h2></center>
    <center><a class="btn btn-default" href="${pageContext.request.contextPath}/logout">Вийти з системи</a></center>
</div>
<div class="container">
    <div id="table" class="col-md-12">
        <%--<div id="responce"></div>--%>
        <c:if test="${not empty alldisciplines}">
            <form>
                <input name="disciplines" id="recommendedButton" type="radio" > Рекомендовані
                <input name="disciplines" id="allButton" type="radio" checked> Усі<br>
            </form>
            <table class="table">
                <tr>
                    <c:if test="${period=='preparatory'}"><th>Редагувати</th></c:if>
                    <th>Назва</th>
                    <th>Кредити</th>
                    <th>Рекомендована</th>
                    <th>Викладач</th>
                    <th>Аннотація</th>
                    <th>Студенти</th>
                </tr>
                <c:forEach items="${alldisciplines}" var="object">
                    <tr>
                        <c:if test="${period=='preparatory'}"><td>
                                <a class="edit" href="/edit/${object.id}">Редагувати<samp class="displaynone"></samp></a><br>
                                <a class="edit" href="/editXML/${object.id}">Редагувати XML файл<samp class="displaynone"></samp></a>
                        </td></c:if>
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
</div>
</div>
</div>
</body>
</html>
