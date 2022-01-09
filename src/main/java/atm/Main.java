package atm;

import atm.account.Account;
import atm.account.Login;
import atm.util.MenuHandler;

import java.util.Scanner;

import static atm.util.Constants.DASH_LINE;


public class Main {

    private static final Account account = new Account();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("---------- Welcome ----------");

        while (true) {
            // get account number from user
            System.out.println("Please Enter your \"Account Number\"(Default -> 12345):");
            String enteredAccountNumber = input.nextLine();

            // get account PIN from user
            System.out.println("Please Enter your \"PIN\"(Default -> 54321):");
            String enteredPin = input.nextLine();

            // check user authentication
            Login login = new Login(account);
            boolean isUserAuthenticated = login.checkAuthentication(enteredAccountNumber, enteredPin);

            // welcome user if authenticated
            if (isUserAuthenticated) {
                System.err.println(DASH_LINE + "You Entered Successfully" + DASH_LINE);
                break;
            } else {
                System.err.println(DASH_LINE + "Wrong Parameters!" + DASH_LINE);
            }
        }

        System.out.println(account);

        int menuInput = 0;
        do {
            try {
                menuInput = MenuHandler.showMainMenu();
            } catch (Exception e) {
                System.err.println(e.getLocalizedMessage());
            }
            MenuHandler.handleMenuInput(menuInput);
        }
        while (menuInput > 0 && menuInput < 6);

    }


}
