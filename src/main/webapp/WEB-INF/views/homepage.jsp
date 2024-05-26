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


<nav class="navbar navbar-expand-lg navbar-light bg-primary">
    <div class="container-fluid">
        <p class="navbar-brand" href="#">Menu</p>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
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
                    <a class="nav-link dropdown-toggle active bg-primary" href="#" id="navbarDropdownMenuLink"
                       role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Chi tiết
                    </a>
                    <ul class="dropdown-menu bg-primary" aria-labelledby="navbarDropdownMenuLink">
                        <li><a class="dropdown-item bg-primary" href="/color/data">Màu Sắc</a></li>
                        <li><a class="dropdown-item bg-primary" href="/size/data">Kích thước</a></li>
                    </ul>
                </li>

            </ul>
            <a href="/login" class="d-flex btn btn-warn ">Đăng xuất</a>
        </div>
    </div>
</nav>

<br>
<h1>Xin chào: ${user}</h1>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>