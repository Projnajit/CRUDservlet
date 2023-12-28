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
</style>
<body>


<%
    String imageFile=(String)request.getAttribute("imageFile");
%>

<h1>Congratulations, <span id="name">${name}</span>!!</h1>
<img id="profile-image" src="images/<%=imageFile%>" alt="">
<h3>Email: ${email}</h3>
<p>Happy to assigned you to the <span id="project">${projectType}</span> project.</p>
<jsp:include page="LoginPage.jsp"/>
</body>
</html>