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
        if (rs.next()){
            return true;
        }
        return false;
        
    }

    public Customer customerLogin(int cpr, char[] password) throws SQLException {
        if (validateLogin(cpr, password)) {
            String stmt = "SELECT * FROM customer WHERE cpr=?";
            PreparedStatement pst = db.getPrepStmt(stmt);
            pst.setInt(1, cpr);
            ResultSet rs = pst.executeQuery();
            
        }
    }
}
