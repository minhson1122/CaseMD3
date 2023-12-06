<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/admin/listgamedata">List All Games</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Game
                </h2>
            </caption>
<%--            <c:if test="${game != null}">--%>
<%--                <input type="hidden" name="id" value="<c:out value='${game.id}' />"/>--%>
<%--            </c:if>--%>
            <tr>
                <th>Game title:</th>
                <td>
                    <input type="text" name="title" size="45"
                           value="<c:out value='${game.title}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Game price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${game.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>description:</th>
                <td>
                    <input type="text" name="description" size="15"
                           value="<c:out value='${game.description}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>genre:</th>
                <td>
                    <input type="text" name="genre" size="15"
                           value="<c:out value='${game.genre}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>rating:</th>
                <td>
                    <input type="text" name="rating" size="15"
                           value="<c:out value='${game.rating}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>totaldownload:</th>
                <td>
                    <input type="text" name="totaldownload" size="15"
                           value="<c:out value='${game.totaldownload}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>developer:</th>
                <td>
                    <input type="text" name="developer" size="15"
                           value="<c:out value='${game.developer}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>relaeseDate:</th>
                <td>
                    <input type="date" name="releaseDate" size="15"
                           value="<c:out value='${game.releasedate}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>purchased:</th>
                <td>
                    <input type="text" name="purchased" size="15"
                           value="<c:out value='${game.Purchased}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
