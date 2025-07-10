package src;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to CASH FLOW MINIMIZER\n");

        System.out.print("Enter number of people: ");
        int n = scanner.nextInt();
        List<Bank> people = new ArrayList<>();
        System.out.println("Enter names of people:");
        for (int i = 0; i < n; i++) {
            System.out.print("Person " + i + ": ");
            people.add(new Bank(scanner.next()));
        }

        List<Transaction> transactions = new ArrayList<>();

        System.out.print("\nEnter number of direct transactions: ");
        int t = scanner.nextInt();
        System.out.println("Enter transactions (from to amount):");
        for (int i = 0; i < t; i++) {
            String from = scanner.next();
            String to = scanner.next();
            int amt = scanner.nextInt();
            Bank payer = find(people, from);
            Bank payee = find(people, to);
            transactions.add(new Transaction(payer, payee, amt));
        }

        System.out.print("\nEnter number of shared expenses: ");
        int e = scanner.nextInt();
        System.out.println("Enter shared expense (payer amount count participants...):");
        for (int i = 0; i < e; i++) {
            String payerName = scanner.next();
            int total = scanner.nextInt();
            int count = scanner.nextInt();
            List<Bank> group = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                group.add(find(people, scanner.next()));
            }
            int share = total / count;
            for (Bank member : group) {
                if (!member.getName().equals(payerName)) {
                    transactions.add(new Transaction(member, find(people, payerName), share));
                }
            }
        }

        List<Transaction> optimized = CashFlowMinimizer.minimizeCashFlow(people, transactions);
        System.out.println("\nFinal Settlements:");
        optimized.forEach(System.out::println);

        scanner.close();
    }

    private static Bank find(List<Bank> list, String name) {
        return list.stream()
                   .filter(b -> b.getName().equals(name))
                   .findFirst()
                   .orElseThrow(() -> new NoSuchElementException("Not found: " + name));
    }
}