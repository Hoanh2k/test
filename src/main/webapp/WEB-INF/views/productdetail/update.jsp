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
<h3>Sửa thông tin</h3>
<form:form action="/productdetail/add" method="post" modelAttribute="productdetail">
    Id: <form:input path="id" value="${pd.id}" readonly="true"/><br>
    <form:errors path="id"/>
    <br>
    MãSPCT:<form:input path="maSPCT" value="${pd.maSPCT}" readonly="true"/><br>
    <form:errors path="maSPCT"/><br>
    idKT:<form:input path="idKichThuoc" value="${pd.idKichThuoc}"/><br>
    <form:errors path="idKichThuoc"/><br>
    idMS:<form:input path="idMauSac" value="${pd.idMauSac}"/><br>
    <form:errors path="idMauSac"/><br>
    idSP:<form:input path="idSanPham" value="${pd.idSanPham}"/><br>
    <form:errors path="idSanPham"/><br>
    Số lượng:<form:input path="soLuong" value="${pd.soLuong}"/><br>
    <form:errors path="soLuong"/><br>
    Đơn giá:<form:input path="donGia" value="${pd.donGia}"/><br>
    <form:errors path="donGia"/><br>
    trạng thái:
    <input type="radio" name="trangThai" checked value="true" ${pd.trangThai?"checked":""}/>Còn hàng
    <input type="radio" name="trangThai" value="false" ${pd.trangThai?"":"checked"}/>Hết hàng
    <br/>
    <button>Save</button>
</form:form>
</body>
</html>