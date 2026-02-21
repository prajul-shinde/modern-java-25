import static java.lang.IO.println;

void main() {
    Book book1 = new Book("1984", "George Orwell", 1949, 15.99);
    Book book2 = new Book("Clean Code", "Robert Martin", 2008, 42.50);

    println(book1);
    println("Is classic? " + book1.isClassic());
    println("10%% off: $%.2f".formatted(book1.discountedPrice(10)));

    println();

    println(book2);
    println("Is classic? " + book2.isClassic());
    println("20%% off: $%.2f".formatted(book2.discountedPrice(20)));
}

record Book(String title, String author, int year, double price) {
    Book {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("title cannot be blank");
        if (author == null || author.isBlank())
            throw new IllegalArgumentException("author cannot be blank");
        if (year < 1000 || year > 2100)
            throw new IllegalArgumentException("year must be 1000-2100");
        if (price <= 0)
            throw new IllegalArgumentException("price must be greater than 0");
        title = title.strip();
        author = author.strip();
    }

    boolean isClassic() {
        return year < 1950;
    }

    double discountedPrice(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage");
        }
        return price * (1 - percentage / 100);
    }
}