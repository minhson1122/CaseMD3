<%--
  Created by IntelliJ IDEA.
  User: Le Trinh
  Date: 12/4/2023
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <title>Danh Sach</title>
</head>
<body>


<div class="container">
    <div class="col-12 col-md-12">
        <div class="card">
            <div class="card-header">
                <div class="row">
                    <div class="col-md-6 title-text">
                        <h1>Danh Sach Game</h1>
                        <a href="/admin?action=create" class="btn btn-success">Add new</a>
                    </div>
                    <div class="col-md-6">
                        <form action="/listgamedata" method="get">
                            <input type="text" name="keyword" value="<c:out value="${keyword}"/>">
                            <button type="submit">Search</button>
                        </form>
                    </div>
                </div>


            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Title</th>
                        <th scope="col">Price</th>
                        <th scope="col">Description</th>
                        <th scope="col">Genre</th>
                        <th scope="col">Rating</th>
                        <th scope="col">TotalDownload</th>
                        <th scope="col">Developer</th>
                        <th scope="col">ReleaseDate</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${games}" var="game">
                        <tr>
                            <td><c:out value="${game.getId()}"/></td>
                            <td><c:out value="${game.getTitle()}"/></td>
                            <td><c:out value="${game.getPrice()}"/></td>
                            <td><c:out value="${game.getDescription()}"/></td>
                            <td><c:out value="${game.getGenre()}"/></td>
                            <td><c:out value="${game.getRating()}"/></td>
                            <td><c:out value="${game.getTotalDownload()}"/></td>
                            <td><c:out value="${game.getDeveloper()}"/></td>
                            <td><c:out value="${game.getReleaseDate()}"/></td>

                                <%--                            <td>--%>
                                <%--                                <a onclick="return confirm('Are you sure?')" href="${pageContext.request.contextPath}/admin?action=delete&id=<c:out value="${user.getId()}"/>" class="btn btn-danger">Delete</a>--%>
                                <%--                                <a href="${pageContext.request.contextPath}/users?action=update&id=<c:out value="${user.getId()}"/>" class="btn btn-primary">Update</a>--%>
                                <%--                            </td>--%>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
