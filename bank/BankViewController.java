package bank;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;
import model.Bank;
import model.Current;
import model.Customer;

/**
 *
 * @author jakob
 */
public class BankViewController {
    private Bank bank;
    
    public BankViewController(Bank bank){
        this.bank = bank;
    }
    
    public Customer addCustomer(String name, String cpr, int phone, String email, String password) throws SQLException{
        bank.getCustomerHandler().addCustomer(name, cpr, phone, email, password);
        Customer c = new Customer(cpr, name, phone, email, password);
        bank.setCustomer(c);
        return c;
    }
    
    public void updateCustomer(String name, int phone, String email) throws SQLException{
        bank.getCustomerHandler().updateCustomer(bank.getCustomer().getCpr(), name, phone, email);
        bank.updateCustomer(name, phone, email);
    }
    
    public ArrayList<Customer> getCustomers(String searchTerm) throws SQLException, ClassNotFoundException, IOException{
        return bank.getCustomerHandler().getCustomers(searchTerm);
    }
    
    public Current getAccount(){
        return bank.getAccount();
    }
    
    public Current getCash(){
        return bank.getCash();
    }
    
    public void editInterest(Account account, double interest) throws SQLException {
        bank.getCustomerHandler().getAccountHandler().updateInterest(account, interest);
    }
    
    public void editOverdraw(Account account, long overdraw) throws SQLException {
        bank.getCustomerHandler().getAccountHandler().updateOverdraw(account, overdraw);
    }
    
    public void setCustomer(Customer c) {
        bank.setCustomer(c);
    }
    
    public void deposit(Account account, long amount) throws SQLException {
        bank.getCustomerHandler().getAccountHandler().deposit(bank.getAccount(), bank.getCash(), account, amount);
    }
    
    public void withdraw(Account account, long amount) throws SQLException {
        bank.getCustomerHandler().getAccountHandler().withdraw(bank.getAccount(), bank.getCash(), account, amount);
    }
    
    public void transfer(Account fromAccount, Account toAccount, long amount) throws SQLException {
        bank.getCustomerHandler().getAccountHandler().transfer(fromAccount, toAccount, amount);
    }
    
    public void addAccount(int accType, double interest, long overdraw, Customer customer) throws SQLException {
        bank.getCustomerHandler().getAccountHandler().addAccount(accType, interest, overdraw, customer);
    }
    
    public Customer getCustomer() {
        return bank.getCustomer();
    }
    
    public void depositCommit(Account account, long amount) throws SQLException {
        bank.getCustomerHandler().getAccountHandler().commitDeposit(bank.getAccount(), bank.getCash(), account, amount);
        System.out.println("DONE!");
    }
    
    public void withdrawCommit(Account account, long amount) throws SQLException {
        bank.getCustomerHandler().getAccountHandler().commitWithdraw(bank.getAccount(), bank.getCash(), account, amount);
    }
    
    public void transferCommit(Account from, Account to, long amount) throws SQLException {
        bank.getCustomerHandler().getAccountHandler().commitTransfer(from, to, amount);
    }
    
    public void rollback() throws SQLException {
        bank.getCustomerHandler().getAccountHandler().rollback();
    }
}
