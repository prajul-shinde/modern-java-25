import static java.lang.IO.print;
import static java.lang.IO.println;

class ReverseArraySolution {

    public void reverse(int[] arr, int length) {

        int left = 0;
        int right = length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;

        }
    }

    public void printArray(int[] arr, int length) {
        print("[");
        for (var i = 0; i < length; i++)
            print(arr[i] + " ");
        print("]");
    }
}

void main() {
    ReverseArraySolution solution = new ReverseArraySolution();

    // Test Case 1: Even number of elements
    int[] nums1 = {10, 20, 30, 40};
    int len1 = 4;
    println("--- Test Case 1 (Even) ---");
    print("Before: ");
    solution.printArray(nums1, len1);

    solution.reverse(nums1, len1);

    print("After:  ");
    solution.printArray(nums1, len1);

    // Test Case 2: Odd number of elements
    int[] nums2 = {1, 2, 3, 4, 5};
    int len2 = 5;
    println("\n--- Test Case 2 (Odd) ---");
    print("Before: ");
    solution.printArray(nums2, len2);

    solution.reverse(nums2, len2);

    print("After:  ");
    solution.printArray(nums2, len2);
}