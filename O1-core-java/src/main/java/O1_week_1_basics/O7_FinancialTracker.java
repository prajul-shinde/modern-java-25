import static java.lang.IO.*;


void main() {
    println("Welcome to Finance tracker app");

    boolean running = true;
    while (true) {
        String menu = """
                1. Add Transaction
                2. View Report
                3. View Statistics
                4. Exit
                """;
        print(menu);
        int choice = Integer.parseInt(readln("Choose an option: "));
        switch (choice) {
            case 1 -> addTransaction();
            case 2 -> viewReport();
            case 3 -> viewStatistics();
            case 4 -> running = false;
            default -> println("Invalid choice");
        }

    }
}

private void viewStatistics() {
    if (transactions.isEmpty()) {
        println("No Data available");
        return;
    }
    double totalIncome = 0.0;
    double totalExpenses = 0.0;
    for (var transaction : transactions) {
        if (transaction.amount > 0) totalIncome += transaction.amount;
        else totalExpenses += transaction.amount;
    }
    double balance = totalIncome + totalExpenses;
    String report = """
            
            ========= SUMMARY =========
            Total Income : %.2f
            Total Expense: %.2f
            Net Balance  : %.2f
            ===========================
            """.formatted(totalIncome, totalExpenses, balance);

    System.out.println(report);
}

private void viewReport() {
    if (transactions.isEmpty()) {
        println("There are no transactions.");
        return;
    }
    println("=====Finance Report=====");
    String report = """
            %-10s %-15s %-15s
            """.formatted("Amount", "Category", "Description");
    print(report);
    transactions.forEach(transaction -> {
        String txn = """
                %-10.2f %-15s %-30s
                """.formatted(transaction.amount, transaction.category, transaction.description);
        println(txn);
    });
}

private void addTransaction() {
    var amount = Double.parseDouble(readln("Enter an amount: "));
    var category = readln("Enter a category: ");
    var description = readln("Enter description: ");
    transactions.add(new TranscationDetail(amount, category, description));
    println("Successfully added transaction ");
}

record TranscationDetail(double amount, String category, String description) {
}

List<TranscationDetail> transactions = new ArrayList<>();
