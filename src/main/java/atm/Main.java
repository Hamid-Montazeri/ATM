package atm;

import atm.model.ATM;


public class Main {

    private static ATM atm;

    public static void main(String[] args) {
        System.out.println("---------- Welcome ----------");

        atm = new ATM();
        atm.Login();

        try {
            atm.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
