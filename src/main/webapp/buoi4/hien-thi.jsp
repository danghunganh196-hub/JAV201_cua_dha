<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/13/2026
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>buoi4</title>
</head>
<body>
<form action="/giang-vien/them" method="post">
    Id: <input type="text" readonly placeholder="ID TU SINH" name="id"><br>
    Ten giang vien: <input type="text" name="tenGiangVien"><br>
    Tuoi: <input type="number" name="tuoi"><br>
    Gioi tinh: <input type="radio" name="gioiTinh" value="true" checked>
    <input type="radio" name="gioiTinh" value="false"><br>
<%--    Id truong: <input type="number" name="truong_id">--%>
    Ten truong: <input type="text" name="tenTruong"><br>
    Dia chi: <input type="text" name="diaChi"><br>
    <button>Save</button>
</form>
    <table border="1" style="border-collapse: collapse">
        <thead>
        <th>Id</th>
        <th>Ten giang vien</th>
        <th>Tuoi</th>
        <th>Gioi tinh</th>
        <th>Ten truong</th>
        <th>Dia chi</th>
        <th>Hanh dong</th>
        </thead>
        <tbody>
        <c:forEach items="${listGiangVien}" var = "gv">
            <tr>
                <td>${gv.id}</td>
                <td>${gv.tenGiangVien}</td>
                <td>${gv.tuoi}</td>
                <td>${gv.gioiTinh == false ? "Nam" : "Nữ"}</td>
                <td>${gv.truongHoc.tenTruong}</td>
                <td>${gv.truongHoc.diaChi}</td>
                <td><button><a href="/giang-vien/view-update?id=${gv.id}">Update</button></a>
                <button><a href="/giang-vien/xoa?id=${gv.id}">Delete</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
