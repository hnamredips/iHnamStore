/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihnamtech.dto;

/**
 *
 * @author LENOVO
 */
public class UserDTO {

    private int userID;
    private CustomerDTO customer;
    private String googleID;
    private String roleID;  
    private String username;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(int userID, CustomerDTO customer, String googleID, String roleID, String username, String email, String password) {
        this.userID = userID;
        this.customer = customer;
        this.googleID = googleID;
        this.roleID = roleID;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public String getGoogleID() {
        return googleID;
    }

    public void setGoogleID(String googleID) {
        this.googleID = googleID;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", customer=" + customer + ", googleID=" + googleID + ", roleID=" + roleID + ", username=" + username + ", email=" + email + ", password=" + password + '}';
    }

    
}
