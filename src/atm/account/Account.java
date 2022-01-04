package atm.account;

import static atm.util.Constants.*;

public class Account {

    private String number;
    private String pin;
    private double balance;
    private AccountType accountType;
    private Person person;

    public Account() {
        this.number = ACCOUNT_NUMBER;
        this.pin = ACCOUNT_PIN;
        this.balance = 1000;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void withdraw(double amount) throws Exception {
        if (balance - amount < MIN_BALANCE) {
            throw new Exception("Entered amount is more than your balance! (Min balance is 20$)");
        }
        balance = balance - amount;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    @Override
    public String toString() {
        return String.format("Your Account Info:" + DASH_LINE + "Account Balance: %s$\nMin Balance: %s$\n------------------------------", balance, MIN_BALANCE);
    }


}
