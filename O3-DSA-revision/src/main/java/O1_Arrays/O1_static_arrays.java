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

    public void insertAtEnd(int element) {
        if (length < capacity) {
            arr[length] = element;
            length++;
        }
    }

    public void printArray() {
        print("[");
        for (var i = 0; i < length; i++)
            print(arr[i] + " ");
        print("]");
    }

    public void insertInMiddle(int index, int element) {
        if (index >= 0 && index <= length && length < capacity) {
            // move to right index 1 value = 15
            // [10 , 20 , 30]
            for (var i = length - 1; i >= index; i--)
                arr[i + 1] = arr[i];
            arr[index] = element;
            length++;
        }
    }

    public void removeFromEnd() {
        if (length > 0) {
            arr[length - 1] = 0;
            length--;
        }
    }

    public void removeMiddle(int index) {
        if (index >= 0 && index < length) {
            // move to left
            // [10 , 15, 20 , 30]
            for (var i = index; i < length; i++) {
                arr[i - 1] = arr[i];
            }
            length--;
            arr[index] = 0;

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
