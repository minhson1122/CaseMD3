<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/5/2023
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container{
            position: fixed;
            width: 100%;
            height: 400px;
        }

        header {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
            position: fixed;
            top: 0;
            width: 100%;
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

        .sidebar {
            width: 20%;
            background-color: #f1f1f1;
            padding: 10px;
        }

        .content {
            width: 70%;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .product {
            width: 30%;
            margin: 10px;
            padding: 15px;
            border: 1px solid #ccc;
            text-align: center;
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
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>eCommerce Product Detail</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
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
    <p><c:out value="${game.getTitle()}"/></p>
    <p><c:out value="${game.getPrice()}"/></p>
    <p><c:out value="${game.getDescription()}"/></p>
    <p><c:out value="${game.getGenre()}"/></p>
    <p><c:out value="${game.getRating()}"/></p>
    <p><c:out value="${game.getTotalDownload()}"/></p>
    <p><c:out value="${game.getDeveloper()}"/></p>
    <p><c:out value="${game.getReleaseDate()}"/></p>
<%--    <p><c:out value="${game.isActive()}"/></p>--%>
<%--    <p><c:out value="${game.getUrlCover()}"/></p>--%>
    <%--    <img src="${game.getUrlWallpaper()}" alt="${game.getTitle()}")}/>--%>

    <form action="/addToCart" method="post">
        <input type="hidden" name="gameId" value="${game.getId()}">
        <input type="submit" value="Thêm vào giỏ hàng">
    </form>

</main>


<%--    <div class="container">--%>
<%--        <div class="card">--%>
<%--            <div class="container-fliud">--%>
<%--                <div class="wrapper row">--%>
<%--                    <div class="preview col-md-6">--%>
<%--                        <div class="preview-pic tab-content">--%>



<%--                            <div class="tab-pane active" id="pic-1"><img src="http://placekitten.com/400/252" /></div>--%>

<%--                        </div>--%>

<%--                    </div>--%>
<%--                    <div class="details col-md-6">--%>
<%--                        <h3 class="product-title">TEN GAME</h3>--%>
<%--                        <div class="rating">--%>
<%--                            <div class="stars">--%>
<%--                                <span class="fa fa-star checked"></span>--%>
<%--                                <span class="fa fa-star checked"></span>--%>
<%--                                <span class="fa fa-star checked"></span>--%>
<%--                                <span class="fa fa-star"></span>--%>
<%--                                <span class="fa fa-star"></span>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <p class="product-description">MO TA</p>--%>
<%--                        <h4 class="price">current price: <span>$180</span></h4>--%>
<%--                        <div>--%>
<%--                            <p><c:out value="${game.getTitle()}"/></p>--%>
<%--                            <p><c:out value="${game.getPrice()}"/></p>--%>
<%--                            <p><c:out value="${game.getDescription()}"/></p>--%>
<%--                            <p><c:out value="${game.getGenre()}"/></p>--%>
<%--                            <p><c:out value="${game.getRating()}"/></p>--%>
<%--                            <p><c:out value="${game.getTotalDownload()}"/></p>--%>
<%--                            <p><c:out value="${game.getDeveloper()}"/></p>--%>
<%--                            <p><c:out value="${game.getReleaseDate()}"/></p>--%>
<%--                            <p><c:out value="${game.isActive()}"/></p>--%>
<%--                            <p><c:out value="${game.getUrlCover()}"/></p>--%>
<%--                            &lt;%&ndash;    <img src="${game.getUrlWallpaper()}" alt="${game.getTitle()}")}/>&ndash;%&gt;--%>

                            <form action="/addToCart" method="post">
                                <input type="hidden" name="gameId" value="${game.getId()}">
                                <input type="submit" value="Thêm vào giỏ hàng">
                            </form>

                        </div>

                        <div class="action">
                            <form action="cart" method = post>
                                <button type="submit">Thêm vào giỏ hàng</button>
                            </form>
                        </div>
                    </div>
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
