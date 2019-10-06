package com.example.contactv2;

import java.io.Serializable;

public class Contact implements Serializable {
    private int id; //phan biet contact, khi lưu vào database thì id tự tăng
    private String name;
    private String phone;

    public Contact(){
    }

    public Contact(String name, String phone) {
        this.name = name;
        this.phone= phone;
    }
    public Contact(int id, String name, String phone){
        this.id =id;
        this.name=name;
        this.phone=phone;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }

}
