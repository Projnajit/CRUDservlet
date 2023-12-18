<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/17/2023
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update & Delete</title>
    <style>
        form {
            display: flex;
            justify-content: center; /* Adjust as needed */
            align-items: center;
            font-size: 18px;
            width: 100%; /* Adjust the width as needed */
            /*max-width: 1200px; !* Set a maximum width if necessary *!*/
            padding: 20px; /* Add some padding for better readability */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Optional: Add a box shadow for a visual effect */
        }

        #name{
            color: red;
        }

    </style>
</head>
<body>
<h1>Hello, <span id="name">${retrivedName}</span>!!</h1>
<form action="updateProfile" method="post">
    <table>
        <th>Update Your Profile:</th>
        <tr>
            <td><label>Name </label></td>
            <td><input type="text" name="name" value="${retrivedName}"/></td>
        </tr>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" value="${retrivedId}" readonly/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${retrivedEmail}"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" value="${retrivedPassword}"/></td>
        </tr>
        <tr>
            <td>Designation</td>
            <td><input type="text" name="designation" value="${retrivedDesignation}"/></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td><input type="text" name="gender" value="${retrivedGender}"/></td>
        </tr>
        <tr>
            <td>Project Type</td>
            <td><input type="text" name="projectType" value="${retrivedProjectType}" readonly/></td>
        </tr>
        <tr>
            <td><button type="submit">Update Profile</button></td>
        </tr>
    </table>
</form>

<form action="deleteProfile" method="post">
    <input type="hidden" name="id" value="${retrivedId}"/>
    <button type="submit">Delete Profile</button>
</form>

</body>
</html>
