<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/16/2026
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>viewupd</title>
</head>
<body>
<form action="/giang-vien/sua" method="post">
    Id: <input type="hidden" name="id" value="${gv.id}"><br>
    Ten giang vien: <input type="text" name="tenGiangVien" value="${gv.tenGiangVien}"><br>
    Tuoi: <input type="number" name="tuoi" value="${gv.tuoi}"><br>
    Gioi tinh: <input type="radio" name="gioiTinh" value="true" ${gv.gioiTinh == true ? "checked" : ""}>Nữ
    <input type="radio" name="gioiTinh" value="false" ${gv.gioiTinh == false ? "checked" : ""}>Nam<br>
    Ten truong:
    <select name="truongId">
        <c:forEach items="${listTruongHoc}" var="th">
            <option value="${th.id}" label="${th.tenTruong}" ${gv.truongHoc.id == th.id ? "selected" : ""}></option>
        </c:forEach>
    </select>
    <br>
    <button>Save</button>
</form>
</body>
</html>
