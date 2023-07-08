<%-- 
    Document   : placeOrderSuccess
    Created on : Jul 6, 2023, 10:13:17 PM
    Author     : LENOVO
--%>
<%@page import="ihnamtech.dto.ProductDTO"%>
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
        <title>Checkout Success Page</title>
    </head>
    <body>
        <button type="submit"><a href="./shopping.jsp">Buy more</a></button>
        <h1>Your order is success</h1>

        <%
            String firstName = (String) request.getAttribute("FIRSTNAME");
            String lastName = (String) request.getAttribute("LASTNAME");
            String phone = (String) request.getAttribute("PHONE");
            String address = (String) request.getAttribute("ADDRESS");
            Cart cart = (Cart) request.getAttribute("CART");

            if (firstName == null || lastName == null || phone == null || address == null || cart == null || cart.getCart() == null) {
                response.sendRedirect("shopping.jsp");
            }

        %>

        <p>Thank you for using our service</p>

        <p>
            First Name: <%=firstName%>
        </p>
        <p>
            Last Name: <%=lastName%>
        </p>
        <p>
            Phone: <%=phone%>
        </p>
        <p>
            Address: <%=address%>
        </p>


        <c:if test="${not empty requestScope.CART}">


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
                    <c:forEach var="product" items="${requestScope.CART.getCart().values()}" varStatus="loop">
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
                                <input type="number" name="quantity" value="${product.quantity}" required="" min="1"/>
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
    <h1>Total: ${pageScope.total}$</h1>

</body>
</html>
