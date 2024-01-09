<%@ page import="java.util.List" %>
<%@ page import="com.nhnacademy.studentmanagement.students.Student" %><%--
  Created by IntelliJ IDEA.
  User: nhnacademy
  Date: 24. 1. 8.
  Time: 오후 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>student - list</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
    <h1 class="student">학생 리스트</h1>
    <p><a href="/student/register.do">학생(등록)</a> </p>
    <table id="studentTable">
        <thead>
            <tr>
                <th>아이디</th>
                <th>이름</th>
                <th>성별</th>
                <th>나이</th>
                <th>cmd</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="studnet" items="${studentList}">
                <tr>
                    <td>${studnet.id}</td>
                    <td>${studnet.name}</td>
                    <td>${studnet.gender}</td>
                    <td>${studnet.age}</td>
                    <td><a href="/student/view.do?id=${studnet.id}">조회</a> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
