package atm.model;

import atm.util.DateConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public void withdraw(double amount) throws Exception {
        if (getBalance() - amount < MIN_BALANCE) {
            throw new Exception("Entered amount is more than your balance! (Min balance is 20$)");
        }
        setBalance(balance - amount);

        Transaction transaction = new Transaction(
                String.valueOf(new Random().nextInt(1000, 9999)),
                DateConverter.getPersianDate(),
                amount,
                TransactionType.WITHDRAW
        );

        transactionList.add(transaction);
    }

    public void deposit(double amount) {
        setBalance(getBalance() + amount);

        Transaction transaction = new Transaction(
                String.valueOf(new Random().nextInt(1000, 9999)),
                DateConverter.getPersianDate(),
                amount,
                TransactionType.DEPOSIT
        );
        transactionList.add(transaction);
    }

    @Override
    public String toString() {
        return String.format(DASH_LINE + "Account Balance: %s$\nMin Balance: %s$" + DASH_LINE, balance, MIN_BALANCE);
    }


}
