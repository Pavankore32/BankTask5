import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account("Pavan Kore", "ACC1001", 1000.0);

        while (true) {
            System.out.println("\nChoose: 1-deposit  2-withdraw  3-balance  4-statement  5-exit");
            System.out.print("Enter choice: ");
            String c = sc.next();
            if (c.equals("1")) {
                System.out.print("Amount to deposit: ");
                double amt = sc.nextDouble();
                acc.deposit(amt);
            } else if (c.equals("2")) {
                System.out.print("Amount to withdraw: ");
                double amt = sc.nextDouble();
                acc.withdraw(amt);
            } else if (c.equals("3")) {
                System.out.println("Balance: " + acc.getBalance());
            } else if (c.equals("4")) {
                acc.printStatement();
            } else if (c.equals("5")) {
                System.out.println("Exiting. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
