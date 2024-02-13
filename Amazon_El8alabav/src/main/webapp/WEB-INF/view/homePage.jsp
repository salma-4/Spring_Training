<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/custom.css">
</head>
<body>
    <div class="container">

        <h1>Products</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Expiration Date</th>
                    <th>Details</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.expirationDate}</td>
                        <td><a href="/product/${product.id}">View Details</a></td>
                        <td class="actions">
                            <a href="/product/${product.id}/edit">Edit</a>
                            <a href="/product/${product.id}/delete">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
 <form:form action="addProduct">
        <input type="submit" class="btn btn-success" value="Add new Product"/>
    </form:form>
    </div>
</body>
</html>
