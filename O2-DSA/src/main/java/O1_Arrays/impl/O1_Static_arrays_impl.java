import static java.lang.IO.print;
import static java.lang.IO.println;

class StaticArray {

    private int[] arr;
    private int length;
    private int capacity;

    public StaticArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.length = 0;
    }

    public void printArray() {

        println("Array length %d and capacity %d".formatted(length, capacity));
        print("[");
        for (var i = 0; i < length; i++)
            print(arr[i] + " ");
        print("]");
    }

    public void insertAtEnd(int number) {

        if (length < capacity) {
            arr[length] = number;
            length++;
        }
    }

    public void insertInMiddle(int index, int number) {
        //  0 1 2 3   length = 4 we can insert at index 4 as long as it's less than capacity
        if (index >= 0 && index <= length && length < capacity) {
            // shift elements to right
            for (var i = length - 1; i >= index; i--) {
                arr[i + 1] = arr[i];
            }
            arr[index] = number;
            length++;
        }
    }

    public void removeMiddle(int index) {

        // 0 1 2 3 cannot remove from index 4 length is 4 that's why <
        if (index >= 0 && index < length) {
            // shift elements to left
            for (var i = index + 1; i < length; i++) {
                arr[i - 1] = arr[i];
            }
            length--;
            arr[length] = 0;
        }
    }

    public void removeFromEnd() {
        if (length > 0) {
            arr[length - 1] = 0;
            length--;
        }
    }
}

void main() {
    StaticArray myList = new StaticArray(5);

    // 2. Test insertEnd
    println("--- Inserting 10, 20, 30 at end ---");
    myList.insertAtEnd(10);
    myList.insertAtEnd(20);
    myList.insertAtEnd(30);
    myList.printArray();

    // 3. Test insertMiddle (Insert 15 at index 1)
    // This should push 20 and 30 to the right
    println("\n--- Inserting 15 at index 1 ---");
    myList.insertInMiddle(1, 15);
    myList.printArray();

    // 4. Test removeMiddle (Remove index 2 - which is the value 20)
    // This should pull 30 to the left
    println("\n--- Removing element at index 2 ---");
    myList.removeMiddle(2);
    myList.printArray();

    // 5. Test removeEnd
    println("\n--- Removing from end ---");
    myList.removeFromEnd();
    myList.printArray();
}