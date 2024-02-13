<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
      <link rel="stylesheet" href="resources/css/bootstrap.min.css">
      <link rel="stylesheet" href="resources/css/custom.css">
</head>
<body>
    <h1>Add new Product</h1>
    <form:form action="addProduct" method="post" >

            <div class="container mt-5">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <div class="form-group">
                            <h3>Add Product</h3>
                        </div>
                        <div class="form-group">
                            <label for="name">product name</label>
                            <form:input type="text" cssClass="form-control" path=""   placeholder="Enter product name"/>
                        </div>
                        <div class="form-group">
                            <label for="expirationDate">Expiration Date</label>
                            <form:input type="text" cssClass="form-control" path=""   placeholder="dd/mm/yyyy"/>
                        </div>
                        <div class="form-group">
                            <label for="manufacturer">Manufacturer</label>
                            <form:input type="text" cssClass="form-control" path=""  placeholder="Manufacturer"/>
                        </div>
                        <div class="form-group">
                            <label for="price">Price</label>
                            <form:input type="text" cssClass="form-control" path=""   placeholder="Price"/>
                        </div>
                        <div class="form-group">
                            <label for="available">Availability</label>
                            <form:input type="text" cssClass="form-control" path="" placeholder="0 or 1"/>
                        </div>
                        <input type="submit" class="btn btn-primary"/>
                    </div>
                </div>
            </div>
        </form:form>
</body>

</html>