package model;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Current extends Account{

    public Current(int accountNumber, int regNr) {
        super(accountNumber, regNr);
    }
    
    public Current(int accountNumber, int regNr, long balance, double interest, long overdraw) {
        super(accountNumber, regNr, balance, interest, overdraw);
    }

    @Override
    public int getAccountType() {
        return 1;
    }
    
}
