/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihnamtech.controller;

import ihnamtech.dao.UserDAO;
import ihnamtech.dao.UserError;
import ihnamtech.dto.CustomerDTO;
import ihnamtech.dto.UserDTO;
import ihnamtech.utils.Email;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class RegisterController extends HttpServlet {

    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        UserError userError = new UserError();
        try {
            UserDAO dao = new UserDAO();
            CustomerDTO cdto = new CustomerDTO();
            UserDTO udto = new UserDTO();
            boolean checkValidation = true;
            boolean duplicated = false;
            String username = request.getParameter("username");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String roleID = request.getParameter("roleID");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");

            if (dao.checkDuplicate(email, "EMAIL")) {
                userError.setEmailError("Email is already taken");
                duplicated = true;
            }
            if (!duplicated && dao.checkDuplicate(username, "USERNAME")) {
                userError.setUsernameError("Username is already taken");
                duplicated = true;
            }

            if (username.length() < 2 || username.length() > 15) {
                userError.setUsernameError("Username must be in [2, 15]");
                checkValidation = false;
            }
//            boolean checkDuplicate = dao.checkDuplicate(userID);
//            
//            if (checkDuplicate) {
//                userError.setUserIDError("Duplicate UserID!!!");
//                checkValidation = false;
//            }
            if (firstName.length() < 1 || firstName.length() > 20) {
                userError.setFirstNameError("First Name must be in [1,20]");
                checkValidation = false;
            }
            if (lastName.length() < 1 || lastName.length() > 20) {
                userError.setLastNameError("Last Name must be in [1,20]");
                checkValidation = false;
            }
            if (!password.equals(confirm)) {
                userError.setConfirmError("Those password does not match !!!");
                checkValidation = false;
            }
            if (checkValidation) {
                boolean checkInsert = dao.registerUser(username, email, password);

                if (checkInsert) {

                    if (checkInsert) {
                        url = SUCCESS;
                        // Set success message in the request attribute
                        request.setAttribute("SUCCESS_MESSAGE", "Sign up successful!");
                        String rootPath = request.getScheme() + "://" + request.getServerName()
                                + ":" + request.getServerPort() + request.getContextPath();
                        Email.sendEmail(email, "Registration successful", Email.templateEmail(username, email));
                    } else {
                        userError.setError("Unknown error!");
                        request.setAttribute("USER_ERROR", userError);
                    }
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }

        } catch (Exception e) {
            log("Error at RegisterController: " + e.toString());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
