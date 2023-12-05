<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/4/2023
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    <title>Trang đăng nhập</title>

    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            width: 500px;
            padding: 16px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .error-message {
            color: red;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h4 class="text-center">Đăng nhập</h4>

    <%-- Kiểm tra xem có thông báo lỗi không --%>
    <p class="alert-danger error-message" role="alert">
        <c:if test='${error != ""}'>
            ${requestScope["error"]}
        </c:if>
    </p>

    <form method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Username:</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div>
            <label for="role">Role:</label>
            <select id="role" name="role">
                <option value="user">User</option>
                <option value="admin">Admin</option>
            </select><br>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">Login</button>
        </div>
    </form>

    <div class="text-center">
        <p class="text-center mt-3">Chưa có tài khoản? <a href="/account/register">Đăng ký ngay</a>.</p>
        <button type="button" class="btn btn-primary" onclick="goToHome()">Quay về trang chủ</button>
    </div>
</div>

<script>
    // Kiểm tra xem trang có được load lại không
    if (performance.navigation.type === 1) {
        // Nếu trang được reload, ẩn cụm message đăng ký thành công
        document.querySelector('.error-message').style.display = 'none';
    }

    function goToHome() {
        // Chuyển hướng về trang home.jsp
        window.location.href = "http://localhost:8080/home";
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
