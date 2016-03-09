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
            String username = rs.getString("username");
            String password = rs.getString("customer_password");
            ArrayList<Account> accounts = ah.getAccounts(cpr);
            customers.add(new Customer(cpr, name, phone, email, username, password, accounts));
        }
        rs.close();
        pst.close();
        return customers;
    }

    public boolean validateLogin(String username, char[] password) throws SQLException {
        String stmt = "SELECT customer.username, customer.customer_password FROM customer WHERE username=? AND customer_password=?";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.setString(1, username);
        pst.setString(2, new String(password));
        ResultSet rs = pst.executeQuery();
        if (rs.next()){
            return true;
        }
        return false;
        
    }

    public Customer customerLogin(String username, char[] password) throws SQLException {
        if (validateLogin(username, password)) {
            String stmt = "SELECT * FROM customer WHERE username=?";
            PreparedStatement pst = db.getPrepStmt(stmt);
            pst.setString(1, username);
            
        }
    }
}
