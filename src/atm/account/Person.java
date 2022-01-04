package atm.account;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String family;
    private String nationalCode;
    private List<Account> accounts;

    public Person() {
        accounts = new ArrayList<>();
    }

    public void setNationalCode(String nationalCode) {

        if (nationalCode.trim().length() > 10) {
            throw new RuntimeException("\"National Code\" couldn't have more then \"10\" characters!");
        }


        this.nationalCode = nationalCode;
    }


}
