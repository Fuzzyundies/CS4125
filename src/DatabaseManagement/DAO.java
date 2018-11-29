/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManagement;

/**
 *
 * @author Benjamin Grimes
 */
public interface DAO 
{
    static final String DBNAME = "BeanSquadRentalDB";
    static final String RDS_INSTANCE_HOSTNAME = "beansquadinstance.cvkugwdh5xf5.eu-west-1.rds.amazonaws.com";
    static final int RDS_INSTANCE_PORT = 3306;
    static final String JDBC_URL = "jdbc:mysql://" + RDS_INSTANCE_HOSTNAME 
            + ":" + RDS_INSTANCE_PORT+ "/BeanSquadRentalDB?user=BeanSquad&password=squad1234";
    
    String select(Object o);
    
    boolean insert(Object o);
    
    boolean update(Object o);
    
    boolean delete(Object o);
    
    void close();
}
