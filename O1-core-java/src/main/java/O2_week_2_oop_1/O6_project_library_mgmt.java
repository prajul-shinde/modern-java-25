import static java.lang.IO.println;

sealed interface LibraryItem permits Book, Magazine, DVD {

}

record Book(String isbn, String title, String author, int year) implements LibraryItem {

    Book {
        if (isbn == null || title == null || author == null)
            throw new IllegalArgumentException("Required fields are missing");
    }

}

record Magazine(String issn, String title, int issue, String month) implements LibraryItem {

}

record DVD(String id, String title, String director, int runtime) implements LibraryItem {

}

abstract class Member {
    String memberId;
    String name;
    List<LibraryItem> items;

    Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.items = new ArrayList<>();
    }

    abstract int maxBorrowLimit();

    boolean canBorrow() {
        return items.size() < maxBorrowLimit();
    }

    void borrowItem(LibraryItem item) {
        if (!canBorrow()) throw new IllegalArgumentException("max limit reached");
        items.add(item);
    }

    void returnItem(LibraryItem item) {
        items.remove(item);
    }

    void displayInfo() {
        String info = """
                Member Id: %s
                Name: %s
                Borrowed: %s
                """.formatted(memberId, name, items.size() + "/" + maxBorrowLimit());
        println(info);
    }
}

class RegularMember extends Member {

    RegularMember(String memberId, String name) {
        super(memberId, name);
    }

    @Override
    int maxBorrowLimit() {
        return 3;
    }
}

class PremiumMember extends Member {

    PremiumMember(String memberId, String name) {
        super(memberId, name);
    }

    @Override
    int maxBorrowLimit() {
        return 10;
    }
}

void main() {
    LibraryItem book = new Book("978-0-13-468599-1", "Effective Java", "Joshua Bloch", 2018);
    LibraryItem magazine = new Magazine("1234-5678", "Java Magazine", 42, "January");
    LibraryItem dvd = new DVD("DVD-001", "Java Tutorial", "John Doe", 120);

    Member regular = new RegularMember("M001", "Alice");
    Member premium = new PremiumMember("M002", "Bob");

    regular.borrowItem(book);
    premium.borrowItem(magazine);
    premium.borrowItem(dvd);

    regular.displayInfo();
    println();
    premium.displayInfo();

    println("\nItem Details:");
    for (LibraryItem item : List.of(book, magazine, dvd)) {
        String details = switch (item) {
            case Book(String isbn, String title, String author, int year) ->
                    "Book: '%s' by %s (%d)".formatted(title, author, year);
            case Magazine(String issn, String title, int issue, String month) ->
                    "Magazine: '%s' Issue #%d (%s)".formatted(title, issue, month);
            case DVD(String id, String title, String director, int runtime) ->
                    "DVD: '%s' directed by %s (%d min)".formatted(title, director, runtime);
        };
        println(details);
    }
}