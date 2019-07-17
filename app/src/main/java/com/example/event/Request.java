package com.example.event;

import java.util.List;

public class Request {

    private String total;
    private List<Order> foods;
    private String address;

    public Request(String total, List<Order> foods,String address) {
        this.total = total;
        this.foods = foods;
        this.address=address;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }


    public Request(String total, String s, List<Order> cart)
    {

    }






}

