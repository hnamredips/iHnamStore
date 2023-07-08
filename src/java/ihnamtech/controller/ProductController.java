/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihnamtech.controller;

import ihnamtech.dao.ProductDAO;
import ihnamtech.dto.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class ProductController extends HttpServlet {

    private static String SUCCESS = "shopping.jsp";
    private static String ERROR = "shopping.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String page = request.getParameter("page");
        String size = request.getParameter("size");
        String search = request.getParameter("search");
        String categoryID = request.getParameter("categoryID");
        String role = request.getParameter("role");

        try {
            if (page == null) {
                page = "1";
            }

            if (size == null) {
                size = "9";
            }

            ProductDAO pdao = new ProductDAO();
            List<ProductDTO> list = pdao.getProductList(Integer.parseInt(page), Integer.parseInt(size), search, categoryID);
            int totalProducts = pdao.TOTAL_PRODUCT;
            request.setAttribute("CATEGORY_ID", categoryID);

            if (totalProducts > 0) {
                request.setAttribute("page", page);
                request.setAttribute("PRODUCT_LIST", list);
                request.setAttribute("TOTAL_PRODUCT", totalProducts);
                url = SUCCESS;
            }

            if (role.equals("AD")) {
                url = "admin.jsp";
                request.setAttribute("PRODUCT_LIST", list);
                request.setAttribute("TOTAL_PRODUCT", totalProducts);
                request.setAttribute("page", page);
            }

        } catch (Exception e) {
            log("Error at ProductController: " + e.toString());
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
