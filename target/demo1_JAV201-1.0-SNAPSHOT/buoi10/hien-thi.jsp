<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/27/2026
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view</title>
</head>
<body>
<form action="/don-hang/tim-kiem-trang-thai" method="get">
    <h1>Form tim kiem theo trang thai</h1>

    Trang thai:
    <input type="radio" name="trangThai" value="true">Da giao
    <input type="radio" name="trangThai" value="false">Chua giao <br>

    <button>Find</button>

</form>

<form action="/don-hang/them" method="post">
    <h1>Form them</h1>
    Id: <input type="text" hidden name="id"><br>
    Khach hang: <input type="text" name="khachHang" required><br>
    So luong: <input type="number" name="soLuong" required><br>
    Trang thai: <input type="radio" name="daGiao" value="true" required>Da giao
    <input type="radio" name="daGiao" value="false">Chua giao <br>
    Ten mon an:
    <select name="id_mon_an">
        <c:forEach items="${listMonAn}" var="ma">
            <option value="${ma.id}" label="${ma.tenMon}"></option>
        </c:forEach>
    </select>
    <br>

    <button>Save</button>
</form>

<form action="/don-hang/sap-xep" method="get">
    <h1>Form tim kiem theo so luong</h1>
    Min: <input type="number" name="min"><br>
    Max: <input type="number" name="max">

    <button>Tim</button>
</form>

<table>
    <thead>
    <td>Id</td>
    <td>Khach hang</td>
    <td>So luong</td>
    <td>Da giao</td>
    <td>Ten mon an</td>
    <td>Gia tien</td>
    <td>Hanh dong</td>
    </thead>

    <tbody>
    <c:forEach items="${listDonHang}" var="dh">
        <tr>
            <td>${dh.id}</td>
            <td>${dh.khachHang}</td>
            <td>${dh.soLuong}</td>
            <td>${dh.daGiao == true ? "Da giao" : "Chua giao"}</td>
            <td>${dh.monAn.tenMon}</td>
            <td>${dh.monAn.giaTien * dh.soLuong}</td>
            <td>
                <a href="/don-hang/view-update?id=${dh.id}">Update</a>
                <a href="/don-hang/xoa?id=${dh.id}">Xoa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
