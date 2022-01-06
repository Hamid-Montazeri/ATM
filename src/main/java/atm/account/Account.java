package atm.account;

import atm.transaction.Transaction;
import atm.transaction.TransactionType;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public void withdraw(double amount) throws Exception {
        if (this.balance - amount < MIN_BALANCE) {
            throw new Exception("Entered amount is more than your balance! (Min balance is 20$)");
        }

        this.balance = (this.balance - amount);

        Transaction transaction = new Transaction(
                String.valueOf(new Random().nextInt(1000, 9000)),
                getDate(),
                TransactionType.WITHDRAW
        );

        transactionList.add(transaction);

    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;

        Transaction transaction = new Transaction(
                String.valueOf(new Random().nextInt(1000, 9000)),
                getDate(),
                TransactionType.DEPOSIT
        );

        transactionList.add(transaction);
    }

    private String getPersianDate() {
        ULocale locale = new ULocale("fa_IR@calendar=persian");
        Calendar calendar = Calendar.getInstance(locale);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return df.format(calendar);
    }

    private String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }

    @Override
    public String toString() {
        return String.format("Your Account Info:" + DASH_LINE + "Account Balance: %s$\nMin Balance: %s$\n------------------------------", balance, MIN_BALANCE);
    }


}
