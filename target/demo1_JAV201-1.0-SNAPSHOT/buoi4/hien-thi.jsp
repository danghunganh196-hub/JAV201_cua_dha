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
    Gioi tinh: <input type="radio" name="gioiTinh" value="true" checked>Nữ
    <input type="radio" name="gioiTinh" value="false">Nam<br>
    Ten truong:
    <select name="truongId">
        <c:forEach items="${listTruongHoc}" var="th">
            <option value="${th.id}">
                    ${th.tenTruong}
            </option>
        </c:forEach>
    </select>
    <br>
    <button>Save</button>
</form>
    <table border="1" style="border-collapse: collapse">
        <thead>
        <tr>
        <th>Id</th>
        <th>Ten giang vien</th>
        <th>Tuoi</th>
        <th>Gioi tinh</th>
        <th>Ten truong</th>
        <th>Dia chi</th>
        <th>Hanh dong</th>
        </tr>
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
                    <td><a href="/giang-vien/view-update?id=${gv.id}"><button>Update</button></a>
                    <a href="/giang-vien/xoa?id=${gv.id}"><button>Delete</button></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
