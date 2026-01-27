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
<form action="/giang-vien/tim-kiem" method="get">
    <h1>Form tim kiem</h1>
    Ten can tim: <input type="text" name="tenGiangVien" required><br>
    <button>Find</button>
</form>
<form action="/giang-vien/them" method="post">
    <h1>Form them</h1>
    Id: <input type="text" readonly placeholder="ID TU SINH" name="id"><br>
    Ten giang vien: <input type="text" name="tenGiangVien" required><br>
    Tuoi: <input type="number" name="tuoi" required><br>
    Gioi tinh: <input type="radio" name="gioiTinh" value="true">Nữ
    <input type="radio" name="gioiTinh" value="false">Nam<br>
    Ten truong:
    <select name="truongId">
        <c:forEach items="${listTruongHoc}" var="th">
            <option value="${th.id}" label="${th.tenTruong}"></option>
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
<a href="/giang-vien/phan-trang?page=0">First</a>
<a href="/giang-vien/phan-trang?page=${page == 0 ? 0 : page - 1}">Previous</a>
<a href="/giang-vien/phan-trang?page=${page == totalPages - 1 ? 0 : page + 1}">Next</a>
<a href="/giang-vien/phan-trang?page=${totalPages - 1}">Last</a> <br> <br>

<a href="/giang-vien/hien-thi">QUAY VE TRANG CHINH</a> <br>

<c:forEach begin="0" end="${totalPages - 1}" varStatus="i">
    <a href="/giang-vien/phan-trang?page=${i.index}"
       style="${page == i.index ? "color : red" : ""}">
            ${i.index + 1}
    </a>
</c:forEach>
</body>
</html>
