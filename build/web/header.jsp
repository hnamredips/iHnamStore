

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
    <nav class="nav">
        <a href="./index.jsp" class="nav_logo">iHnamTech</a>

        <ul class="nav_items">
            <li class="nav_item">
                <a href="#" class="nav_link">Home</a>
                <a href="MainController?action=Product" class="nav_link">Product</a>
                <a href="#" class="nav_link">Services</a>
                <a href="#" class="nav_link">Contact</a>
            </li>
        </ul>

        <c:if test="${sessionScope.USER == null}">
            <button class="button" id="form-open"><a href="./login.jsp">Login</a></button>
        </c:if>
        <c:if test="${sessionScope.USER != null}">
            <div class="nav_icons">
                <a href="#" class="nav_icon"><i class="uil uil-user"></i></a>
                <a href="./viewCart.jsp" class="nav_icon"><i class="uil uil-shopping-cart"></i></a>
                <a href="MainController?action=Logout" class="nav_icon"
                   ><i class="uil uil-home"></i
                    ></a>

            </div>
        </c:if>
    </nav>
</header>