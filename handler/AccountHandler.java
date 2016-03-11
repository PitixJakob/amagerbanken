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

    public void addAccount(int accountType, double interest, long overdraw, Customer customer) throws SQLException {
        String stmt = "SELECT account.account_number FROM account ORDER BY account_number DESC LIMIT 1";
        PreparedStatement pst = db.getPrepStmt(stmt);
        ResultSet rs = pst.executeQuery();
        int prevAccountNumber = 0;
        while (rs.next()) {
            prevAccountNumber = rs.getInt("account_number");
        }
        pst.close();
        if (prevAccountNumber != 0) {
            stmt = "INSERT INTO account (account_number, account_type, interest, overdraw, customer_cpr) VALUES (?, ?, ?, ?, ?)";
            pst = db.getPrepStmt(stmt);
            pst.setInt(1, prevAccountNumber+1);
            pst.setInt(2, accountType);
            pst.setDouble(3, interest);
            pst.setLong(4, overdraw);
            pst.setString(5, customer.getCpr());
            pst.executeUpdate();
            if (accountType == 1){
                customer.addAccount(new Current(prevAccountNumber+1, 4700, 0, interest, overdraw));
            }
            if (accountType == 2){
                customer.addAccount(new Saving(prevAccountNumber+1, 4700, 0, interest, overdraw));
            }
        }
        rs.close();
        pst.close();
    }

    public ArrayList<Account> getAccounts(String cpr) throws SQLException {
        ArrayList<Account> accounts = new ArrayList<>();
        String stmt = "SELECT * FROM account WHERE customer_cpr=?";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.setString(1, cpr);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int accountType = rs.getInt("account_type");
            int accountNumber = rs.getInt("account_number");
            int regNr = rs.getInt("reg_nr");
            long balance = rs.getLong("balance");
            double interest = rs.getDouble("interest");
            long overdraw = rs.getLong("overdraw");
            if (accountType == 1) {
                accounts.add(new Current(accountNumber, regNr, balance, interest, overdraw));
            }
            if (accountType == 2) {
                accounts.add(new Saving(accountNumber, regNr, balance, interest, overdraw));
            }
        }
        rs.close();
        pst.close();
        return accounts;
    }

    public void deposit(Account bankAccount, Account cashAccount, Account userAccount, long amount) throws SQLException {
        if (bankAccount.getBalance() - amount >= 0) {
            begin();
            String stmt = "UPDATE account SET balance = balance - ? WHERE account_number = ?";
            PreparedStatement pst = db.getPrepStmt(stmt);
            pst.setLong(1, amount);
            pst.setInt(2, bankAccount.getAccountNumber());
            pst.executeUpdate();
            pst.close();
            stmt = "UPDATE account SET balance = balance + ? WHERE account_number = ?";
            pst = db.getPrepStmt(stmt);
            pst.setLong(1, amount);
            pst.setInt(2, cashAccount.getAccountNumber());
            pst.executeUpdate();
            pst.close();
            stmt = "UPDATE account SET balance = balance + ? WHERE account_number = ?";
            pst = db.getPrepStmt(stmt);
            pst.setLong(1, amount);
            pst.setInt(2, userAccount.getAccountNumber());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void withdraw(Account bankAccount, Account cashAccount, Account userAccount, long amount) throws SQLException {
        if (userAccount.getBalance() - amount >= -userAccount.getOverdraw()) {
            begin();
            String stmt = "UPDATE account SET balance = balance + ? WHERE account_number = ?";
            PreparedStatement pst = db.getPrepStmt(stmt);
            pst.setLong(1, amount);
            pst.setInt(2, bankAccount.getAccountNumber());
            pst.executeUpdate();
            pst.close();
            stmt = "UPDATE account SET balance = balance - ? WHERE account_number = ?";
            pst = db.getPrepStmt(stmt);
            pst.setLong(1, amount);
            pst.setInt(2, cashAccount.getAccountNumber());
            pst.executeUpdate();
            pst.close();
            stmt = "UPDATE account SET balance = balance - ? WHERE account_number = ?";
            pst = db.getPrepStmt(stmt);
            pst.setLong(1, amount);
            pst.setInt(2, userAccount.getAccountNumber());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void transfer(Account fromAccount, Account toAccount, long amount) throws SQLException {
        if (fromAccount.getBalance() - amount >= -fromAccount.getOverdraw()) {
            begin();
            String stmt = "UPDATE account SET balance = balance - ? WHERE account_number = ?";
            PreparedStatement pst = db.getPrepStmt(stmt);
            pst.setLong(1, amount);
            pst.setInt(2, fromAccount.getAccountNumber());
            pst.executeUpdate();
            pst.close();
            stmt = "UPDATE account SET balance = balance + ? WHERE account_number = ?";
            pst = db.getPrepStmt(stmt);
            pst.setLong(1, amount);
            pst.setInt(2, toAccount.getAccountNumber());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void updateInterest(Account account, double newInterest) throws SQLException {
        String stmt = "UPDATE account SET interest=? WHERE account_number=?";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.setDouble(1, newInterest);
        pst.setInt(2, account.getAccountNumber());
        pst.executeUpdate();
        account.setInterest(newInterest);
        pst.close();

    }

    public void updateOverdraw(Account account, long newOverdraw) throws SQLException {
        String stmt = "UPDATE account SET overdraw=? WHERE account_number=?";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.setLong(1, newOverdraw);
        pst.setInt(2, account.getAccountNumber());
        pst.executeUpdate();
        account.setOverdraw(newOverdraw);
        pst.close();
    }

    public void begin() throws SQLException {
        String stmt = "BEGIN";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.execute();
        pst.close();
    }

    public void commitDeposit(Account bankAccount, Account cashAccount, Account userAccount, long amount) throws SQLException {
        String stmt = "COMMIT";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.execute();
        pst.close();
        bankAccount.withdraw(amount);
        cashAccount.deposit(amount);
        userAccount.deposit(amount);
    }

    public void commitWithdraw(Account bankAccount, Account cashAccount, Account userAccount, long amount) throws SQLException {
        String stmt = "COMMIT";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.execute();
        pst.close();
        bankAccount.deposit(amount);
        cashAccount.withdraw(amount);
        userAccount.withdraw(amount);
    }

    public void commitTransfer(Account fromAccount, Account toAccount, long amount) throws SQLException {
        String stmt = "COMMIT";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.execute();
        pst.close();
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public void rollback() throws SQLException {
        String stmt = "ROLLBACK";
        PreparedStatement pst = db.getPrepStmt(stmt);
        pst.execute();
        pst.close();
    }
}
