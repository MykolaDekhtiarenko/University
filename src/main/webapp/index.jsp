<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all'/>
</head>
<body>
<c:if test="${not empty list}">
    <table>
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
            <td>${object.recommended}</td>
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
</body>
</html>