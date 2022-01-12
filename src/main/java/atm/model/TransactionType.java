package atm.model;

public enum TransactionType {


    DEPOSIT(0), WITHDRAW(1);

    private int value;

    TransactionType(int value) {
        this.value = value;
    }


}
