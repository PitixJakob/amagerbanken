package bank;

import java.sql.SQLException;
import model.Bank;
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

}
