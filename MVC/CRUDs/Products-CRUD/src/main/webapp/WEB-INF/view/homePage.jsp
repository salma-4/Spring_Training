<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%-- Import Bootstrap --%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

    <style>
        /* Add your custom styles here */
 body {
            font-family: Arial, sans-serif;

        }

        h1 {
            color: #343a40;
            text-align: center;
            margin-top: 20px;
        }

        .searchDiv {
           padding:20px;


        }

        .searchDiv input[type="text"] {
                 width: 300px;
                 padding: 8px;
                 margin:4px;
                 border-radius: 5px;
                 border: 1px solid #ced4da;
             }

        .tbl-div {
            margin: 0 auto;
            width: 80%;
        }

        .table {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .table th, .table td {
            vertical-align: middle !important;
        }

        .btn {
            padding: 8px 16px;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn-primary {
            background-color: #007bff;
            border: none;
            color: #fff;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .btn-warning {
            background-color: #ffc107;
            border: none;
            color: #212529;
        }

        .btn-warning:hover {
            background-color: #e0a800;
        }

        .btn-danger {
            background-color: #dc3545;
            border: none;
            color: #fff;
        }

        .btn-danger:hover {
            background-color: #bd2130;
        }

        .btn-success {
            background-color: #28a745;
            border: none;
            color: #fff;
        }

        .btn-success:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<h1>Products Data</h1>
<div class="searchDiv">
    <form action="searchProduct" method="get">
        Search Product<input type="text" class="form-control" name="searchKey" placeholder="Enter product name"/>
        <input type="submit" value="Search" class="btn btn-primary">
    </form>
</div>
<div class="tbl-div">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Show Details</th>
            <th scope="col">Add/Update</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productsList}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>
                    <!-- construct a "view details" link with product id -->
                    <c:url var="detailsLink" value="/showDetails">
                        <c:param name="productId" value="${item.id}" />
                    </c:url>
                    <a class="btn btn-primary" href="<c:out value="${detailsLink}" />">View Details</a>
                </td>
                <td>
                    <!-- construct an "update" link with product id -->
                    <c:url var="updateLink" value="/updateProduct">
                        <c:param name="productId" value="${item.id}" />
                    </c:url>
                    <a class="btn btn-warning" href="<c:out value="${updateLink}" />">Add/Update</a>
                </td>
                <td>
                    <!-- construct a "delete" link with product id -->
                    <c:url var="deleteLink" value="/deleteProduct">
                        <c:param name="productId" value="${item.id}" />
                    </c:url>
                    <a class="btn btn-danger" href="<c:out value="${deleteLink}" />">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form:form action="addProduct" method="get">
        <input type="submit" class="btn btn-success" value="Add New Product"/>
    </form:form>
</div>
</body>
</html>
