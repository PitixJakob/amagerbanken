package model;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Saving extends Account{

    public Saving(long accountNumber, int regNr, long balance, double interest, long overdraw) {
        super(accountNumber, regNr, balance, interest, overdraw);
    }

    @Override
    public int getAccountType() {
        return 2;
    }

}
