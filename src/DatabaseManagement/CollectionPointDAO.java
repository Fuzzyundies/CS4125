/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Benjamin Grimes
 */
public class CollectionPointDAO implements DAO
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
}
