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
public class OrderDetailDTO {

    private String orderDetailID;
    private OrderDTO order;
    private ProductDTO product;
    private int quantity;
    private float unitPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderDetailID, OrderDTO order, ProductDTO product, int quantity, float unitPrice) {
        this.orderDetailID = orderDetailID;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "orderDetailID=" + orderDetailID + ", order=" + order + ", product=" + product + ", quantity=" + quantity + ", unitPrice=" + unitPrice + '}';
    }
    
}
