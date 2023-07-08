<%-- 
    Document   : register
    Created on : Jun 29, 2023, 12:21:00 PM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="stylesheet" href="./assets/css/style.css" />
        <!-- Unicons -->
        <link
            rel="stylesheet"
            href="https://unicons.iconscout.com/release/v4.0.0/css/line.css"
            />
    </head>
    <body>
        <c:import url="./header.jsp"/>

        <section class="home show">
            <div class="form_container">
                <i class="uil uil-times form_close"></i>
                <!-- Sign Up Form -->
                <div class="form signup_form">
                    <form action="MainController" method="POST">
                        <h2>Sign up</h2>

                        <div class="input_box">
                            <input
                                type="text"
                                placeholder="Enter your username"
                                name="username"
                                required=""
                                />${requestScope.USER_ERROR.usernameError}
                            <i class="uil uil-user username"></i>
                        </div>

                        <div class="input_box">
                            <div class="name">
                                <input
                                    type="text"
                                    placeholder="First name"
                                    name="firstName"
                                    required=""
                                    />${requestScope.USER_ERROR.firstNameError}
                                <input
                                    type="text"
                                    placeholder="Last name"
                                    name="lastName"
                                    required=""
                                    />${requestScope.USER_ERROR.lastNameError}
                            </div>
                        </div>

                        <div class="input_box">
                            <input
                                type="email"
                                placeholder="Enter your email"
                                name="email"
                                required=""
                                />${requestScope.USER_ERROR.emailError}
                            <i class="uil uil-envelope-alt username"></i>
                        </div>

                        <div class="input_box">
                            <input
                                type="password"
                                placeholder="Create password"
                                name="password"
                                required=""
                                />
                            <i class="uil uil-lock password"></i>
                            <i class="uil uil-eye-slash pw_hide"></i>
                        </div>

                        <div class="input_box">
                            <input
                                type="password"
                                placeholder="Confirm password"
                                name="confirm"
                                required=""
                                />${requestScope.USER_ERROR.confirmError}
                            <i class="uil uil-lock password"></i>
                            <i class="uil uil-eye-slash pw_hide"></i>
                        </div>

                        <button class="button" type="submit" name="action" value="Register">Sign up</button>

                        <div class="login_signup">
                            Already have an account?
                            <a href="./login.jsp" id="login">Login</a>
                        </div>
                        ${requestScope.USER_ERROR.error}
                    </form>
                </div>
            </div>
        </section>

        <script src="./assets/js/script.js"></script>
    </body>
</html>
