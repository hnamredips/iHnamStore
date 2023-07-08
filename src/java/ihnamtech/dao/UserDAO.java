/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihnamtech.dao;

import ihnamtech.dto.CustomerDTO;
import ihnamtech.dto.GoogleDTO;
import ihnamtech.dto.UserDTO;
import ihnamtech.utils.DBUtils;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author LENOVO
 */
public class UserDAO {

    private static final String LOGIN = "{CALL GetCustomerInfo(?, ?)}";
    private static final String LOGIN_WITH_GOOGLE = "{CALL VerifyGoogleCredentials(?, ?, ?, ?, ?)}";
    private static final String GET_USER_BY_GOOGLEID = "{CALL GetUserInformationGoogleID(?)}";
    private static final String INSERT = "{CALL InsertUser(?, ?, ?)}";
    private static final String EMAIL_DUPLICATE = "{CALL CheckDuplicateEmail(?, ?)}";
    private static final String USERNAME_DUPLICATE = "{CALL CheckDuplicateUsername(?, ?)}";

    public boolean loginWithGoogle(GoogleDTO gdto) throws SQLException {
        Connection conn = null;
        CallableStatement cs = null;
        boolean check = false;

        try {
            conn = DBUtils.getConnection();

            if (conn != null) {
                cs = conn.prepareCall(LOGIN_WITH_GOOGLE);
                cs.setString(1, gdto.getId());
                cs.setString(2, gdto.getEmail());
                cs.setString(3, gdto.getGiven_name());
                cs.setString(4, gdto.getFamily_name());
                cs.registerOutParameter(5, Types.BIT);
                cs.execute();
                check = cs.getBoolean(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (cs != null) {
                cs.close();
            }
        }
        return check;
    }

    public UserDTO getUserInformation(String google_id) throws SQLException {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        boolean check = false;
        CustomerDTO cdto = new CustomerDTO();
        UserDTO udto = new UserDTO();

        try {
            conn = DBUtils.getConnection();

            if (conn != null) {
                cs = conn.prepareCall(GET_USER_BY_GOOGLEID);
                cs.setString(1, google_id);
                rs = cs.executeQuery();
                if (rs.next()) {
                    int userID = rs.getInt("UserID");
                    int customerID = rs.getInt("CustomerID");
                    String googleID = rs.getString("GoogleID");
                    String roleID = rs.getString("RoleID");
                    String email = rs.getString("Email");
                    String username = rs.getString("UserName");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String phone = rs.getString("Phone");

                    cdto = new CustomerDTO(customerID, firstName, lastName, null, phone);
                    udto = new UserDTO(userID, cdto, googleID, roleID, username, email, null);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return udto;
    }

    public UserDTO checkLogin(String userName, String password) throws SQLException {

        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        CustomerDTO cdto = new CustomerDTO();
        UserDTO udto = new UserDTO();

        try {
            conn = DBUtils.getConnection();

            if (conn != null) {
                cs = conn.prepareCall(LOGIN);
                cs.setString(1, userName);
                cs.setString(2, password);
                rs = cs.executeQuery();

                if (rs.next()) {
                    int customerID = rs.getInt("CustomerID");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    int userID = rs.getInt("UserID");
                    String googleID = rs.getString("GoogleID");
                    String roleID = rs.getString("RoleID");
                    String email = rs.getString("Email");

                    cdto = new CustomerDTO(customerID, firstName, lastName, address, phone);
                    udto = new UserDTO(userID, cdto, googleID, roleID, userName, email, password);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        return udto;
    }

    public boolean checkDuplicate(String param, String type) throws SQLException {
        boolean check = false;
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = DBUtils.getConnection();

            if (conn != null) {
                switch (type) {
                    case "EMAIL":
                        cs = conn.prepareCall(EMAIL_DUPLICATE);
                        break;
                    case "USERNAME":
                        cs = conn.prepareCall(USERNAME_DUPLICATE);
                        break;
                    default:
                        return check;
                }
                cs.setString(1, param);
                cs.registerOutParameter(2, Types.BIT);
                cs.execute();
                check = cs.getBoolean(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }

    public boolean registerUser(String username, String email, String password) throws SQLException {
        boolean success = false;
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                cs = conn.prepareCall(INSERT);
                cs.setString(1, username);
                cs.setString(2, email);
                cs.setString(3, password);

                int rowsAffected = cs.executeUpdate();
                if (rowsAffected > 0) {
                    success = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return success;
    }
}
