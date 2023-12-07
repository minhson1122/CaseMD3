<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/5/2023
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin tài khoản của bạn</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

    </head>
    <div class="container">
        <div class="col-12 col-md-12">
            <div class="card">
                <div class="card-header">
                    <h3 style="text-align: center">Thông tin tài khoản</h3>
                </div>
                <div>
                    <c:out value="${message}"></c:out>
                </div>
                <div class="card-body">
                    <form method="post">
                        <%--                    <div class="mb-3">--%>
                        <%--                        <label for="exampleInputEmail1" class="form-label">Id</label>--%>
                        <%--                        <input type="text" name="id" class="form-control" id="id" aria-describedby="name">--%>
                        <%--                    </div>--%>
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
                        <%--                        <div class="mb-3">--%>
                        <%--                            <label class="form-label">Purchased</label>--%>
                        <%--                            <select name="purchased" id="purchased">--%>
                        <%--                                <option <c:if test="${user.getRole() == 'true'}"> selected </c:if> value="true">True</option>--%>
                        <%--                                <option <c:if test="${user.getRole() == 'fail'}"> selected </c:if>  value="fail">Fail</option>--%>
                        <%--                            </select>--%>
                        <%--                        </div>--%>

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
