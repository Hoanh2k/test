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
        Thông tin sản phẩm chi tiết
    </div>
    <div class="card-body">
        <ul>
            <li>ID: ${productdetail.id}</li>
            <li>Mã CTSP: ${productdetail.maSPCT}</li>
            <li>Id Size: ${productdetail.idKichThuoc}</li>
            <li> Id màu: ${productdetail.idMauSac}</li>
            <li> Id SP: ${productdetail.idSanPham}</li>
            <li> Số lượng: ${productdetail.soLuong}</li>
            <li> Đơn giá: ${productdetail.donGia}</li>
            <li>Tình trạng: ${!productdetail.trangThai?"Hết hàng":"Còn hàng"}</li>
        </ul>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>