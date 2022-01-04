package atm.account;

public class Login {

    private Account account;

    public Login(Account account) {
        this.account = account;
    }

    public boolean isAuthenticated(String accountNumber, String pin) {
        return accountNumber.equals(account.getNumber()) && pin.equals(account.getPin());
    }


}
