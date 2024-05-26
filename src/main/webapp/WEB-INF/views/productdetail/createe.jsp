<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<form:form action="/productdetail/add" method="post" modelAttribute="productdetail">
    Id: <form:input path="id"/><br>
    <form:errors path="id"/>
    <br>
    MãSPCT:<form:input path="maSPCT"/><br>
    <form:errors path="maSPCT"/><br>
    idKT:<form:input path="idKichThuoc"/><br>
    <form:errors path="idKichThuoc"/><br>
    idMS:<form:input path="idMauSac"/><br>
    <form:errors path="idMauSac"/><br>
    idSP:<form:input path="idSanPham"/><br>
    <form:errors path="idSanPham"/><br>
    Số lượng:<form:input path="soLuong"/><br>
    <form:errors path="soLuong"/><br>
    Đơn giá:<form:input path="donGia"/><br>
    <form:errors path="donGia"/><br>
    trạng thái:
    <input type="radio" name="trangThai" checked value="true"/>Còn hàng
    <input type="radio" name="trangThai" value="false"/>Hết hàng
    <br/>
    <button>Save</button>
</form:form>
</body>
</html>