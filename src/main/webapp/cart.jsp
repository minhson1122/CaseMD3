<%@ page import="com.example.casestudymd3.model.Game" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/5/2023
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
            display: flex;
            justify-content: space-between;
        }

        #search-container {
            display: flex;
            align-items: center;
        }

        #search-input {
            margin-right: 10px;
        }

        #search-button {
            padding: 5px 10px;
        }

        nav {
            background-color: #444;
            color: white;
            padding: 10px;
            display: flex;
            justify-content: space-around;
        }

        nav a {
            color: white;
            text-decoration: none;
        }

        main {
            display: flex;
            justify-content: space-between;
            padding: 20px;
        }

        .product img {
            max-width: 100%;
            height: auto;
            margin-bottom: 10px;
        }

        footer {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
    <title>Giỏ hàng của bạn</title>
</head>
<body>
<%
    HttpSession sessions = request.getSession(false); // Thêm tham số false để không tạo mới session nếu nó không tồn tại
    String username = (sessions != null) ? (String) sessions.getAttribute("username") : null;
%>

<%if (username != null) {%>
<h4>Welcome, <%= username %>!</h4>
<%} else {%>
<h4>Welcome, Guest!</h4>
<%}%>
<header>
    <!-- Your logo/image goes here -->
    <a href="/home"> <img  src="https://upload.wikimedia.org/wikipedia/commons/0/0d/Nintendo.svg" alt="Your Logo" height="50"></a>


    <div id="search-container">
        <input type="text" id="search-input" placeholder="Search">
        <button id="search-button">Search</button>
    </div>
    <div>
        <% if (username != null) { %>
        <button><a href="logout">Đăng xuất</a></button>
        <button><a href="/cart">Đây là ô giỏ hàng</a></button>
        <button><a href="/infor">Hiện thông tin user</a></button>
        <% } else { %>
        <button><a href="account/login">Đăng nhập</a></button>
        <button><a href="account/register">Đăng ký</a></button>
        <% } %>

    </div>
</header>
<br>
<main>
    <div class="container">
        <div class="col-12 col-md-12">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-md-12 title-text">
                            <h1 style="text-align: center">Giỏ hàng của bạn</h1>
                            <a href="/home" class="btn btn-success">Quay lại mua sắm</a>

                        </div>
                    </div>

                </div>
                <div class="card-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">User Name</th>
                            <th scope="col">Name</th>
                            <th scope="col">Name Game</th>
                            <th scope="col">Price Game</th>

                            <th></th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                        <h4>Total :</h4>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>
<footer>
    <p>Home</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
