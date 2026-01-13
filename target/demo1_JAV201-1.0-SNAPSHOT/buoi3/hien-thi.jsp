<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/10/2026
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>banphim</title>
</head>
<body>
<h1>FORM THONG TIN</h1>
<form action="/ban-phim/them" method="post">
    Ten ban phim: <input type="text" name="tenBanPhim"><br>
    Tinh trang: <br>
    <input type="radio" name="tinhTrang" value="true" checked>Hoạt động
    <input type="radio" name="tinhTrang" value="false" >Không hoạt động
    <br>
    Gia: <input type="number" step="any" name="gia"><br>
    So luong: <input type="number" name="soLuong">

    <button>Save</button>
</form>

<table border="1" style="border-collapse: collapse">
    <thead>
    <tr>
        <th>Id</th>
        <th>Ten ban phim</th>
        <th>Tinh trang</th>
        <th>Gia</th>
        <th>So luong</th>
        <th>Hanh dong</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items = "${listBanPhim}" var="bp">
        <tr>
            <td>${bp.id}</td>
            <td>${bp.tenBanPhim}</td>
            <td>${bp.tinhTrang? "Hoạt động" : "Không hoạt động"}</td>
            <td>${bp.gia}</td>
            <td>${bp.soLuong}</td>
            <td><button><a href="/ban-phim/view-update?id=${bp.id}">View Update</a></button>
            <button><a href="/ban-phim/xoa?id=${bp.id}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
