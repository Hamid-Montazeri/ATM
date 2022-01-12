package atm.model;

public class Transaction {

    private String id;
    private String date;
    private double amount;
    private TransactionType transactionType;

    public Transaction(String id, String date, double amount, TransactionType transactionType) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.transactionType = transactionType;
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



}
