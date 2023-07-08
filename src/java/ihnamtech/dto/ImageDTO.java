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
public class ImageDTO {

    private String imageID;
    private ProductDTO product;
    private String imageURL;

    public ImageDTO() {
    }

    public ImageDTO(String imageID, ProductDTO product, String imageURL) {
        this.imageID = imageID;
        this.product = product;
        this.imageURL = imageURL;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "ImageDTO{" + "imageID=" + imageID + ", product=" + product + ", imageURL=" + imageURL + '}';
    }
    
    
    
}
