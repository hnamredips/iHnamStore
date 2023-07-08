/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihnamtech.dto;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class OrderDTO {

    private String orderID;
    private CustomerDTO customer;
    private Date orderDate;
    private String paymentMethod;
    private float totalAmount;
    private String shippingAddress;
    private String shippingPhone;
    private String status;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, CustomerDTO customer, Date orderDate, String paymentMethod, float totalAmount, String shippingAddress, String shippingPhone, String status) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
        this.shippingPhone = shippingPhone;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderID=" + orderID + ", customer=" + customer + ", orderDate=" + orderDate + ", paymentMethod=" + paymentMethod + ", totalAmount=" + totalAmount + ", shippingAddress=" + shippingAddress + ", shippingPhone=" + shippingPhone + ", status=" + status + '}';
    }
    
    

}
