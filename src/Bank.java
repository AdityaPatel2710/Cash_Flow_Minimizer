package src;
public class Bank {
    private final String name;
    private int netBalance;

    public Bank(String name) {
        this.name = name;
        this.netBalance = 0;
    }

    public String getName() {
        return name;
    }

    public int getNetBalance() {
        return netBalance;
    }

    public void adjustBalance(int amount) {
        this.netBalance += amount;
    }

    @Override
    public String toString() {
        return name;
    }
}