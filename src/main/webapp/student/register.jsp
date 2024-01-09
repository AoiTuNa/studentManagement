<%--
  Created by IntelliJ IDEA.
  User: nhnacademy
  Date: 24. 1. 8.
  Time: 오후 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>학생정보 등록</title>
    <link rel="stylesheet" href="style.css"/>
    <meta charset="UTF-8">
</head>
<body>
<c:choose>
    <c:when test="${empty student}">
        <c:url var="action" value="/student/register.do"/>
    </c:when>
    <c:otherwise>
        <c:url var="action" value="/student/update.do"/>
    </c:otherwise>
</c:choose>
<form method="post" action="${action}">
    <table id="studentRegister">
        <thead>
            <tr>
                <td colspan="2">정보입력</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID</td>
                <td><c:choose>
                    <c:when test="${empty student}">
                        <input type="text" name="id" value="${student.id}" required/>
                    </c:when>
                    <c:otherwise>
                        <input type="text" name="id" value="${student.id}" required disabled/>
                    </c:otherwise>
                </c:choose><label>

                </label></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name" value="${student.name}" required> </td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <hgroup>
                        <label>
                            <input type="radio" name="gender" value="M" ${student.gender == 'M' ? 'checked' : ''}/>
                        </label>남
                        <label>
                            <input type="radio" name="gender" value="F" ${student.gender == 'F' ? 'checked' : ''}/>
                        </label>여
                    </hgroup>
                </td>
            </tr>
            <tr>
                <td>나이</td>
                <td><label>
                    <input type="text" name="age" value="${student.age}" required>
                </label></td>
            </tr>
        </tbody>
    </table>
    <p>
        <button type="submit">
            <c:choose>
                <c:when test="${empty student}">
                    등록
                </c:when>
                <c:otherwise>
                    수정
                </c:otherwise>
            </c:choose>
        </button>
    </p>
</form>
</body>
</html>
