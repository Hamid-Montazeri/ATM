package atm.transaction;

import atm.account.Account;
import atm.util.DateConverter;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static atm.util.Constants.MIN_BALANCE;

public class Transaction {

    private String id;
    private String date;
    private double amount;
    private TransactionType transactionType;
    private Account account;

    public Transaction(Account account) {
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void withdraw(double amount) throws Exception {
        if (account.getBalance() - amount < MIN_BALANCE) {
            throw new Exception("Entered amount is more than your balance! (Min balance is 20$)");
        }
        setId(String.valueOf(new Random().nextInt(1000, 9999)));
        setDate(getCurrentDate());
        setTransactionType(TransactionType.WITHDRAW);
        setAmount(amount);
        account.setBalance(account.getBalance() - amount);
    }

    public void deposit(double amount) {
        setId(String.valueOf(new Random().nextInt(1000, 9999)));
        setDate(getCurrentDate());
        setTransactionType(TransactionType.DEPOSIT);
        setAmount(amount);
        account.setBalance(account.getBalance() + amount);
    }

    private String getPersianDate() {
        ULocale locale = new ULocale("fa_IR@calendar=persian");
        Calendar calendar = Calendar.getInstance(locale);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return df.format(calendar);
    }

    private String getCurrentDate() {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));
        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
        int[] params = DateConverter.gregorian_to_jalali(year, monthValue, dayOfMonth);
        String outputDate = String.format("%s/%s/%s - %s:%s:%s", params[0], params[1], params[2], now.getHour(), now.getMinute(), now.getSecond());
        return (outputDate);
    }


}
