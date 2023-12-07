<%--
  Created by IntelliJ IDEA.
  User: Le Trinh
  Date: 12/6/2023
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <title>User Management Application</title>
</head>
<body>
<div class="container">
    <div class="col-12 col-md-12">
        <div class="card">
            <div class="card-header">
                Update Game
            </div>
            <div>
                <c:out value="${message}"></c:out>
            </div>
            <div class="card-body">
                <form method="post">
                    <%--                    <div class="mb-3">--%>
                    <%--                        <label for="exampleInputEmail1" class="form-label">Id</label>--%>
                    <%--                        <input type="text" name="id" value="<c:out value="${user.getId()}"/>" class="form-control" id="id" aria-describedby="emailHelp">--%>
                    <%--                    </div>--%>
                        <div class="mb-3">
                            <label class="form-label">Game Id</label>
                            <input type="text" name="id" disabled value="<c:out value="${id}"/>" class="form-control" id="id">
                        </div>
                        <div class="mb-3">
                        <label class="form-label">Game title</label>
                        <input type="text" name="title" value="<c:out value="${gameN.getTitle()}"/>" class="form-control" id="title">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Game price</label>
                        <input type="number" name="price" class="form-control" value="<c:out value="${gameN.getPrice()}"/>" id="price">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Description </label>
                        <input type="text" name="description" value="<c:out value="${gameN.getDescription()}"/>" class="form-control" id="description">
                    </div>
                    <div class="mb-3">
                        <label  class="form-label">Genre</label>
                        <input type="text" name="genre" value="<c:out value="${gameN.getGenre()}"/>" class="form-control" id="genre">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Rating</label>
                        <input type="text" name="rating" value="<c:out value="${gameN.getRating()}"/>" class="form-control" id="rating">
                    </div>

                        <div class="mb-3">
                            <label class="form-label">Total Download</label>
                            <input type="text" name="totaldownload" value="<c:out value="${gameN.getTotalDownload()}"/>" class="form-control" id="totalDownload">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Developer</label>
                            <input type="text" name="developer" value="<c:out value="${gameN.getDeveloper()}"/>" class="form-control" id="developer">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Releasedate</label>
                            <input type="date" name="releasedate" value="<c:out value="${gameN.getReleaseDate()}"/>" class="form-control" id="releasedate">
                        </div>

<%--                    <div class="mb-3">--%>
<%--                        <label class="form-label">Purchased</label>--%>
<%--                        <select name="purchased" id="purchased">--%>
<%--                            <option <c:if test="${user.getRole() == 'true'}"> selected </c:if> value="true">True</option>--%>
<%--                            <option <c:if test="${user.getRole() == 'fail'}"> selected </c:if>  value="fail">Fail</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <a href="/admin/listgamedata" class="btn btn-info">Cancel</a>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
