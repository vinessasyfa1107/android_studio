package com.example.recyclerviewcard;

public class ItemModel_CardView {

    private String title;
    private String description;
    private int image;

    public ItemModel_CardView(String title, String description, int image){
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
