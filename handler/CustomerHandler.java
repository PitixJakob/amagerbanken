package handler;

import db.DBConnector;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;
import model.Customer;

/**
 *
 * @author jakob
 */
public class CustomerHandler {

    private DBConnector db;
    private AccountHandler ah;

    public CustomerHandler() throws ClassNotFoundException, SQLException, IOException {
        db = DBConnector.getDB();
        ah = new AccountHandler();
    }

    public ArrayList<Customer> getCustomers(String searchName) throws SQLException, ClassNotFoundException, IOException {
        ArrayList<Customer> customers = new ArrayList<>();
        String stmt = "SELECT * FROM customer WHERE customer_name LIKE ?";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.setString(1, "%" + searchName + "%");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int cpr = rs.getInt("cpr");
            String name = rs.getString("customer_name");
            int phone = rs.getInt("phone");
            String email = rs.getString("email");
            String password = rs.getString("customer_password");
            ArrayList<Account> accounts = ah.getAccounts(cpr);
            customers.add(new Customer(cpr, name, phone, email, password, accounts));
        }
        rs.close();
        pst.close();
        return customers;
    }

    public boolean validateLogin(int cpr, char[] password) throws SQLException {
        String stmt = "SELECT customer.cpr, customer.customer_password FROM customer WHERE cpr=? AND customer_password=?";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.setInt(1, cpr);
        pst.setString(2, new String(password));
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            rs.close();
            pst.close();
            return true;
        }
        rs.close();
        pst.close();
        return false;

    }

    public Customer customerLogin(int cpr, char[] password) throws SQLException {
        if (validateLogin(cpr, password)) {
            Customer customer = null;
            String stmt = "SELECT * FROM customer WHERE cpr=?";
            PreparedStatement pst = db.getPrepStmt(stmt);
            pst.setInt(1, cpr);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int cprNum = rs.getInt("cpr");
                String name = rs.getString("customer_name");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String Userpassword = rs.getString("customer_password");
                ArrayList<Account> accounts = ah.getAccounts(cpr);
                customer = new Customer(cprNum, name, phone, email, Userpassword, accounts);
            }
            rs.close();
            pst.close();
            return customer;
        }
        return null;
    }
    
    public void addCustomer(int cpr, String name, int phone, String email, String password) throws SQLException{
        
        String stmt = "INSERT INTO customer (cpr, customer_name, phone, email, customer_password) VALUES (?,?,?,?,?)";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.setInt(1, cpr);
        pst.setString(2, name);
        pst.setInt(3, phone);
        pst.setString(4, email);
        pst.setString(5, password);
        pst.executeUpdate();
        pst.close();
    }
    
    public void updateCustomer(int cpr, String name, int phone, String email) throws SQLException{
        
        String stmt = "UPDATE customer SET name = ? WHERE cpr = ? ";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.setString(2, name);
        pst.setInt(1, cpr);
        pst.executeUpdate();
        pst.close();
        
        stmt = "UPDATE customer SET phone = ? WHERE cpr = ? ";
        pst = db.getPrepStmt(stmt);
        pst.setInt(3, phone);
        pst.setInt(1, cpr);
        pst.executeUpdate();
        pst.close();
        
        stmt = "UPDATE customer SET email = ? WHERE cpr = ? ";
        pst = db.getPrepStmt(stmt);
        pst.setString(4, email);
        pst.setInt(1, cpr);
        pst.executeUpdate();
        pst.close();
    }
}
