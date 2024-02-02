<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">

        <%--        import Bootstrap--%>
  <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">

</head>
<body>
<h1>User information </h1>
<h3>username is : ${userModel.userName} </h3>
    <h3>password is : ${userModel.password} </h3>
    <h3>salary is : ${userModel.salary} </h3>
    <h3>country is : ${userModel.country} </h3>
    <h3>prog lang is : ${userModel.prefProgramming} </h3>
    <h3>operating system is : ${userModel.operatingSystem} </h3>

</body>
</html>