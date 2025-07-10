import java.util.*;

public class CashFlowMinimizer {

    public static List<Transaction> minimizeCashFlow(
            List<Bank> banks,
            List<Transaction> transactions) {

        for (Transaction tx : transactions) {
            tx.getFrom().adjustBalance(-tx.getAmount());
            tx.getTo().adjustBalance(tx.getAmount());
        }

        PriorityQueue<Bank> debtors = new PriorityQueue<>(Comparator.comparingInt(Bank::getNetBalance));
        PriorityQueue<Bank> creditors = new PriorityQueue<>(Comparator.comparingInt(Bank::getNetBalance).reversed());

        for (Bank b : banks) {
            if (b.getNetBalance() < 0) debtors.add(b);
            else if (b.getNetBalance() > 0) creditors.add(b);
        }

        List<Transaction> result = new ArrayList<>();

        while (!debtors.isEmpty() && !creditors.isEmpty()) {
            Bank debtor = debtors.poll();
            Bank creditor = creditors.poll();
            int settle = Math.min(-debtor.getNetBalance(), creditor.getNetBalance());

            result.add(new Transaction(debtor, creditor, settle));

            debtor.adjustBalance(settle);
            creditor.adjustBalance(-settle);

            if (debtor.getNetBalance() < 0) debtors.add(debtor);
            if (creditor.getNetBalance() > 0) creditors.add(creditor);
        }

        return result;
    }
}