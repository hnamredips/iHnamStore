/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihnamtech.dao;

/**
 *
 * @author LENOVO
 */
public class UserError {

    private String usernameError;
    private String firstNameError;
    private String lastNameError;
    private String roleIDError;
    private String emailError;
    private String passwordError;
    private String confirmError;
    private String error;

    public UserError() {
        this.usernameError = "";
        this.firstNameError = "";
        this.lastNameError = "";
        this.roleIDError = "";
        this.emailError = "";
        this.passwordError = "";
        this.confirmError = "";
        this.error = "";
    }

    public UserError(String usernameError, String firstNameError, String lastNameError, String roleIDError, String emailError, String passwordError, String confirmError, String error) {
        this.usernameError = usernameError;
        this.firstNameError = firstNameError;
        this.lastNameError = lastNameError;
        this.roleIDError = roleIDError;
        this.emailError = emailError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.error = error;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getFirstNameError() {
        return firstNameError;
    }

    public void setFirstNameError(String firstNameError) {
        this.firstNameError = firstNameError;
    }

    public String getLastNameError() {
        return lastNameError;
    }

    public void setLastNameError(String lastNameError) {
        this.lastNameError = lastNameError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void getUsernameError(String duplicate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "UserError{" + "usernameError=" + usernameError + ", firstNameError=" + firstNameError + ", lastNameError=" + lastNameError + ", roleIDError=" + roleIDError + ", emailError=" + emailError + ", passwordError=" + passwordError + ", confirmError=" + confirmError + ", error=" + error + '}';
    }
    
    
    
}
