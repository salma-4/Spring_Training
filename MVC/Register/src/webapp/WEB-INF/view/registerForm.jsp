<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    </head>
  <body>
  <form:form action ="formProcessing" modelAttribute="userModel">
  <div class="container mt-5">
  <div class="row justify-content-center">
  <div class="col-md-6">
  <div class="form-group">
  <h3>Employee Registeration Form</h3>
</div>
<div class="form-group">
<label for="userName">Username</label>
<form:input type="text" cssClass="form-Control" path="userName" placeholder="Enter your name"/>
<form:errors path="userName" cssClass=""/>
</div>
<div class="form-group">
<label for="email">Email</label>
<form:input type="text" cssClass="form-Control" path="email" placeholder="Enter your email"/>
<form:errors path="email" cssClass=""/>
</div>
<div class="form-group">
<label for="password">Password</label>
<form:input type="text" cssClass="form-Control" path="password" placeholder="Enter your password"/>
<form:errors path="password" cssClass=""/>
</div>
<div class="form-group">
<label for="confirmPassword">Username</label>
<form:input type="text" cssClass="form-Control" path="confirmPassword" placeholder="Confirm your password"/>
<form:errors path="confirmPassword" cssClass=""/>
<div class="form-group">

<form:input type="submit" />
</div>
 </div>
  </div>
  </div>


  <form:form>
 </body>
 </html>
