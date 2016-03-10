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
    
    public void addCustomer(String cpr, String name, int phone, String email, String password) throws SQLException{
        bank.getCustomerHandler().addCustomer(cpr, name, phone, email, password);
        bank.setCustomer(new Customer(cpr, name, phone, email, password));
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
    
    

}
