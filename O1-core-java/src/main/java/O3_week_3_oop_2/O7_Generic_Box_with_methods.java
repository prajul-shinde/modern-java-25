void main() {

    Box<String> box1 = Box.of("Hello");
    Box<String> box2 = Box.of("World");

    System.out.println(box1);
    System.out.println(box2);

    box1.swap(box2);
    System.out.println("After swap:");
    System.out.println(box1);
    System.out.println(box2);

    System.out.println("Same content? " + box1.sameContent(box2));

    Box<Integer> intBox = Box.of(42);
    System.out.println("Empty? " + intBox.isEmpty());
}

static class Box<T> {

    private T item;

    Box(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    boolean isEmpty() {
        return item == null;
    }

    void swap(Box<T> other) {
        T currentItem = other.getItem();
        other.item = this.item;
        this.item = currentItem;
    }

    boolean sameContent(Box<T> other) {
        if (this.item == null) return other.item == null;
        return other.item.equals(this.item);
    }

    static <T> Box<T> of(T item) {
        return new Box<>(item);
    }

    @Override
    public String toString() {
        return "Box{" +
                "item=" + item +
                '}';
    }
}