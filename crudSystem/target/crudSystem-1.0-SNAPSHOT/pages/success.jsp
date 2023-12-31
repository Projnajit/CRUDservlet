<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success Page</title>
</head>

<style>
    #name{
        color:red;
    }
    #project{
        color: green;
        font-weight: bold;
    }
    #profile-image {
        border-radius: 10%;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        width: 400px;
        height: 250px;
        margin-top: 20px;
    }

    .container{
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
        justify-content: center;
        align-items: center;
    }
    .container-2
    {
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
<body>


<%
    String imageFile=(String)request.getAttribute("imageFile");
%>
<div class="container">
    <h1>Congratulations, <span id="name">${name}</span>!!</h1>
    <img id="profile-image" src="images/<%=imageFile%>" alt="">
    <h3>Email: ${email}</h3>
    <p>Happy to assigned you to the <span id="project">${projectType}</span> project.</p>
</div>

<br>
<div class="container-2">
    <jsp:include page="LoginPage.jsp"/>
</div>
</body>
</html>