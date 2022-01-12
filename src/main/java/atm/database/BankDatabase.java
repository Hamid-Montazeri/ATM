package atm.database;

import atm.model.Account;

import java.util.List;

public class BankDatabase {

    private static BankDatabase bankDatabase;
    private List<Account> accounts;

    private BankDatabase() {
    }

    // constructor
    public static BankDatabase getInstance() {
        if (bankDatabase == null) {
            return new BankDatabase();
        }
        return bankDatabase;
    }




}
