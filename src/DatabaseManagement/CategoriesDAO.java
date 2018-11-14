/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManagement;

import Business.Product.Category;
import java.sql.Connection;
import java.sql.Driver;
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
public class CategoriesDAO implements DAO
{
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static PreparedStatement preparedStatement = null;

    @Override
    public String select(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static ArrayList<Category> getCategories() throws SQLException
    {
        ArrayList<Category> categoryList = new ArrayList<>();
        
        try 
        {
            connection = DriverManager.getConnection(JDBC_URL);
            statement = connection.createStatement();
            String query = "SELECT * "
                    + "FROM BeanSquadRentalDB.Categories "
                    + "ORDER BY catName";
            resultSet = statement.executeQuery(query);
            
            int catID;
            String catName;
            while(resultSet.next())
            {
                catID = resultSet.getInt("catID");
                catName = resultSet.getString("catName");
                categoryList.add(new Category(catID , catName));
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            close();
        }
        
        return categoryList;
    }
    
    public static void close() throws SQLException
    {
        if(connection != null)
            connection.close();
        if(statement != null)
            statement.close();
        if(resultSet != null)
            resultSet.close();
    }
}