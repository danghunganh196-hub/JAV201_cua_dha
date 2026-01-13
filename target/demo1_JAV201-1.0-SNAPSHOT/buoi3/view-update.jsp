<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/10/2026
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>viewupd</title>
</head>
<body>
    <h1>FORM SUA BAN PHIM</h1>
    <form action="/ban-phim/sua" method="post">
        Id: <input type="text" name="id" value="${bp.id}" readonly><br>
        Ten ban phim: <input type="text" name="tenBanPhim" value="${bp.tenBanPhim}"><br>
        Tinh trang: <input type="radio" name="tinhTrang" value="true" ${bp.tinhTrang? "checked" : ""}>Hoạt động
        <input type="radio" name="tinhTrang" value="false" ${!bp.tinhTrang? "checked" : ""}>Ko hoạt động <br>
        Gia: <input type="number" step="any" value="${bp.gia}" name="gia"><br>
        So luong: <input type="number"value="${bp.soLuong}" name="soLuong">
        <button>Save</button>
    </form>
</body>
</html>
