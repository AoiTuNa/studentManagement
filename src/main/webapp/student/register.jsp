<%--
  Created by IntelliJ IDEA.
  User: nhnacademy
  Date: 24. 1. 8.
  Time: 오후 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학생정보 등록</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
<form method="post" action="/student/register">
    <table id="studentRegister">
        <thead>
            <tr>
                <td colspan="2">정보입력</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name"> </td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <hgroup>
                        <input type="radio" name="gender"/>남
                        <input type="radio" name="gender"/>여
                    </hgroup>
                </td>
            </tr>
            <tr>
                <td>나이</td>
                <td><input type="text" name="age"> </td>
            </tr>
        </tbody>
    </table>
    <input type="submit" name="전송" value="등록" >
</form>
</body>
</html>
