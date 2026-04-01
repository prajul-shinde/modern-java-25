import static java.lang.IO.print;
import static java.lang.IO.println;

class DynamicArray {

    private int[] arr;
    private int length;
    private int capacity;

    public DynamicArray() {
        this.capacity = 2;
        this.arr = new int[this.capacity];
        this.length = 0;
    }

    public void printArray() {
        print("[");
        for (var i = 0; i < length; i++)
            print(arr[i] + " ");
        print("]");
    }

    public void insertAtEnd(int element) {
        if (length == capacity)
            resize();
        arr[length] = element;
        length++;
    }

    private void resize() {
        this.capacity = 2 * this.capacity;
        int[] newArray = new int[this.capacity];
        for (var i = 0; i < arr.length; i++)
            newArray[i] = arr[i];
        this.arr = newArray;
        println("capacity doubled to %d".formatted(this.capacity));
    }

    public void insertInMiddle(int index, int element) {
        if (index >= 0 && index <= length) {
            if (length == capacity)
                resize();
            // shift to right
            for (var i = length - 1; i >= index; i--) {
                arr[i + 1] = arr[i];
            }
            arr[index] = element;
            length++;
        }
    }

    public void removeMiddle(int index) {
        if (index >= 0 && index < length) {
            //shift left
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

    public int get(int index) {
        if (index >= 0 && index < length) {
            return arr[index];
        }
        return -1;
    }
}

void main() {

    DynamicArray myList = new DynamicArray();

    println("--- Testing Pushback and Auto-Resize ---");
    myList.insertAtEnd(10);
    myList.insertAtEnd(20);
    myList.printArray();

    println("\n--- This insert should trigger a resize ---");
    myList.insertAtEnd(30);
    myList.printArray();

    println("\n--- Testing Middle Insertion with Resize ---");
    // Currently length 3, capacity 4. Adding one more...
    myList.insertAtEnd(40);
    // Now full (4/4). Inserting at index 1 should trigger resize.
    myList.insertInMiddle(1, 15);
    myList.printArray();

    println("\n--- Testing Removal ---");
    myList.removeMiddle(2); // Removes 20
    myList.printArray();

    println("\n--- Testing remove from end");
    myList.removeFromEnd();
    myList.printArray();
}