package com.sm.shahriaz.smartmenu;

public class ListItem {

        private String foodname;
        private String fooddetails;
        private String foodimage;
        private String armodel;
        private String fromcategory;

    public ListItem(String foodname, String fooddetails, String foodimage, String armodel, String fromcategory) {
        this.foodname = foodname;
        this.fooddetails = fooddetails;
        this.foodimage = foodimage;
        this.armodel = armodel;
        this.fromcategory = fromcategory;
    }

    public String getFoodname() {
        return foodname;
    }

    public String getFooddetails() {
        return fooddetails;
    }

    public String getFoodimage() {
        return foodimage;
    }

    public String getArmodel() {
        return armodel;
    }

    public String getFromcategory() {
        return fromcategory;
    }
}
