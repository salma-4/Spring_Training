<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>


</head>
<body>

<h1>hello</h1>
<p>
    User : <security:authentication property="principal.username"/>
</p>
<p>
  Role :   <security:authentication property="principal.authorities"/>
</p>
<p>
    <a href="${pageContext.request.contextPath}/system" class="btn btn-info">System Page</a>

</p>
<form:form method="post" action="${pageContext.request.contextPath}/logout">
    <input type="submit" value="logout"/>
</form:form>
</body>

</html>
