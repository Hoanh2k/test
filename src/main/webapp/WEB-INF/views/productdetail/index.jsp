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

<nav class="navbar navbar-expand-lg navbar-light bg-primary">
    <div class="container-fluid">
        <p class="navbar-brand" href="#" >Menu</p>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/invoice">Hóa đơn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/invoicedetail">Hóa đơn chi tiết</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/productdetail">Sản phẩm chi tiết</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/product/data">Sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/guest/data">Khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/staff/data">Nhân viên</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active bg-primary" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Chi tiết
                    </a>
                    <ul class="dropdown-menu bg-primary" aria-labelledby="navbarDropdownMenuLink">
                        <li><a class="dropdown-item bg-primary" href="#">Màu Sắc</a></li>
                        <li><a class="dropdown-item bg-primary" href="#">Kích thước</a></li>
                    </ul>
                </li>
            </ul>
            <a href="/login" class="d-flex btn btn-warn ">Đăng xuất</a>
        </div>
    </div>
</nav>

<div>
    <form action="/productdetail/search?code=${code}" method="get">
        <b>Mã </b><input name="code"/>
        <button class="btn btn-success">Tìm</button>
    </form>
</div>

<div>
    <div class="card">
        <div class="card-header">
            Danh sách
        </div>
        <div class="card-body">
            <a href="/productdetail/add" class="btn btn-success">Thêm mới</a>
        </div>
        <hr>

<table class="table">
    <thead>
    <th>STT</th>
    <th>ID</th>
    <th>MÃ SPCT</th>
    <th>ID KT</th>
    <th>ID MS</th>
    <th>ID SP</th>
    <th>SỐ LƯỢNG</th>
    <th>GIÁ BÁN</th>
    <th>TRẠNG THÁI</th>
    <th>Action</th>
    </thead>
    <tbody>

    <c:forEach items="${list}" var="st" varStatus="i">
        <tr>
            <td>${i.index + 1} </td>
            <td>${st.id} </td>
            <td>${st.maSPCT}</td>
            <td>${st.idKichThuoc}</td>
            <td>${st.idMauSac}</td>
            <td>${st.idSanPham}</td>
            <td>${st.soLuong}</td>
            <td>${st.donGia}</td>
            <td>${!st.trangThai?"Hết hàng":"Còn hàng"}</td>
            <td><a href="/productdetail/detail/${st.id}">Chi tiết</a>
                <a href="/productdetail/update/${st.id}">Sửa</a>
                <a href="/productdetail/delete/${st.id}">XÓa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${currentPage > 0}">
                    <li class="page-item"><a class="page-link" href="?page=${currentPage - 1}">Previous</a></li>
                </c:if>
                <c:forEach begin="0" end="${totalPages - 1}" var="i">
                    <li class="page-item ${i == currentPage ? 'active' : ''}">
                        <a class="page-link" href="?page=${i}">${i + 1}</a>
                    </li>
                </c:forEach>
                <c:if test="${currentPage < totalPages - 1}">
                    <li class="page-item"><a class="page-link" href="?page=${currentPage + 1}">Next</a></li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>