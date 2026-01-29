<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/27/2026
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>viewupdate</title>
</head>
<body>
<form action="/don-hang/sua" method="post">
    Id: <input type="text" hidden name="id" value="${dh.id}"><br>
    Khach hang: <input type="text" name="khachHang" value="${dh.khachHang}"><br>
    So luong: <input type="number" name="soLuong" value="${dh.soLuong}"><br>
    Da giao: <input type="radio" name="daGiao" value="true" ${dh.daGiao == true ? "checked" : ""}>Da giao
    <input type="radio" name="daGiao" value="false" ${dh.daGiao == false ? "checked" : ""}>Chua giao <br>
    Ten mon an:
    <select name="id_mon_an">
        <c:forEach items="${listMonAn}" var="ma">
            <option value="${ma.id}" label="${ma.tenMon}" ${dh.monAn.id == ma.id ? "selected" : ""}></option>
        </c:forEach>
    </select>
    <br>

    <button>Save</button>
</form>
</body>
</html>
