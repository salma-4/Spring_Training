<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>


    <!-- Reference Bootstrap files -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<h1>hello</h1>
<p>
    User : <security:authentication property="principal.username"/>
</p>
<p>
  Role :   <security:authentication property="principal.authorities"/>
</p>
<security:authorize  access="hasAnyRole('ADMIN')">
<p>
    <a href="${pageContext.request.contextPath}/systems" class="btn btn-info">System Page</a>
</p>
<p>this part is hidden from anyone except with role *ADMIN*</p>
</security:authorize>
<form:form method="post" action="${pageContext.request.contextPath}/logout">
    <input type="submit" value="logout" class="btn btn-danger"/>
</form:form>
</body>

</html>
