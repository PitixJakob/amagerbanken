package model;

/**
 *
 * @author Morten Ricki Rasmussen
 */
public class Current extends Account {

    public Current(long accountNumber, int regNr) {
        super(accountNumber, regNr);
    }

    public Current(long accountNumber, int regNr, long balance, double interest, long overdraw) {
        super(accountNumber, regNr, balance, interest, overdraw);
    }

    @Override
    public int getAccountType() {
        return 1;
    }

}
