/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Jonas
 */
public class Order {
    private int id;
    private int userId;
    private int bookId;
    private int totalPrice;
    private Date orderDate;
    private int quatiay;

    public Order(int id, int userId, int bookId, int totalPrice, Date orderDate, int quatiay) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.quatiay = quatiay;
    }

    public Order(int userId, int bookId,  int totalPrice, int quatiay) {
        this.userId = userId;
        this.bookId = bookId;
        this.totalPrice = totalPrice;
        this.quatiay = quatiay;
    }

    public int getId() {
        return id;
    }

 

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }



    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuatiay() {
        return quatiay;
    }

    public void setQuatiay(int quatiay) {
        this.quatiay = quatiay;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + ", quatiay=" + quatiay + '}';
    }



    
    
    
    
    
    
    
}
