<%@ page import="com.example.casestudymd3.model.Game" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/4/2023
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    <title>Trang chủ</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: white;
            padding: 5px;
            text-align: center;
            position: fixed;
            top: 0;
            width: 100%;
            height: 60px;
            display: flex;
            justify-content: space-between;
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
        .game-container {
            display: flex;
            flex-wrap: wrap;
        }

        .game {
            width: 15%;
            margin: 30px;
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }

        .game img {
            width: 100%; /* Chiều rộng của ảnh chiếm 100% của ô game */
            height: 300px; /* Đặt chiều cao tuyệt đối cho ảnh (thay đổi theo ý muốn của bạn) */
            object-fit: cover; /* Duy trì tỷ lệ khung hình và cắt hoặc kéo dãn ảnh để lấp đầy khung hình */
        }

    </style>
</head>
<body>

<header>
    <!-- Your logo/image goes here -->
    <a href="/home"> <img  src="https://upload.wikimedia.org/wikipedia/commons/0/0d/Nintendo.svg" alt="Your Logo" height="50"></a>

    <form method="get">
        <input type="text" id="searchGame" name="searchGame">
        <input type="submit" value="Tìm kiếm">
    </form>
    <div>
        <%
            HttpSession sessions = request.getSession(false); // Thêm tham số false để không tạo mới session nếu nó không tồn tại
            String username = (sessions != null) ? (String) sessions.getAttribute("username") : null;
        %>

        <%if (username != null) {%>
        <span>Welcome, <%= username %>!</span>
        <%} else {%>
        <span>Welcome, Guest!</span>
        <%}%>

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
    <div class="game-container">
        <% List<Game> games = (List<Game>) request.getAttribute("games"); %>

        <% for (Game game : games) { %>
        <div class="game" >
            <img src="<%= game.getUrlCover() %>" alt="<%= game.getTitle() %>">
            <p><a href="/gameinfor?id=<%= game.getId() %>"><strong><%= game.getTitle() %></strong></a></p>
            <p>Price: <%= game.getPrice() %>VNĐ</p>
            <p>Rating: <%= game.getRating() %></p>
        </div>
        <% } %>
    </div>
</main>
<footer>
    <p>Home</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
