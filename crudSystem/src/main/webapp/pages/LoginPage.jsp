<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>
<form action="loginServlet" method="post" id="form1">
    <table>
        <th>Login Here:</th>
        <tr>
            <td><label for="id">Id</label></td>
            <td><input type="text" name="id" id="id"></td>
        </tr>
        <tr>
            <td><label for="password">Password</label></td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td><button type="submit">Login</button></td>
        </tr>
    </table>
</form>
</body>
</html>
