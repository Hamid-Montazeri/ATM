package atm.account;

import atm.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

import static atm.util.Constants.*;

public class Account {

    private String number;
    private String pin;
    private double balance;
    private AccountType accountType;
    private List<Transaction> transactionList;
    private Person person;

    public Account() {
        this.number = ACCOUNT_NUMBER;
        this.pin = ACCOUNT_PIN;
        this.balance = 1000;
        this.transactionList = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return String.format(DASH_LINE + "Account Balance: %s$\nMin Balance: %s$" + DASH_LINE, balance, MIN_BALANCE);
    }


}
