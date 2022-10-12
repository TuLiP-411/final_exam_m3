<%--
  Created by IntelliJ IDEA.
  User: LINH
  Date: 9/30/2022
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Create</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        .card-registration .select-input.form-control[readonly]:not([disabled]) {
            font-size: 1rem;
            line-height: 2.15;
            padding-left: .75em;
            padding-right: .75em;
        }

        .card-registration .select-arrow {
            top: 13px;
        }

    </style>
</head>
<body>
<div align="center">
    <br>
    <c:if test="${requestScope['message']!=null}">
        <span style="color: green">${requestScope['message']}</span>
    </c:if>
</div>

<div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col">
            <div class="card card-registration my-4">
                <div class="row g-0">
                    <div class="card-body p-md-5 text-black">
                        <h5>
                            <a href="student">
                                <button class="btn btn-outline-primary" style="width: 90px">Back</button>
                            </a>
                        </h5>
                        <h3 class="mb-5 text-uppercase text-center">Đăng ký học sinh mới</h3>
                        <form method="post">
                            <div class="form-outline mb-4">
                                <label class="form-label" for="name">Họ và tên</label>
                                <input type="text" placeholder="Nhập họ và tên" id="name" name="name"
                                       class="form-control form-control-md"/>

                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="dob">Ngày sinh</label>
                                <input type="date" id="dob" name="dob"
                                       class="form-control form-control-md"/>
                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="email">Email</label>
                                <input type="text" placeholder="VD: 'abc123@gmail.com'" id="email" name="email"
                                       class="form-control form-control-md"/>

                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="phone">Số điện thoại</label>
                                <input type="text" placeholder="Nhập số điện thoại" id="phone" name="phone"
                                       class="form-control form-control-md"/>

                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="address">Địa chỉ</label>
                                <input type="text" placeholder="Nhập địa chỉ" id="address" name="address"
                                       class="form-control form-control-md"/>

                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label" for="class_id">Chọn lớp</label>

                                <select name="class_id" id="class_id" class="form-control form-control-md">
                                    <option value="1">CGMDC0622I1</option>
                                    <option value="2">CGMDC0522H1</option>
                                    <option value="3">CGTXC0322G1</option>
                                    <option value="4">CGTXC0822I1</option>
                                </select>
                            </div>
                            <div class="d-flex justify-content-end pt-3">
                                <button type="reset" class="btn btn-light btn-lg ">Reset all</button>
                                <button type="submit" class="btn btn-lg ms-2 btn-primary">
                                    Submit form
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
