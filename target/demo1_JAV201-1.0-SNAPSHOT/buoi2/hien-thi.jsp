<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/8/2026
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <input type="hidden" name="id" value="${thid.id}">
    <input type="text" name="tenTruong" value="${thid.tenTruong}" placeholder="Nhap ten truong">
    <input type="text" name="diaChi" value="${thid.diaChi}" placeholder="Nhap dia chi">

    <button formaction="/truong-hoc/them" type="submit">Them</button>

    <button formaction="/truong-hoc/sua" type="submit">Sua</button>
</form>
Bang thong tin:
<table border="1" style="border-collapse: collapse">
    <a href="/truong-hoc/hien-thi">HIEN THI</a>
    <thead>
    <tr>
        <th>Id</th>
        <th>Ten truong</th>
        <th>Dia chi</th>
        <th>Hanh dong</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listTruongHoc}" var="th">
        <tr>
            <td>${th.id}</td>
            <td>${th.tenTruong}</td>
            <td>${th.diaChi}</td>
            <td><button><a href="/truong-hoc/view-update?id=${th.id}">Detail</a></button>
            <button><a href="/truong-hoc/xoa?id=${th.id}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
