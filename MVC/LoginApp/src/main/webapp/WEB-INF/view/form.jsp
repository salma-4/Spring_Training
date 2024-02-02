<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">

    <style>
        body {
            background-color: #f8f9fa; /* Bootstrap default background color */
        }

        .container {
            margin-top: 50px; /* Adjust as needed */
        }

        form {
            max-width: 400px; /* Adjust as needed */
            margin: 0 auto;
            background-color: #fff; /* Form background color */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Form box shadow */
        }

        .form-group {
            margin-bottom: 20px; /* Adjust as needed */
        }

        .btn {
            margin-top: 10px; /* Adjust as needed */
        }
    </style>
</head>
<body>
    <div class="container">
        <form:form action="formProcessing" modelAttribute="user">
            <div class="form-group">
                <form:input type="text" class="form-control" placeholder="Enter your name" path="userName" />
                <br>
                <form:errors path="userName"/>
            </div>
            <div class="form-group">
                <form:input type="password" class="form-control" placeholder="************" path="password"/>
                <br>
                                <form:errors path="password"/>

            </div>
            <div class="form-group">
                <form:input type="text" class="form-control" placeholder="Salary" path="salary"/>
                     <br>
                                                <form:errors path="salary"/>
            </div>
            <div class="form-group">
                <form:input type="email" class="form-control" placeholder="name899@gmail.com" path=""/>
                     <br>
                                                <form:errors path="email"/>
            </div>
            <div class="form-group">
                <form:select class="form-control" path="country">
                    <form:option value="Egypt" label="Egy"/>
                    <form:option value="Brazil" label="Brazil"/>
                    <form:option value="Saudia Arabia" label="KSA"/>
                         <br>
                           <form:errors path="country"/>
                </form:select>
            </div>
            <div class="form-group">
                <form:radiobutton path="prefProgramming" value="JAVA"/> JAVA
                <form:radiobutton path="prefProgramming" value="C#"/> C#
                <form:radiobutton path="prefProgramming" value="PHP"/> PHP
                <form:radiobutton path="prefProgramming" value="Ruby"/> Ruby
                     <br>
                  <form:errors path="prefProgramming"/>
            </div>
            <div class="form-group">
                <form:checkbox path="operatingSystem" value="MAC"/> MAC
                <form:checkbox path="operatingSystem" value="Windows"/> Windows
                <form:checkbox path="operatingSystem" value="Linux"/> Linux
                     <br>
                 <form:errors path="operatingSystem"/>
            </div>
            <input type="submit" class="btn btn-danger">
        </form:form>
    </div>
</body>
</html>
