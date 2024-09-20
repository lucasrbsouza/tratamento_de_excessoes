import model.entities.Account;
import model.exeception.DomainException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            String holder = sc.next();
            System.out.print("Initial balancer: ");
            double balancer = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account conta = new Account(number, holder, balancer, withdrawLimit);


            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            conta.withdraw(amount);
            System.out.println("New balance: " + conta.getBalancer());

        } catch (DomainException e) {
            System.out.println("\033[0;31m" + "Withdraw error: " + e.getMessage() + "\033[0m");
        } catch (InputMismatchException e) {
            System.out.println("\033[0;31m" + "Numero invalido" + "\033[0m");
        }

    }
}
