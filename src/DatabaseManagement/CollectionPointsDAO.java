/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManagement;

import Business.BusinessManagement.CollectionPoint;
import Business.BusinessManagement.Locker;
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
public class CollectionPointsDAO implements DAO
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
    
    public void addLocker(String address)
    {
        
    }
    
    public ArrayList<CollectionPoint> getLockers() throws SQLException
    {
        ArrayList<CollectionPoint> cPoints = new ArrayList<>();
        try
        {
            connection = DriverManager.getConnection(JDBC_URL);
            statement = connection.createStatement();
            String query = "SELECT * "
                    + "FROM BeanSquadRentalDB.CollectionPoints";
            resultSet = statement.executeQuery(query);
            
            int cpID;
            String postCode, address;
            
            while(resultSet.next())
            {
                cpID = resultSet.getInt("cpID");
                postCode = resultSet.getString("postCode");
                address = resultSet.getString("address");
                cPoints.add(new CollectionPoint(cpID, postCode, address));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            close();
        }
        return cPoints;
    }
    
    private void close() throws SQLException
    {
        if(connection != null)
            connection.close();
        if(statement != null)
            statement.close();
        if(resultSet != null)
            resultSet.close();
    }
    
}
