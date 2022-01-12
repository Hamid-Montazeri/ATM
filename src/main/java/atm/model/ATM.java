package atm.model;

import atm.database.BankDatabase;

import java.util.List;
import java.util.Scanner;

import static atm.util.Constants.DASH_LINE;

public class ATM {

    private BankDatabase bankDatabase;

    private Account account;
    private Scanner input;

    public ATM() {
        this.bankDatabase = BankDatabase.getInstance();
        this.account = new Account();
        this.input = new Scanner(System.in);
    }

    public void Login() {

        while (true) {
            // get account number from user
            System.out.println("Please Enter your \"Account Number\"(Default -> 12345):");
            String enteredAccountNumber = input.nextLine();

            // get account PIN from user
            System.out.println("Please Enter your \"PIN\"(Default -> 54321):");
            String enteredPin = input.nextLine();

            // check user authentication
            Login login = new Login(account);
            boolean isAuthenticated = login.checkAuthentication(enteredAccountNumber, enteredPin);

            // welcome user if authenticated
            if (isAuthenticated) {
                System.err.println(DASH_LINE + "You Entered Successfully" + DASH_LINE);
                break;
            } else {
                System.err.println(DASH_LINE + "Wrong Parameters!" + DASH_LINE);
            }
        }

        System.out.println(account);
    }

    public void run() throws Exception {
        int menuInput;

        do {
            System.out.println("Main Menu:\n1- View My Balance\n2- Withdraw Cash\n3- Deposit Funds\n4- Last 10 Transactions\n5- Exit");
            System.out.print("Choose 1 ~ 5: ");

            menuInput = input.nextInt();
            handleMenuInput(menuInput);

        } while (menuInput > 0 && menuInput < 6);

    }

    public void handleMenuInput(int menuInput) throws Exception {
        switch (menuInput) {
            // 1- View balance
            // 2- Withdraw Cash
            // 3- Deposit Funds
            // 4- Display last 10 trx
            // 5- Exit
            case 1 -> System.err.println(DASH_LINE + "Your Balance is: \"" + account.getBalance() + "$\"" + DASH_LINE);
            case 2 -> withDraw();
            case 3 -> deposit();
            case 4 -> showLast10Transactions();
            case 5 -> {
                System.err.println("Have a Good Day! \u270B\uFE0F");
                System.exit(0);
            }
        }
    }

    private void withDraw() throws Exception {
        System.err.print("Enter \"WITHDRAW\" Amount: ");
        account.withdraw(input.nextDouble());
    }

    private void deposit() {
        System.err.print("Enter \"DEPOSIT\" Amount: ");
        account.deposit(input.nextDouble());
    }

    private void showLast10Transactions() {
        List<Transaction> transactionList = account.getTransactionList();
        if (transactionList.size() < 1) {
            System.err.println(DASH_LINE + "NO TRANSACTIONS!" + DASH_LINE);
        } else {
            System.err.println(DASH_LINE + "Number of Transactions: " + transactionList.size() + DASH_LINE);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < transactionList.size(); i++) {
                String id = transactionList.get(i).getId();
                String date = transactionList.get(i).getDate();
                String trxType = transactionList.get(i).getTransactionType().toString();
                double amount = transactionList.get(i).getAmount();
                String output = String.format("Transaction \"%s\":\nTransaction ID: %s\nTransaction Type: %s\nAmount: %s$\nDate: %s", i + 1, id, trxType, amount, date);
                System.out.println(output + DASH_LINE);
            }
        }
    }

}
