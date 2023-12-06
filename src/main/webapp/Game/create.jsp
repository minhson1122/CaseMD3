<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Game Magement Application</title>
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
                <h2>Add New Game</h2>
            </caption>
            <tr>
                <th>Game Title:</th>
                <td>
                    <input type="text" name="title" id="title" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Game price:</th>
                <td>
                    <input type="text" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Game Description:</th>
                <td>
                    <input type="text" name="description" id="description" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Game Genre</th>
                <td>
                    <input type="text" , name="genre",id ="genre" size="15">
                </td>
            </tr>
            <tr>
                <th>Game Rating</th>
                <td>
                    <input type="text" , name="rating", id="rating" size="15">
                </td>
            </tr>
            <tr>
                <th>Developer</th>
                <td>
                    <input type="text", name="developer", size="15">
                </td>
            </tr>
            <tr>
                <th>releaseDate</th>
                <td>
                    <input type="date", name="releasedate", size="15">
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
