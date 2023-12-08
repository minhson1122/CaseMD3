<%--
  Created by IntelliJ IDEA.
  User: Le Trinh
  Date: 12/6/2023
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <title>Game Magement Application</title>
</head>
<div class="container">
    <div class="col-12 col-md-12">
        <div class="card">
            <div class="card-header">
                Add New Game
            </div>
            <c:if test='${requestScope["message"] != null}'>
                <span class="alert-danger error-message">${requestScope["message"]}</span>
            </c:if>
            <div class="card-body">
                <form method="post">
                    <div class="mb-3">
                        <label for="name" class="form-label">Game title</label>
                        <input type="text" name="title" class="form-control" id="name" >
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label">Game price</label>
                        <input type="text" name="price" class="form-control" id="email" >
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Description</label>
                        <input type="text" name="description" class="form-control" id="address" >
                    </div>
                    <div class="mb-3">
                        <label for="genre" class="form-label">Genre</label>
                        <input type="text" name="genre" class="form-control" id="genre" >
                    </div>
                    <div class="mb-3">
                        <label for="rating" class="form-label">Rating</label>
                        <input type="text" name="rating" class="form-control" id="rating" >
                    </div>
                        <div class="mb-3">
                            <label for="totalDownload" class="form-label">Total Download</label>
                            <input type="text" name="totalDownload" class="form-control" id="totalDownload" >
                        </div>
                        <div class="mb-3">
                            <label for="developer" class="form-label">Developer</label>
                            <input type="text" name="developer" class="form-control" id="developer" >
                        </div>
                        <div class="mb-3">
                            <label for="releasedate" class="form-label">Releasedate</label>
                            <input type="date" name="releasedate" class="form-control" id="releasedate" >
                        </div>
                        <div class="mb-3">
                            <label for="urlcover" class="form-label">Url Cover</label>
                            <input type="text" name="urlcover" class="form-control" id="urlcover" >
                        </div>
                        <div class="mb-3">
                            <label for="urlwallpaper" class="form-label">Url Wallpaper</label>
                            <input type="text" name="urlwallpaper" class="form-control" id="urlwallpaper" >
                        </div>

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
