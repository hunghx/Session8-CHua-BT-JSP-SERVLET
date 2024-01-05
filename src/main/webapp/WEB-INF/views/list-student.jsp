<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 1/5/2024
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Danh sách sinh viên</h1>
<a href="/StudentServlet?action=ADD">Thêm mới sinh viên</a>

<br>
<table border="10" cellpadding="10" cellspacing="10">
    <thead>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Age</td>
                <td>Sex</td>
                <td colspan="2">Action</td>
            </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="st">
        <tr>
            <td>${st.id}</td>
            <td>${st.name}</td>
            <td>${st.age}</td>
            <td>${st.sex?"Nam":"Nữ"}</td>
            <td><a href="/StudentServlet?action=EDIT&id=${st.id}">Sửa</a></td>
            <td><a onclick="return confirm('Bạn có chắc chắn muốn xóa không ?')" href="/StudentServlet?action=DELETE&id=${st.id}">Xóa</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
