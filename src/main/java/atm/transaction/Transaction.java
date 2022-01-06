package atm.transaction;

public class Transaction {

    private String id;
    private String date;
    private TransactionType transactionType;

    public Transaction(String id, String date, TransactionType transactionType) {
        this.id = id;
        this.date = date;
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

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

}
