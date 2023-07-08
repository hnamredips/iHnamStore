<%-- 
    Document   : shopping
    Created on : Jul 4, 2023, 11:34:16 PM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link rel="stylesheet" href="./assets/css/style.css" />-->
        <!-- Unicons -->
        <link
            rel="stylesheet"
            href="https://unicons.iconscout.com/release/v4.0.0/css/line.css"
            />
    </head>
    <body>
        <h1>Welcome to iHnamTech!</h1>
        
        <button type="submit"><a href="./index.jsp">Back to home</a></button>
        <form action="MainController" >
            <input type="text" name="search" value="${param.search}"/>
            <button type="submit" name="action" value="Product">Search</button>
        </form>
        <c:if test="${not empty requestScope.PRODUCT_LIST}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Category</th>
                        <th>Description</th>
                        <th>Quantity</th>
                        <th>Image</th>
                        <th>Product Amount</th>
                        <th>Add</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${requestScope.PRODUCT_LIST}" varStatus="loop">
                    <section class="sec">
                        <div class="products">
                            <form action="MainController" method="POST">
                                <tr>
                                    <td><input type="text" name="productID" value="${product.productID}" readonly=""/></td>
                                    <td>
                                        <input type="text" name="productName" value="${product.productName}" readonly=""/>
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
                                        ${product.quantity}
                                    </td>
                                    <td>
                                        <img src="${product.imageURL}" alt="hnamredips" style="
                                             height: 180px;"/>
                                             </td>
                                             <td>
                                             <input type="number" name="quantity" value="1" required="" min="1"/>
                                    </td>

                                    <td><input type="submit" name="action" value="Add"/> </td>

                                </tr>
                            </form>
                        </div>
                    </section>

                </c:forEach>

            </tbody>
        </table>


    </c:if> 

    <c:if
        test="${requestScope.TOTAL_PRODUCT > 9}"
        >
        <div class="pagination">
            <c:if test="${requestScope.page > 1}">
                <c:url
                    var="prevPaging"
                    value="MainController"
                    >
                    <c:param
                        name="action"
                        value="Product"
                        />
                    <c:param
                        name="page"
                        value="${requestScope.page - 1}"
                        />
                    <c:if test="${param.search != null}">
                        <c:param
                            name="search"
                            value="${param.search}"
                            />
                    </c:if>
                </c:url>
                <div class="step">
                    <a
                        class="pagenum pagenum-left"
                        href="${prevPaging}"
                        >
                        <svg
                            class="arrow-left"
                            width="16"
                            height="16"
                            viewBox="0 0 16 16"
                            fill="none"
                            xmlns="http://www.w3.org/2000/svg"
                            >
                        <path
                            d="M6 3L11 8L6 13"
                            stroke="currentColor"
                            stroke-width="1.5"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            />
                        </svg>
                        <p>Previous</p>
                    </a>
                </div>
            </c:if>

            <c:forEach
                var="pageNum"
                begin="1"
                end="${(requestScope.TOTAL_PRODUCT - 1) / 9 + 1}"
                >
                <c:choose>
                    <c:when
                        test="${pageNum == requestScope.page}"
                        >
                        <p
                            class="pagenum pagenum-num pagenum-active"
                            >
                            ${pageNum}
                        </p>
                    </c:when>
                    <c:otherwise>
                        <c:url
                            var="paging"
                            value="MainController"
                            >
                            <c:param
                                name="action"
                                value="Product"
                                />
                            <c:param
                                name="page"
                                value="${pageNum}"
                                />
                            <c:if
                                test="${param.search != null}"
                                >
                                <c:param
                                    name="search"
                                    value="${param.search}"
                                    />
                            </c:if>
                        </c:url>
                        <a
                            class="pagenum pagenum-num"
                            href="${paging}"
                            >${pageNum}</a
                        >
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if
                test="${requestScope.page < Math.ceil(requestScope.TOTAL_PRODUCT / 9)}"
                >
                <c:url
                    var="nextPaging"
                    value="MainController"
                    >
                    <c:param
                        name="action"
                        value="Product"
                        />
                    <c:param
                        name="page"
                        value="${requestScope.page + 1}"
                        />
                    <c:if test="${param.search != null}">
                        <c:param
                            name="search"
                            value="${param.search}"
                            />
                    </c:if>
                </c:url>
                <div class="step">
                    <a
                        class="pagenum pagenum-right"
                        href="${nextPaging}"
                        >
                        <p>Next</p>
                        <svg
                            class="arrow-right"
                            width="16"
                            height="16"
                            viewBox="0 0 16 16"
                            fill="none"
                            xmlns="http://www.w3.org/2000/svg"
                            >
                        <path
                            d="M6 3L11 8L6 13"
                            stroke="currentColor"
                            stroke-width="1.5"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            />
                        </svg>
                    </a>
                </div>
            </c:if>
        </div>
    </c:if>         
    <form action="MainController" method="POST">
        <input type="submit" name="action" value="View"/>
    </form>
    ${requestScope.MESSAGE}

    <!-- Link javascript -->
    <script src="./assets/js/script.js"></script>
</body>
</html>
