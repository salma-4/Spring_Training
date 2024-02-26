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
            padding: 20px;
            margin-left:15px;
        }

        .searchDiv input[type="text"],
        .searchDiv input[type="number"] {
            width: calc(50% - 15px); /* Adjust as needed */
            padding: 8px;
            margin-right: 15px;
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

<h1>Employees Data</h1>
<br>
<div class="row searchDiv">
    <div class="col-md-6">
        <form action="searchEmployeeName" method="get">
            <div class="form-group">
                <label>Search by Name:</label>
                <input type="text" class="form-control" name="searchKey" placeholder="Enter Employee Name"/>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
    <div class="col-md-6">
        <form action="searchEmployeeId" method="get">
            <div class="form-group">
                <label>Search by Id:</label>
                <input type="number" class="form-control" name="id" placeholder="Enter Employee id"/>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
</div>

<div class="tbl-div">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">E-mail</th>
            <th scope="col">Show Details</th>
            <th scope="col">Update</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>
                    <c:url var="detailsLink" value="/showDetails">
                        <c:param name="employeeId" value="${employee.id}" />
                    </c:url>
                    <a class="btn btn-primary" href="<c:out value=" ${detailsLink}" />">View Details</a>
                </td>
                <td>
                    <!-- construct an "update" link with product id -->
                    <c:url var="updateLink" value="/updateEmployee">
                        <c:param name="employeeId" value="${employee.id}" />
                    </c:url>
                    <a class="btn btn-warning" href="<c:out value="${updateLink}" />">Update</a>
                </td>
                <td>
                    <!-- construct a "delete" link with product id -->
                    <c:url var="deleteLink" value="/deleteEmployee">
                        <c:param name="employeeId" value="${employee.id}" />
                    </c:url>
                    <a class="btn btn-danger" href="<c:out value="${deleteLink}" />">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form:form action="addEmployee" method="get">
        <input type="submit" class="btn btn-success" value="Add New Employee" />
    </form:form>
</div>
</body>
</html>
