/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Product;

import Business.User.Customer;

/**
 *
 * @author Benjamin Grimes
 */
public class Product {

    private int id;
    private String name;
    private int catID;
    private int ownerID;
    private double price;
    private int rating;
    private String description;
    //private String URLPic;

    public Product(int id, String name, int catID, int ownerID, double price, int rating, String description/*, String URLPic*/) {
        this.id = id;
        this.name = name;
        this.catID = catID;
        this.ownerID = ownerID;
        this.price = price;
        this.rating = rating;
        this.description = description;
        //this.URLPic = URLPic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCategoryID() {
        return catID;
    }

    public void setCategory(int catID) {
        this.catID = catID;
    }

    public int getOwner() {
        return ownerID;
    }

    public void setOwner(int ownerID) {
        this.ownerID = ownerID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
  
    @Override
    public String toString()
    {
        return getName();
    }
}
