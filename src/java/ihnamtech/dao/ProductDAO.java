/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihnamtech.dao;

import ihnamtech.dto.CategoryDTO;
import ihnamtech.dto.ImageDTO;
import ihnamtech.dto.ProductDTO;
import ihnamtech.utils.DBUtils;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ProductDAO {

    public int TOTAL_PRODUCT = 0;
    private static final String GET_PRODUCT_LIST = "{CALL GetProductList(?, ?, ?, ?, ?)}";
    private static final String UPDATE = "UPDATE Products SET ProductName= ?, Quantity= ?, ImageURL= ? WHERE ProductID= ?";
    private static final String DELETE = "DELETE Products WHERE userID=?";

    public List<ProductDTO> getProductList(int pageNumber, int pageSize, String search, String categoryCode) throws SQLException {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();

        try {
            conn = DBUtils.getConnection();

            if (conn != null) {
                cs = conn.prepareCall(GET_PRODUCT_LIST);
                cs.setInt(1, pageNumber);
                cs.setInt(2, pageSize);
                cs.setString(3, search);
                cs.setString(4, categoryCode);
                cs.registerOutParameter(5, Types.INTEGER);
                rs = cs.executeQuery();

                while (rs.next()) {
                    ProductDTO pdto = new ProductDTO();
                    CategoryDTO cdto = new CategoryDTO();

                    int categoryID = rs.getInt("CategoryID");
                    String categoryName = rs.getString("CategoryName");
                    int productID = rs.getInt("ProductID");
                    String productName = rs.getString("ProductName");
                    String description = rs.getString("Description");
                    float price = rs.getFloat("Price");
                    String imageURL = rs.getString("ImageURL");
                    int quantity = rs.getInt("Quantity");

                    cdto.setCategoryID(categoryID);
                    cdto.setCategoryName(categoryName);
                    pdto.setCategory(cdto);
                    pdto.setProductID(productID);
                    pdto.setProductName(productName);
                    pdto.setDescription(description);
                    pdto.setPrice(price);
                    pdto.setQuantity(quantity);
                    pdto.setImageURL(imageURL);
                    list.add(pdto);
                }

                TOTAL_PRODUCT = cs.getInt(5);
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }

//    public Boolean addProduct(ProductDTO newProduct) throws SQLException {
//        boolean check = false;
//        Connection conn = null;
//        PreparedStatement ptm = null;
////        ResultSet rs = null;
//        try {
////           code 
//            conn = DBUtils.getConnection();
//            if (conn != null) { 
//                ptm = conn.prepareStatement(ADD);
//                ptm.setString(1, newProduct.getProductName());
//                ptm.setString(2, newProduct.getDescription());
//                ptm.setInt(3, newProduct.getCategory().getCategoryID());
//                ptm.setFloat(4, newProduct.getPrice());
//                ptm.setInt(5, newProduct.getQuantity());
//                check = ptm.executeUpdate() > 0 ? true : false;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
////            if (rs != null) {
////                rs.close();
////            }
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return check;
//    }
    public boolean update(ProductDTO pdto) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, pdto.getProductName());
                ptm.setInt(2, pdto.getQuantity());
                ptm.setString(3, pdto.getImageURL());
                ptm.setInt(4, pdto.getProductID());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean delete(int productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setInt(1, productID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

}
