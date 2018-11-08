/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManagement;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Benjamin Grimes
 */
public class CustomerDAO implements DAO 
{
    private static final String DBNAME = "BeanSquadRentalDB";
    private static final String RDS_INSTANCE_HOSTNAME = "beansquadinstance.cvkugwdh5xf5.eu-west-1.rds.amazonaws.com";
    private static final int RDS_INSTANCE_PORT = 3306;
    private static final String JDBC_URL = "jdbc:mysql://" + RDS_INSTANCE_HOSTNAME 
            + ":" + RDS_INSTANCE_PORT+ "/BeanSquadRentalDB?user=BeanSquad&password=squad1234";
    
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
    
    public boolean insert(String name, String email, String password) throws SQLException
    {
        /*
        boolean inserted = false;
        try
        {
            connection = DriverManager.getConnection(JDBC_URL);
            String query = "INSERT INTO BeanSquadRentalDB.Users "
                    + "VALUES ( default, ? , ? , PASSWORD( ? ))";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
            
            if(result == 1)
                inserted = true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(connection != null)
                connection.close();
            if(statement != null)
                statement.close();
            if(preparedStatement != null)
                preparedStatement.close();
            if(resultSet != null)
                resultSet.close();
        }
        return inserted;
        */
        return false;
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
    
    public int findCustomer(String username, String pw) throws SQLException
    {
        int id = 0;
        
        try 
        {
            System.out.println("Connecting to " + DBNAME + "...");
            connection = DriverManager.getConnection(JDBC_URL);
            
            // Query
            statement = connection.createStatement();
            String query = "SELECT *"
                    + " FROM BeanSquadRentalDB.Users"
                    + " WHERE username = '" + username + "' "
                    + "AND password = PASSWORD('" + pw + "')";
            
            resultSet = statement.executeQuery(query);
            
            if(resultSet.next())
            {
                id = resultSet.getInt("userID");
            }
            else
            {
                // No result found.
            }
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        finally
        {
            if(connection != null)
                connection.close();
            if(statement != null)
                statement.close();
            if(resultSet != null)
                resultSet.close();
        }
        
        return id;
    }
    
    public boolean findUsername(String username) throws SQLException
    {
        boolean found = false;
        
        try 
        {
            connection = DriverManager.getConnection(JDBC_URL);
            
            // Query
            statement = connection.createStatement();
            String query = "SELECT * "
                    + "FROM BeanSquadRentalDB.Users "
                    + "WHERE name = '" + username + "'";
            
            resultSet = statement.executeQuery(query);
            if(resultSet.next())
            {
                found = true;
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            if(connection != null)
                connection.close();
            if(statement != null)
                statement.close();
            if(resultSet != null)
                resultSet.close();
        }
        
        return found;
    }
    
    public boolean findEmail(String email) throws SQLException
    {
        boolean found = false;
        
        try
        {
            connection = DriverManager.getConnection(JDBC_URL);
            
            // Query
            statement = connection.createStatement();
            String query = "SELECT * "
                    + "FROM BeanSquadRentalDB.Users "
                    + "WHERE email = '" + email + "'";
            
            resultSet = statement.executeQuery(query);
            if(resultSet.next())
            {
                found = true;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(connection != null)
                connection.close();
            if(statement != null)
                statement.close();
            if(resultSet != null)
                resultSet.close();
        }
        return found;
    }
    
}
