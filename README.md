# Cash Flow Minimizer

Automate your group payments with ease. Cash Flow Minimizer calculates net balances from direct transactions and shared bills, then generates the smallest set of settlements so that everyone ends up square. No more IOU chaos, just clean, clear transfers. ✨

## 🚀 Features

* **Net Balance Calculation**: tally who owes and who is owed after any mix of payments and shared expenses.
* **Expense Splitting**: one member pays a bill, the tool splits it equally among chosen participants.
* **Optimized Settlements**: pairs biggest debtors with biggest creditors using priority queues to minimize total transfers.
* **Simple OOP Design**: clear Java classes (`Bank`, `Transaction`, `CashFlowMinimizer`, `Main`) for easy understanding and extension.

## 🔧 Setup & Usage

1. Clone this repo.
2. Build with Java 8+.
3. Run `Main.java`.
4. Follow prompts to enter member names, direct payments, and shared bills.
5. View the list of minimized settlements.


## 📄 Example

```
Enter number of people: 3
Names: A B C
Direct: A B 100
Shared: 1; B pays 300 split among A,B,C

Final Settlements:
C pays Rs 100 to B
A pays Rs 100 to B
```

Built with ☕ and ❤️ by Aditya Patel.
