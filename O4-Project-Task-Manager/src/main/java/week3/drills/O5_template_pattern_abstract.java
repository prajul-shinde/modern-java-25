abstract class Report {
    // Abstract steps: Subclasses MUST implement these
    abstract void fetchData();

    abstract void formatData();

    // Template Method: Defines the workflow sequence
    public final void generate() {
        System.out.println("--- Starting Report Generation ---");
        fetchData();
        formatData();
        System.out.println("--- Report Completed ---\n");
    }
}

class SalesReport extends Report {
    @Override
    void fetchData() {
        System.out.println("Sales: Pulling transaction records from SQL Database...");
    }

    @Override
    void formatData() {
        System.out.println("Sales: Calculating total revenue and applying currency formatting.");
    }
}

class InventoryReport extends Report {
    @Override
    void fetchData() {
        System.out.println("Inventory: Scanning warehouse SKU counts from NoSQL cache...");
    }

    @Override
    void formatData() {
        System.out.println("Inventory: Categorizing items by 'In Stock', 'Low Stock', and 'Out of Stock'.");
    }
}

void main() {

    var sales = new SalesReport();
    var inventory = new InventoryReport();

    sales.generate();
    inventory.generate();
}