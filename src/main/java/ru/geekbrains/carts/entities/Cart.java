package ru.geekbrains.carts.entities;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart{
    private Map<String,LineItem> items;
    private Customer customer;
    private Payment payment;

    public Cart(){
        items = new HashMap<>();
        customer = new Customer();
        payment = new Payment();
    }

    public void addItem(Product product){

        LineItem lineItem = items.get(product.getCod());
        if(lineItem != null){
            lineItem.setQuantity(lineItem.getQuantity()+1);
        }

        LineItem item = new LineItem(product, 1);
        this.items.put(product.getCod(),item);
    }

    public void updateItemQuantity(Product product, int quantity){
        LineItem lineItem = items.get(product.getCod());
        if(lineItem != null) {
            lineItem.setQuantity(quantity);
        }
    }

    public void removeItem(String cod){
        items.remove(cod);
    }

    public void clearItems(){
        items = new HashMap<>();
    }

    public int getItemCount(){
        int count = 0;
        for (Map.Entry<String,LineItem> entry : items.entrySet()) {
            count +=  entry.getValue().getQuantity();
        }
        return count;
    }

    public Map<String,LineItem> getItems(){
        return items;
    }

    public void setItems(Map<String,LineItem> items){
        this.items = items;
    }

    public BigDecimal getTotalAmount(){
        BigDecimal amount = new BigDecimal("0.0");

        for (Map.Entry<String,LineItem> entry : items.entrySet()) {
            amount = amount.add(entry.getValue().getSubTotal());
        }
        return amount;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Payment getPayment(){
        return payment;
    }

    public void setPayment(Payment payment){
        this.payment = payment;
    }
}
