package atm.account;

import java.util.Date;

public class Card {
    private String number;
    private String password;
    private Date expiryDate;
    private int ccv2;

    public Card() {
    }

    public Card(String number, String password, Date expiryDate, int ccv2) {
        this.number = number;
        this.password = password;
        this.expiryDate = expiryDate;
        this.ccv2 = ccv2;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCcv2() {
        return ccv2;
    }

    public void setCcv2(int ccv2) {
        this.ccv2 = ccv2;
    }
}
