package com.example.recyclerview;

public class ItemModel {

    private String title;
    private String description;
    private int image;

    public ItemModel(String title, String description, int image){
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }


}
