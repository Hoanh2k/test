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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Document</title>
</head>
<body>

<div class="card">
    <div class="card-header">
        Thêm mới sản phẩm
    </div>
    <div class="card-body">
        <form:form action="/product/add" method="post" modelAttribute="product">
            ID: <form:input path="id"/><br>
            <form:errors path="id"/>
            <br> Mã<form:input path="code"/> <br>
            <form:errors path="code"/>
            <br> Tên: <form:input path="name"/> <br>
            <form:errors path="name"/>
            <br>  Trạng thái: <form:radiobutton path="status" checked="checked" value="true"/>Còn hàng
            <form:radiobutton path="status" value="false"/>Hết hàng
            <br>
            <button>Lưu</button>
        </form:form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>