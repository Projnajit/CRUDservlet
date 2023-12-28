<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Project Assigning Form</title>
    <style>

        body{
            height: 100vh;
        }
        div {
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 18px;
            width: 100%;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Optional: Add a box shadow for a visual effect */
        }

        form {
            width: 30%; /* Adjust the width of each form */
        }
    </style>
</head>


<body>
<div>
    <form action="projectAssignmentForm" method="post" enctype="multipart/form-data">
        <table>
            <th id="formHead">Project Registration Form</th>
            <tr>
                <td><label for="name">Employee Name</label></td>
                <td><input type="text" name="name" id="name" placeholder="Enter your name"></td>
            </tr>
            <tr>
                <td><label for="id">Employee ID:</label></td>
                <td><input type="text" id="id" name="id" placeholder="Enter your password"></td>
            </tr>
            <tr>
                <td><label for="password">Password:</label></td>
                <td><input type="password" id="password" name="password" placeholder="Enter your password"></td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td><input type="email" id="email" name="email" placeholder="Enter your email"></td>
            </tr>
            <tr>
                <td><label for="designation">Designation:</label></td>
                <td><input type="text" id="designation" name="designation" placeholder="Enter your position"></td>
            </tr>
            <tr>
                <td><label for="userGender">Gender:</label></td>
                <td><input type="radio" id="userGender" name="gender" value="male">Male &nbsp; &nbsp; <input type="radio" name="gender" value="female">Female</td>
            </tr>
            <tr>
                <td><label for="projectType">Project Type:</label></td>
                <td>
                    <select name="projectType" id="projectType">
                        <option value="Banking">Banking</option>
                        <option value="Education">Education</option>
                        <option value="Security">Security</option>
                        <option value="Hardware">Hardware</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td><label for="image">Upload image:</label></td>
                <td><input type="file" name="image" id="image"></td>
            </tr>

            <tr>
                <td><input type="checkbox" name="agreement" id="agreement"></td>
                <td><label for="agreement"></label> Agree with all terms & conditions.</td>
            </tr>

            <tr>
                <td>
                    <button type="submit" id="submitButton">Submit</button>
                    <button type="reset" id="resetButton">Reset</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<div>
    <jsp:include page="./pages/LoginPage.jsp"/>
</div>
</body>
</html>
