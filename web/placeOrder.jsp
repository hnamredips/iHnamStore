<%-- 
    Document   : placeOrder
    Created on : Jul 6, 2023, 9:57:39 PM
    Author     : LENOVO
--%>
<%@page import="ihnamtech.utils.Cart"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Import fmt-->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your cart: </h1>

        <c:if test="${sessionScope.CART == null}">
            <c:redirect url="viewCart.jsp"/>
        </c:if>
        <c:if test="${not empty sessionScope.CART}">

            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Category</th>
                        <th>Description</th>
                        <th>Quantity</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="product" items="${sessionScope.CART.getCart().values()}" varStatus="loop">
                        <c:set var="total" value="${total + (product.quantity * product.price)}" scope="page"/>
                    <form action="MainController" method="POST">
                        <tr>
                            <td>${loop.count}</td>
                            <td>
                                <input type="text" name="productName" value="${product.productName}" readonly=""/>
                                <input type="hidden" name="productID" value="${product.productID}" readonly=""/>
                            </td>
                            <td>
                                <input type="hidden" name="price" value="${product.price}"/>
                                <span>${product.price}$</span>
                            </td>
                            <td>
                                <input type="text" name="categoryID" value="${product.category.categoryID}" readonly=""/>
                            </td>
                            <td>
                                <input type="text" name="description" value="${product.description}" readonly=""/>
                            </td>
                            <td>
                                <input type="number" name="quantity" value="${product.quantity}" readonly="" min="1"/>
                            </td>
                            <fmt:formatNumber
                                value="${product.getQuantity() * product.getPrice()}"
                                pattern="#0.00"
                                var="formattedTotal"
                                />
                            <td>$${pageScope.formattedTotal}</td>

                        </tr>
                    </form> 
                </c:forEach>    
            </tbody>
        </table>
    </c:if>

    <fmt:formatNumber
        value="${total}"
        pattern="#0.00"
        var="formattedTotal"
        />
    <h1>Total: $${pageScope.formattedTotal}</h1>


    <!--    <a href="shopping.html">Add more</a>-->

    <form action="MainController" method="POST">
        First Name: <input type="text" placeholder="FullName" name="firstName" required=""/></br>
        Last Name: <input type="text" placeholder="FullName" name="lastName" required=""/></br>
        Phone: <input type="tel" placeholder="Phone Number" name="phone" required=""/></br>
        Address: <input type="text" placeholder="Address" name="address" required=""/></br>
        <input type="submit" name="action" value="Checkout"/>
    </form>
</body>
</html>
