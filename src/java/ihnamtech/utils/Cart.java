/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihnamtech.utils;

import ihnamtech.dto.ProductDTO;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class Cart {

    private Map<Integer, ProductDTO> cart;

    public Cart() {
    }

    public Cart(Map<Integer, ProductDTO> cart) {
        this.cart = cart;
    }

    public Map<Integer, ProductDTO> getCart() {
        return this.cart;
    }

    public void setCart(Map<Integer, ProductDTO> cart) {
        this.cart = cart;
    }

    public boolean add(ProductDTO pdto) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(pdto.getProductID())) {
                int quantity = this.cart.get(pdto.getProductID()).getQuantity();
                pdto.setQuantity(quantity + pdto.getQuantity());
            }
            this.cart.put(pdto.getProductID(), pdto);
            check = true;
        } catch (Exception e) {
        }

        return check;
    }
    
    public boolean remove(int productID) {
        boolean check = false;
        try {
            if (this.cart != null) {

                if (this.cart.containsKey(productID)) {
                    this.cart.remove(productID);
                    check = true;
                }
            }
        } catch (Exception e) {
        }

        return check;
    }
    
    public boolean edit(int productID, ProductDTO pdto) {
        boolean check = false;
        try {
            if (this.cart != null) {

                if (this.cart.containsKey(productID)) {
                    this.cart.replace(productID, pdto);
                    check = true;
                }
            }
        } catch (Exception e) {
        }

        return check;
    }
}
