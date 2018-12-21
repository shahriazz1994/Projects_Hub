package com.sm.shahriaz.smartmenu;

public class CategoryItem {
    private String categoryname;
    private String categorydetails;
    private String categoryimage;
    private String id;

    public CategoryItem(String categoryname, String categorydetails, String categoryimage, String id) {
        this.categoryname = categoryname;
        this.categorydetails = categorydetails;
        this.categoryimage = categoryimage;
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public String getCategorydetails() {
        return categorydetails;
    }

    public String getCategoryimage() {
        return categoryimage;
    }

    public String getId() {
        return id;
    }
}
