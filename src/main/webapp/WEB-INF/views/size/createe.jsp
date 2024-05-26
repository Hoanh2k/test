<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<div class="card" style="width: 30rem">
    <div class="card-header">
        <h3>Thêm mới</h3>
    </div>
    <div class="card-body">
        <form:form action="/size/add" method="post" modelAttribute="size">
            ID: <form:input path="id" class="form-control"/>
            <form:errors path="id"/>
            <br> Mã: <form:input path="code" class="form-control"/>
            <form:errors path="code"/>
            <br>Tên: <form:input path="name" class="form-control"/>
            <form:errors path="name"/>
            <br>Tình trạng: <form:radiobutton path="status" value="true" checked="checked" class="form-check-input"/>Hoạt động
                    <form:radiobutton path="status" value="false" class="form-check-input"/>Không hoạt động
            <br> <button class="btn btn-success">Lưu</button>
        </form:form>
    </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>