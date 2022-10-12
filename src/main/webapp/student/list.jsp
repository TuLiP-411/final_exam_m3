<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Student: LINH
  Date: 9/30/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management Application</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>

        .button_plus {
            position: absolute;
            width: 40px;
            height: 40px;
            background: #fff;
            cursor: pointer;
            border: 2px solid #095776;
            top: 18%;
            left: 58%;
        }

        .button_plus:after {
            content: '';
            position: absolute;
            transform: translate(-50%, -50%);
            height: 4px;
            width: 50%;
            background: #095776;
            top: 50%;
            left: 50%;
        }

        .button_plus:before {
            content: '';
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: #095776;
            height: 50%;
            width: 4px;
        }

        .button_plus:hover:before,
        .button_plus:hover:after {
            background: #fff;
            transition: 0.2s;
        }

        .button_plus:hover {
            background-color: #095776;
            transition: 0.2s;
        }
    </style>
</head>
<body>
<center>
    <h1>Student Management</h1>
</center>
<div align="center">
    <tr>
        <td>
            <form method="post" action="student?action=search">
                <input style="width: 450px;height: 35px" type="text" name="searchByName" id="searchByName"
                       placeholder="Enter student name">
                <input class="btn btn-outline-primary" style="width: 100px;height: 35px" type="submit" value="Search">
            </form>
        </td>
    </tr>
    <br>
</div>
<div align="center">
    <caption>
        <h2>List of Students
            <a href="/student?action=create">
                <div class="button_plus"></div>
            </a>
        </h2>
        <br>
    </caption>
</div>
<div align="center">
    <table border="1" cellpadding="5" class="table table-striped table-hover table-bordered" style="width: 80%">
        <thead class="table-primary">
        <tr>
            <th>ID
            </th>
            <th>Name
            </th>
            <th>Date of birth
            </th>
            <th>Address
            </th>
            <th>Phone Number
            </th>
            <th>Email
            </th>

            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="student" items="${listStudent}">
            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.dob}"/></td>
                <td><c:out value="${student.address}"/></td>
                <td><c:out value="${student.phone}"/></td>
                <td><c:out value="${student.email}"/></td>

                <td>
                    <a href="/student?action=edit&id=${student.id}">
                        <button class="btn btn-warning">Edit</button>
                    </a>
                    <a href="/student?action=delete&id=${student.id}">
                        <button class="btn btn-danger">Delete</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
