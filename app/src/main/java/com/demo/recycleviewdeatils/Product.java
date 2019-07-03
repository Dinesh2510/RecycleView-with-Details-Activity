package com.demo.recycleviewdeatils;



public class Product {
    private int id;
    private String title;
    private String shortdesc;

    private int image;

    public Product(int id, String title, String shortdesc,  int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;

        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }


    public int getImage() {
        return image;
    }
}

