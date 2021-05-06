<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<h1>Index</h1>

<div class="w3-container">

    <table class="w3-table w3-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Code</th>
            <th>Email</th>
            <th>Birth</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        <c:forEach var="p" items="${students}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.code}</td>
                <td>${p.birth}</td>
                <td>${p.email}</td>
                <td>${p.phone}</td>
                <td>${p.address}</td>
                <td>
                    <a href="/edit?id=${emp.id}" >Edit</a>
                </td>
                <td>
                    <form action="/api/product/delete?id=${p.id}" method="post">
                        <input type="submit" value="Delete" style="background:none;border:0px;cursor: pointer;"/>
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>