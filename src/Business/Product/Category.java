/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Product;

import DatabaseManagement.CategoriesDAO;
import DatabaseManagement.ProductDAO;

/**
 *
 * @author Benjamin Grimes
 */
public class Category 
{
    private int id;
    private String name;

    public Category(int id, String name) 
    {
        this.id = id;
        this.name = name;
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
    
    public static Category[] getCategories()
    {
        CategoriesDAO dbAccess = new CategoriesDAO();
        return dbAccess.getCategories();
    }
    
    public static Product[] getProductsOfCategory(int id) 
    {
        ProductDAO dbAccess = new ProductDAO();
        return dbAccess.getListProducts(id);
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
