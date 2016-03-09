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
        AccountHandler ah = new AccountHandler();
    }

    public ArrayList<Customer> getCustomers(String searchName) throws SQLException, ClassNotFoundException, IOException {
        ArrayList<Customer> customers = new ArrayList<>();
        String stmt = "SELECT * FROM customer WHERE customer_name LIKE ?";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.setString(1, "%"+searchName+"%");
        System.out.println(pst);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("customer_name");
            int phone = rs.getInt("phone");
            String email = rs.getString("email");
            String username = rs.getString("username");
            String password = rs.getString("customer_password");
            ArrayList<Account> accounts = ah.getAccounts(id);
            
            customers.add(new Customer(name, phone, email, username, password, accounts));
        }
        rs.close();
        pst.close();
        return customers;
    }
}
