/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManagement;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
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
    private static final String RDS_INSTANCE_HOSTNAME = "rds-mysql-testdb.cvkugwdh5xf5.eu-west-1.rds.amazonaws.com";
    private static final int RDS_INSTANCE_PORT = 3306;
    private static final String JDBC_URL = "jdbc:mysql://" + RDS_INSTANCE_HOSTNAME 
            + ":" + RDS_INSTANCE_PORT+ "/BeanSquadRentalDB?user=benjamingrimes&password=benjamingrimes";
    
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

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
    
    public int findCustomer(String name, String pw) throws SQLException
    {
        int id = 0;
        
        try 
        {
            System.out.println("Connecting to " + DBNAME + "...");
            connection = DriverManager.getConnection(JDBC_URL);
            
            // Query
            statement = connection.createStatement();
            String query = "SELECT * "
                    + "FROM BeanSquadRentalDB.Users "
                    + "WHERE name = '" + name + "' AND password = PASSWORD('" + pw + "')";
            resultSet = statement.executeQuery(query);
            
            if(resultSet.next())
            {
                id = resultSet.getInt("id");
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
    
}
