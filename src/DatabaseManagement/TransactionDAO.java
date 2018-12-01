/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin Grimes
 */
public class TransactionDAO implements DAO {

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

    public boolean checkCustomerFirstOrder(int customerID) {
        try {
            connection = DriverManager.getConnection(JDBC_URL);
            statement = connection.createStatement();
            String sql = "SELECT * BeanSquadRentalDB.RentalTransactions WHERE customerID = " + customerID + ";"; //check if this customer has rented a product before
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) { //as a renter they have previous transactions - not their first order
                return false;
            }
            return true; //no results - must be their first order
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addTransaction(int productID, int renterID, int leaserID, double amount,
            LocalDate startDate, LocalDate endDate, int lockerID, int lCode, int rCode) {
        try {
            // insert the transaction
            connection = DriverManager.getConnection(JDBC_URL);
            statement = connection.createStatement();
            String query = "INSERT INTO BeanSquadRentalDB.RentalTransactions "
                    + "VALUES( default, NOW(), default, " + amount + ", " + renterID + ", " + productID + " );";

            statement.executeUpdate(query);

            statement = connection.createStatement();
            query = "SELECT LAST_INSERT_ID() FROM BeanSquadRentalDB.RentalTransactions";
            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                int transactionID = resultSet.getInt(1);
                // insert into history

                query = "INSERT INTO BeanSquadRentalDB.History VALUES("
                        + "default, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, renterID);
                preparedStatement.setInt(2, leaserID);
                preparedStatement.setInt(3, productID);
                preparedStatement.setInt(4, transactionID);
                preparedStatement.setDate(5, Date.valueOf(startDate));
                preparedStatement.setDate(6, Date.valueOf(endDate));
                preparedStatement.setInt(7, lockerID);
                preparedStatement.setInt(8, lCode);
                preparedStatement.setInt(9, rCode);
                preparedStatement.executeUpdate();
            }

            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
