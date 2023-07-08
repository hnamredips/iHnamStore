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
public class CategoryDTO {

    private int categoryID;
    private String categoryName;
    private String picture;

    public CategoryDTO() {
    }

    public CategoryDTO(int categoryID, String categoryName, String picture) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.picture = picture;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" + "categoryID=" + categoryID + ", categoryName=" + categoryName + ", picture=" + picture + '}';
    }

    
    
    

}
