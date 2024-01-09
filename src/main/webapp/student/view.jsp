<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2024-01-08
  Time: 오후 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>--%>
<html>
<head>
    <title>학생-조회</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
<table id="studentView">
    <thead>
        <tr>
            <td colspan="2">상세 정보</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>아이디</td>
            <td>${student.id}</td>
        </tr>
        <tr>
            <td>이름</td>
            <td>${student.name}</td>
        </tr>
        <tr>
            <td>성별</td>
            <td>${student.gender}</td>
        </tr>
        <tr>
            <td>나이</td>
            <td>${student.age}</td>
        </tr>
        <tr>
            <td>등록일</td>
            <td>${student.createdAt}</td>
        </tr>

    </tbody>
</table>
<ul>
    <li><a href="/student/list.do">리스트</a></li>
    <li>
        <c:url var="update_link" value="/student/update.do">
            <c:param name="id" value="${student.id}"/>
        </c:url>
        <a href="${update_link}">수정</a>
    </li>
    <li>
        <form action="/student/delete.do">
            <input type="hidden" name="id" value="${student.id}">
            <button type="submit" formmethod="post">삭제</button>
        </form>
     </li>
 </ul>

</body>
</html>
