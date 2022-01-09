package atm.util;

import atm.account.Account;
import atm.transaction.Transaction;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static atm.util.Constants.DASH_LINE;

public class MenuHandler {

    private static final Account account = new Account();
    private static final Scanner input = new Scanner(System.in);

    public static int showMainMenu() throws Exception {
        System.out.println("Main Menu:\n1- View My Balance\n2- Withdraw Cash\n3- Deposit Funds\n4- Last 10 Transactions\n5- Exit");
        System.out.print("Choose 1 ~ 5: ");

        int anInt = input.nextInt();

        if (anInt > 0 && anInt < 6) {
            return anInt;
        } else {
            throw new Exception("Wrong Menu Item. Try Again!");
        }
    }

    public static void handleMenuInput(int menuInput) {
        switch (menuInput) {
            // 1- View balance
            // 2- Withdraw Cash
            // 3- Deposit Funds
            // 4- Display last 10 trx
            // 5- Exit
            case 1 -> System.err.println(DASH_LINE + "Your Balance is: \"" + account.getBalance() + "$\"" + DASH_LINE);
            case 2 -> withdrawCash();
            case 3 -> depositFund();
            case 4 -> showLast10Transactions();
            case 5 -> {
                System.err.println("Have a Good Day! \u270B\uFE0F");
//                System.err.println("Have a Good Day! \uD83D\uDC4B");
                System.exit(0);
            }
        }
    }

    private static void withdrawCash() {
        System.err.print("Enter \"Withdraw Amount\":");
        double amount = input.nextDouble();
        try {
            Transaction transaction = new Transaction(account);
            transaction.withdraw(amount);
            account.getTransactionList().add(transaction);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(account);
    }

    private static void depositFund() {
        System.err.print("Enter \"Deposit Amount\":");
        double amount = input.nextDouble();
        Transaction transaction = new Transaction(account);
        transaction.deposit(amount);
        account.getTransactionList().add(transaction);
        System.out.println(account);
    }

    private static void showLast10Transactions() {
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
