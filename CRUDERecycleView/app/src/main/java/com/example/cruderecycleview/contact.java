package com.example.cruderecycleview;

public class contact {
    int img;
    String name, number;
    public  contact(int image, String name, String number){
        this.name = name;
        this.number = number;
        this.img = image;
    }
    public  contact(String name, String number){
        this.name = name;
        this.number = number;
    }
}
