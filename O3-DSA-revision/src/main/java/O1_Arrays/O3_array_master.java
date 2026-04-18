import static java.lang.IO.print;
import static java.lang.IO.println;

class ArrayMaster {

    public void printArr(String label, int[] arr, int length) {
        print(label + "[");
        for (var i = 0; i < length; i++) {
            print(arr[i] + " ");
        }
        print("]");
    }

    public int removeElement(int[] arr, int val) {
        int writer = 0;
        for (var reader = 0; reader < arr.length; reader++) {
            if (arr[reader] != val) {
                arr[writer] = arr[reader];
                writer++;
            }
        }
        return writer;
    }

    public void reverse(int[] arr) {
        var left = 0;
        var right = arr.length - 1;
        while (left < right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }

    public boolean isSorted(int[] arr) {
        if (arr.length == 0)
            return true;
        for (var i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    public int removeDuplicates(int[] arr) {
        if (arr.length == 0)
            return 0;
        int writer = 1;
        for (var reader = 1; reader < arr.length; reader++) {
            if (arr[reader] != arr[reader - 1]) {
                arr[writer] = arr[reader];
                writer++;
            }
        }
        return writer;
    }

    public int[] shuffle(int[] arr, int n) {
        // 5. Shuffle the array [x1, x2, y1, y2] -> [x1, y1, x2, y2]
        int[] result = new int[2 * n];
        for (var i = 0; i < n; i++) {
//            {1, 2, 3, 4, 4, 3, 2, 1};
            result[2 * i] = arr[i];
            result[2 * i + 1] = arr[n + i];
        }
        return result;
    }
}

void main() {
    ArrayMaster lab = new ArrayMaster();

    // --- Test 1: Remove Element ---
    int[] task1 = {3, 2, 2, 3};
    int k1 = lab.removeElement(task1, 3);
    lab.printArr("1. Remove Element (val=3)", task1, k1);

    // --- Test 2: Reverse ---
    int[] task2 = {1, 2, 3, 4, 5};
    lab.reverse(task2);
    lab.printArr("2. Reverse Array", task2, task2.length);

    // --- Test 3: Is Sorted ---
    int[] task3 = {10, 20, 30, 25};
    println("3. Is Sorted? " + lab.isSorted(task3));

    // --- Test 4: Remove Duplicates ---
    int[] task4 = {1, 1, 2, 2, 3, 3, 3};
    int k4 = lab.removeDuplicates(task4);
    lab.printArr("4. Unique Elements", task4, k4);

    // --- Test 5: Shuffle ---
    int[] task5 = {1, 2, 3, 4, 4, 3, 2, 1};
    int[] res5 = lab.shuffle(task5, 4);
    lab.printArr("5. Shuffled Array", res5, res5.length);
}