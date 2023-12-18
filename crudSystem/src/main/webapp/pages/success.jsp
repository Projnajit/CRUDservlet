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
</style>
<body>
<h1>Congratulations, <span id="name">${param.name}</span>!!</h1>
<h3>Email: ${param.email}</h3>
<p>Happy to assigned you to the <span id="project">${param.projectType}</span> project.</p>

<jsp:include page="LoginPage.jsp"/>
</body>
</html>
