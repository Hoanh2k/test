<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
<form:form action="/invoicedetail/add" method="post" modelAttribute="invoicedetail">
    Id: <form:input path="id"/><br>
    <form:errors path="id"/>
    <br>
    IdNV:<form:input path="idHoaDon"/><br>
    <form:errors path="idHoaDon"/><br>
    idKH:<form:input path="idSPCT"/><br>
    <form:errors path="idSPCT"/><br>
    So luong:<form:input path="soLuong"/><br>
    <form:errors path="soLuong"/><br>
    Don gia:<form:input path="donGia"/><br>
    <form:errors path="donGia"/><br>
    trạng thái:
    <input type="radio" name="trangThai" checked value="true"/>1 chấm là ...
    <input type="radio" name="trangThai" value="false"/>2 chấm là .....
    <br/>
    <button type="submit">Save</button>
</form:form>
</body>
</html>