<%--
  Created by IntelliJ IDEA.
  User: mykola.dekhtiarenko
  Date: 06.12.16
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty alldisciplines}">
    <form>
        <div class="alert alert-success">
            <strong>${responce}</strong>
        </div>
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
                <c:if test="${period=='preparatory'}"><td><a class="edit"  disciplineId="${object.id}" disciplineTeacher="${object.teacher}" disciplineDescription="${discipline.description}">Редагувати<samp class="displaynone"></samp></a></td></c:if>
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
