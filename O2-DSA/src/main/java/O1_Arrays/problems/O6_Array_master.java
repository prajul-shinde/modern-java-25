import static java.lang.IO.print;
import static java.lang.IO.println;

class ArrayMaster {

    // 1. Remove all instances of 'val' in-place
    public int removeElement(int[] nums, int val) {
        // {3, 2, 2, 3};
        var writer = 0;
        for (var reader = 0; reader < nums.length; reader++) {
            if (nums[reader] != val) {
                nums[writer] = nums[reader];
                writer++;
            }
        }
        return writer;
    }

    // 2. Reverse the array in-place
    public void reverse(int[] nums) {
//        [1 2 3 4 5]
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;

        }
    }

    // 3. Check if array is sorted (Non-decreasing)
    public boolean isSorted(int[] nums) {
        // {10, 20, 30, 25};
        if (nums.length == 0)
            return true;
        for (var i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // 4. Remove duplicates from SORTED array in-place
    public int removeDuplicates(int[] nums) {
//        {1, 1, 2, 2, 3, 3, 3};
        if (nums.length == 0)
            return 0;
        int writer = 1;
        for (var reader = 1; reader < nums.length; reader++) {
            if (nums[reader] != nums[reader - 1]) {
                nums[writer] = nums[reader];
                writer++;
            }
        }
        return writer;
    }

    // 5. Shuffle the array [x1, x2, y1, y2] -> [x1, y1, x2, y2]
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (var i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }
        return result;
    }

    // Helper to print arrays for testing
    public void printArr(String label, int[] arr, int length) {
        print(label + ": [ ");
        for (int i = 0; i < length; i++) {
            print(arr[i] + " ");
        }
        println("]");
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