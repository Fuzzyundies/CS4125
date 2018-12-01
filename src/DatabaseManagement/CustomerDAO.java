/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManagement;

import Business.Product.Product;
import static DatabaseManagement.DAO.JDBC_URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Benjamin Grimes
 */
public class CustomerDAO implements DAO {

    /*    private static final String DBNAME = "BeanSquadRentalDB";
    private static final String RDS_INSTANCE_HOSTNAME = "beansquadinstance.cvkugwdh5xf5.eu-west-1.rds.amazonaws.com";
    private static final int RDS_INSTANCE_PORT = 3306;
    private static final String JDBC_URL = "jdbc:mysql://" + RDS_INSTANCE_HOSTNAME
    + ":" + RDS_INSTANCE_PORT+ "/BeanSquadRentalDB?user=BeanSquad&password=squad1234";
     */
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static PreparedStatement preparedStatement = null;

    @Override
    public String select(Object o) {
        String result = "";

        return result;
    }

    @Override
    public boolean insert(Object o) {
        boolean inserted = false;

        return inserted;
    }

    @Override
    public boolean update(Object o) {
        boolean updated = false;

        return updated;
    }

    @Override
    public boolean delete(Object o) {
        boolean deleted = false;

        return deleted;
    }

    public boolean addNewCustomer(String name, String email, String password, LocalDate subStartDate, LocalDate subEndDate) throws SQLException {
        boolean inserted = false;
        try {
            connection = DriverManager.getConnection(JDBC_URL);
            String query = "INSERT INTO BeanSquadRentalDB.Users "
                    + "VALUES ( default, ? , PASSWORD( ? ) ,  ? , default, default, default, ? , ? )";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setDate(4, Date.valueOf(subStartDate));
            preparedStatement.setDate(5, Date.valueOf(subEndDate));
            int result = preparedStatement.executeUpdate();
            System.out.println(result);

            if (result == 1) {
                inserted = true;
            }

            close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return inserted;
    }

    public int findCustomer(String username, String pw) throws SQLException {
        int id = 0;
        try {
            System.out.println("Connecting to " + DBNAME + "...");
            connection = DriverManager.getConnection(JDBC_URL);

            // Query
            statement = connection.createStatement();
            String query = "SELECT *"
                    + " FROM BeanSquadRentalDB.Users"
                    + " WHERE username = '" + username + "' "
                    + "AND password = PASSWORD('" + pw + "')";

            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                id = resultSet.getInt("userID");
            } else {
                // No result found.
            }
            close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return id;
    }

    public LocalDate[] getSubscriptionDetails(String username) {
        LocalDate[] subDates = new LocalDate[2];
        try {
            connection = DriverManager.getConnection(JDBC_URL);
            String query = "SELECT subStartDate, subEndDate FROM "
                    + "BeanSquadRentalDB.Users WHERE username = '" + username + "';";

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                subDates[0] = resultSet.getDate("subStartDate").toLocalDate();
                subDates[1] = resultSet.getDate("subEndDate").toLocalDate();
            }

            close();
        } catch (SQLException sEx) {
            sEx.printStackTrace();
        }
        return subDates;
    }

    public void renewSubscription(LocalDate newEndDate) {
        try {
            connection = DriverManager.getConnection(JDBC_URL);
            String query = "UPDATE BeanSquadRentalDB.Users"
                    + " SET subEndDate = ? WHERE userID = " + cs4125.CS4125.loggedInUser.getID();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, Date.valueOf(newEndDate));
            preparedStatement.executeUpdate();
            close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean findUsername(String username) {
        boolean found = false;
        try {
            connection = DriverManager.getConnection(JDBC_URL);

            // Query
            statement = connection.createStatement();
            String query = "SELECT * "
                    + "FROM BeanSquadRentalDB.Users "
                    + "WHERE username = '" + username + "'";

            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                found = true;
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return found;
    }

    public boolean findEmail(String email) {
        boolean found = false;
        try {
            connection = DriverManager.getConnection(JDBC_URL);

            // Query
            statement = connection.createStatement();
            String query = "SELECT * "
                    + "FROM BeanSquadRentalDB.Users "
                    + "WHERE email = '" + email + "'";

            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                found = true;
            }
            close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return found;
    }

    public String getUsername(int userID) {
        String uname = "";

        try {
            connection = DriverManager.getConnection(JDBC_URL);

            //Query
            String query = "SELECT username FROM BeanSquadRentalDB.Users WHERE userID = " + userID;
            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                uname = resultSet.getString("username");
            }

            close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return uname;
    }

    public String getEmail(int userID) {
        String email = "";

        try {
            connection = DriverManager.getConnection(JDBC_URL);

            //Query
            String query = "SELECT email FROM BeanSquadRentalDB.Users WHERE userID = " + userID;
            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                email = resultSet.getString("email");
            }

            close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return email;
    }

    public void updateProfile(String newUsername, String newEmail, String newPassword) throws SQLException {

        try {
            connection = DriverManager.getConnection(JDBC_URL);
            String query = "UPDATE BeanSquadRentalDB.Users "
                    + "SET username = '" + newUsername + "' , email = '" + newEmail
                    + "' , password = PASSWORD( '" + newPassword + "' ) "
                    + "WHERE userID = " + cs4125.CS4125.loggedInUser.getID();
            System.out.println(query);
            statement = connection.createStatement();
            statement.executeUpdate(query);

            close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void addToHistory(Product selectedProduct, int tID, LocalDate sDate, LocalDate eDate) 
    {
        try 
        {
            connection = DriverManager.getConnection(JDBC_URL); 
            String query = "INSERT INTO BeanSquadRentalDB.History VALUES ("
                    + " default, ?, ?, ?, ?, ?, ?, default, default, default )";
            
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cs4125.CS4125.loggedInUser.getID());
            preparedStatement.setInt(2, selectedProduct.getOwner());
            preparedStatement.setInt(3, selectedProduct.getId());
            preparedStatement.setInt(4, tID);
            preparedStatement.setDate(5, Date.valueOf(sDate));
            preparedStatement.setDate(6, Date.valueOf(eDate));
            
            preparedStatement.executeUpdate();
            
            close();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public Product [] getHistory(int userID)
    {
        ArrayList<Product> products = new ArrayList<Product>();
        
        try 
        {
            connection = DriverManager.getConnection(JDBC_URL);
            statement = connection.createStatement();
            String query = "SELECT * "
                    + "FROM BeanSquadRentalDB.Products p "
                    + "WHERE p.pID IN (SELECT h.pID "
                    + "FROM History h "
                    + "WHERE h.rID = " + userID + " AND h.pID = p.pID);";
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

    @Override
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
