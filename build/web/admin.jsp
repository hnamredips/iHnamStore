<%-- 
    Document   : admin
    Created on : Jun 27, 2023, 8:51:05 PM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <a href="index.jsp">iHnamTech</a>
        <h1>Admin Management</h1>

        <form action="MainController" >
            <input type="text" name="search" value="${param.search}"/>
            <input type="hidden" name="role" value="AD"/>
            <button type="submit" name="action" value="Product">Search</button>
            <input type="submit" name="action" value="Logout"/>

        </form>
        <c:if test="${not empty requestScope.PRODUCT_LIST}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Quantity</th>
                        <th>Image</th>
                        <th>Update</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${requestScope.PRODUCT_LIST}" varStatus="loop">
                    <form action="MainController" method="POST">
                        <tr>
                            <td><input type="text" name="productID" value="${product.productID}" readonly=""/></td>
                            <td>
                                <input type="text" name="productName" value="${product.productName}" required=""/>

                            </td>
                            <td>
                                <input type="hidden" name="price" value="${product.price}" required=""/>
                                <span>${product.price}$</span>
                            </td>

                            <td>
                                <input type="text" name="description" value="${product.description}" readonly=""/>
                            </td>
                            <td>
                                <input type="text" name="quantity" value="${product.quantity}" required=""/> 
                            </td>
                            <td>
                                <input type="hidden" name="image" value="${product.imageURL}" readonly=""/> 
                                <img src="${product.imageURL}" alt="hnamredips" style="
                                             height: 180px;"/>
                            </td>
                            <td>
                                <input type="submit" name="action" value="Update"/>
                            </td>
                            <td><input type="submit" name="action" value="Delete"/></td>

                        </tr>
                    </form>
                </c:forEach>

            </tbody>
        </table>

    </c:if> 
    
    ${requestScope.MESSAGE}
</body>
</html>
