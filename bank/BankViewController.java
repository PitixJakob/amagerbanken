package bank;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    

}
