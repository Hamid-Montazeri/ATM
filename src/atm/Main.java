package atm;

import atm.account.Account;
import atm.account.Login;
import atm.util.Constants;

import java.util.Scanner;

import static atm.util.Constants.*;


public class Main {

    private static final Account account = new Account();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("----------Welcome----------");

        while (true) {
            // get account number from user
            System.out.println("Please Enter your \"Account Number\" (Default -> 12345):");
            String enteredAccountNumber = input.nextLine();

            // get account PIN from user
            System.out.println("Please Enter your \"PIN\"(Default -> 54321):");
            String enteredPin = input.nextLine();

            // check user authentication
            Login login = new Login(account);
            boolean isUserAuthenticated = login.isAuthenticated(enteredAccountNumber, enteredPin);

            // welcome user if authenticated
            if (isUserAuthenticated) {
                System.out.println(DASH_LINE + "You Entered Successfully" + DASH_LINE);
                break;
            } else {
                System.err.println(DASH_LINE + "Wrong Parameters!" + DASH_LINE);
            }
        }

        System.out.println(account);

        int menuInput = 0;
        do {
            try {
                menuInput = showMainMenu();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            handleMenuInput(menuInput);
        }
        while (menuInput > 0 && menuInput < 4);

    }

    public static int showMainMenu() throws Exception {
        System.out.println("Main Menu:\n1- View My Balance\n2- Withdraw Cash\n3- Deposit Funds\n4- Exit");
        System.out.print("Choose 1 ~ 4: ");
        int anInt = input.nextInt();
        if (anInt < 0 || anInt > 4) {
            throw new Exception("Just Select One of Above!");
        }
        return anInt;
    }

    public static void handleMenuInput(int menuInput) {
        switch (menuInput) {
            // 1- View balance
            // 2- Withdraw Cash
            // 3- Deposit Funds
            // 4- Exit
            case 1 -> System.out.println(DASH_LINE + "Your Balance is: \"" + account.getBalance() + "$\"" + DASH_LINE);
            case 2 -> withdrawCash();
            case 3 -> depositFund();
            case 4 -> System.exit(0);
        }
    }

    private static void depositFund() {
        System.out.println("Enter \"Deposit Amount\":");
        double amount = input.nextDouble();
        account.deposit(amount);
        System.out.println(account);
    }

    private static void withdrawCash() {
        System.out.println("Enter \"Withdraw Amount\":");
        double amount = input.nextDouble();
        try {
            account.withdraw(amount);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(account);
    }


}
