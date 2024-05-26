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
<form:form action="/invoice/add" method="post" modelAttribute="invoice">
    Id: <form:input path="id" readonly="true" value="${st.id}"/><br>
    <form:errors path="id"/>
    <br>
    IdNV:<form:input path="idNV" value="${st.idNV}"/><br>
    <form:errors path="idNV"/><br>
    idKH:<form:input path="idKH" value="${st.idKH}"/><br>
    <form:errors path="idKH"/><br>
    Ngay mua hang:<form:input path="ngayMuaHang" value="${st.ngayMuaHang}"/><br>
    <form:errors path="ngayMuaHang"/><br>
    trạng thái:
    <input type="radio" name="trangThai" checked value="true" ${st.trangThai?"checked":""}/>Dã thanh toán
    <input type="radio" name="trangThai" value="false" ${st.trangThai?"":"checked"}/>Chưa thanh toán
    <br/>
    <button type="submit">Save</button>
</form:form>
</body>
</html>