package handler;

import db.DBConnector;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;
import model.Current;
import model.Customer;
import model.Saving;

/**
 *
 * @author jakob
 */
public class AccountHandler {

    private DBConnector db;

    public AccountHandler() throws ClassNotFoundException, SQLException, IOException {
        db = DBConnector.getDB();
    }

    public ArrayList<Account> getAccounts(int id) throws SQLException {
        ArrayList<Account> accounts = new ArrayList<>();
        String stmt = "SELECT * FROM account WHERE customer_id=?";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            int accountNumber = rs.getInt("account_number");
            int regNr = rs.getInt("reg_nr");
            long balance = rs.getLong("balance");
            double interest = rs.getDouble("interest");
            long overdraw = rs.getLong("overdraw");
            int accountType = rs.getInt("account_type");
            
            if (accountType == 1){
                accounts.add(new Current(accountNumber, regNr, balance, interest, overdraw));
            }
            if (accountType == 2){
                accounts.add(new Saving(accountNumber, regNr, balance, interest, overdraw));
            }
        }
        rs.close();
        pst.close();
        return accounts;
    }
}
