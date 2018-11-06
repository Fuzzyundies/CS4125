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

    private String id;
    private String name;
    private Category category;
    private Customer owner;
    private double price;
    private int rating;
    private String description;
    private String URLPic;

    public Product(String id, String name, Category category, Customer owner, double price, int rating, String description, String URLPic) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.owner = owner;
        this.price = price;
        this.rating = rating;
        this.description = description;
        this.URLPic = URLPic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
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

}
