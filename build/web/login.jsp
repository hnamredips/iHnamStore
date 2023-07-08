<%-- 
    Document   : login
    Created on : Jun 21, 2023, 5:09:31 PM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="./assets/css/style.css" />
        <!-- Unicons -->
        <link
            rel="stylesheet"
            href="https://unicons.iconscout.com/release/v4.0.0/css/line.css"
            />
    </head>
    <body>
        <c:import url="./header.jsp"/>
        <!-- Home -->
        <section class="home">
            <div class="form_container">
                <i class="uil uil-times form_close"></i>

                <div class="form login_form">
                    <form action="MainController" method="POST">
                        <h2>Login</h2>

                        <div class="input_box">
                            <input
                                type="text"
                                placeholder="Enter your username"
                                name="username"
                                required=""
                                />
                            <i class="uil uil-user username"></i>
                        </div>

                        <div class="input_box">
                            <input
                                type="password"
                                placeholder="Enter your password"
                                name="password"
                                required=""
                                />
                            <i class="uil uil-lock password"></i>
                            <i class="uil uil-eye-slash pw_hide"></i>
                        </div>

                        <div class="option_field">
                            <span class="checkbox">
                                <input type="checkbox" id="check" />
                                <label for="check">Remember me</label>
                            </span>
                            <a href="#" class="forgot_pw">Forgot password?</a>
                        </div>

                        <button class="button" type="submit" name="action" value="Login">
                            Login Now
                        </button>
                        <div class="separator">
                            <hr class="line" />
                            <span class="or">OR</span>
                            <hr class="line" />
                        </div>

                        <div class="alt-login">
                            <a
                                href="https://accounts.google.com/o/oauth2/auth?scope=profile%20email&redirect_uri=http://localhost:8084/iHnamTech/MainController?action=Google&response_type=code&client_id=130207933117-l55um12f91rrkqlahk7n08got3cqard5.apps.googleusercontent.com&approval_prompt=force"
                                class="btn-gg"
                                >
                                <img src="assets/image/google.svg" alt="Continue with Google" />
                                <p>Continue with Google</p>
                            </a>
                        </div>

                        <div class="login_signup">
                            Don't have an account?
                            <a href="./register.jsp" src="" id="signup">Sign up</a>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        ${requestScope.ERROR}

        <!-- Link javascript -->
        <script src="./assets/js/script.js"></script>
    </body>


</body>
</html>


