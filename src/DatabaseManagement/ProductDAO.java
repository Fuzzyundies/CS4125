/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManagement;

import Business.Product.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Benjamin Grimes
 */
public class ProductDAO implements DAO 
{
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static PreparedStatement preparedStatement = null;

    @Override
    public String select(Object o) 
    {
        String result = "";
        
        return result;
    }

    @Override
    public boolean insert(Object o) 
    {
        boolean inserted = false;
        
        return inserted;
    }

    @Override
    public boolean update(Object o) 
    {
        boolean updated = false;
        
        return updated;
    }

    @Override
    public boolean delete(Object o) 
    {
        boolean deleted = false;
        
        return deleted;
    }
    
    public static Product[] getListProducts(int cID)
    {
        ArrayList<Product> products = new ArrayList<Product>();
        
        try
        {
            connection = DriverManager.getConnection(JDBC_URL);
            statement = connection.createStatement();
            String query = "Select * "
                    + "FROM BeanSquadRentalDB.Products "
                    + "WHERE catID = " + cID;
            
            resultSet = statement.executeQuery(query);
            
            int pID;
            int ownerID;
            String pName;
            String description;
            int is_available;
            int catID;
            double price;
            int rating;
            
            while(resultSet.next())
            {
                pID = resultSet.getInt("pID");
                ownerID = resultSet.getInt("ownerID");
                pName = resultSet.getString("pName");
                description = resultSet.getString("description");
                is_available = resultSet.getInt("is_available");
                catID = resultSet.getInt("catID");
                price = resultSet.getDouble("price");
                rating = resultSet.getInt("rating");
                products.add(new Product(pID, pName, catID, ownerID, 300, rating, description, is_available)); //300 for testing purposes 
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        Product [] tmp = new Product[products.size()];
        
        for(int i = 0; i < tmp.length; i++)
            tmp[i] = products.get(i);
        
        return tmp;
    }
    
    public static Product [] getHistory(int userID)
    {
        ArrayList<Product> products = new ArrayList<Product>();
        
        try 
        {
            connection = DriverManager.getConnection(JDBC_URL);
            statement = connection.createStatement();
            String query = "SELECT * " +
                            "FROM BeanSquadRentalDB.Products " +
                            "WHERE ownerID IN (SELECT rID " +
                                             "FROM History WHERE " + userID + " = 1)";
            
            resultSet = statement.executeQuery(query);
            
            int pID;
            int ownerID;
            String pName;
            String description;
            int is_available;
            int catID;
            double price;
            int rating;
            
            while(resultSet.next())
            {
                pID = resultSet.getInt("pID");
                ownerID = resultSet.getInt("ownerID");
                pName = resultSet.getString("pName");
                description = resultSet.getString("description");
                is_available = resultSet.getInt("is_available");
                catID = resultSet.getInt("catID");
                price = resultSet.getDouble("price");
                rating = resultSet.getInt("rating");
                products.add(new Product(pID, pName, catID, ownerID, price, rating, description, 0)); //0 just for testing unavailable product
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        Product [] tmp = new Product[products.size()];
        
        for(int i = 0; i < tmp.length; i++)
            tmp[i] = products.get(i);
        
        return tmp;
    }
    
    public int getLeaserID(int productID)
    {
        int leaserID = -1;
        try{
            connection = DriverManager.getConnection(JDBC_URL);
            statement = connection.createStatement();
            String query = "SELECT ownerID "
                    + "FROM BeanSquadRentalDB.Products "
                    + "WHERE pID = " + productID + ";";
            resultSet = statement.executeQuery(query);
            if(resultSet.next())
            {
                return resultSet.getInt("ownerID");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return leaserID;
    }
    
    
    @Override
    public void close()
    {
        try{
        if(connection != null)
            connection.close();
        if(statement != null)
            statement.close();
        if(resultSet != null)
            resultSet.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
