public class Transaction {
    private final Bank from;
    private final Bank to;
    private final int amount;

    public Transaction(Bank from, Bank to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public Bank getFrom() {
        return from;
    }

    public Bank getTo() {
        return to;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s pays Rs %d to %s", 
                from.getName(), amount, to.getName());
    }
}
