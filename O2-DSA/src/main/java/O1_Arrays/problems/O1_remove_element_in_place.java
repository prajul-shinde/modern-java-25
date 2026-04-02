import static java.lang.IO.print;
import static java.lang.IO.println;

class RemoveElementSolution {

    public void printResult(int[] arr, int newLength) {

        println("Resulting array: ");
        print("[");
        for (var i = 0; i < newLength; i++)
            print(arr[i] + " ");
        print("]");
    }

    public int removeElement(int[] arr, int length, int val) {
        int writer = 0;
        for (var reader = 0; reader < length; reader++) {
            if (arr[reader] != val) {
                arr[writer] = arr[reader];
                writer++;
            }
        }
        return writer;
    }
}

void main() {
    RemoveElementSolution solution = new RemoveElementSolution();

    // Test Case 1
    int[] nums1 = {3, 2, 2, 3};
    int val1 = 3;
    int length1 = 4;

    println("--- Test Case 1 ---");
    println("Input: [3, 2, 2, 3], val = 3");
    int k1 = solution.removeElement(nums1, length1, val1);
    println("New Length (k): " + k1);
    solution.printResult(nums1, k1);

    // Test Case 2
    int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
    int val2 = 2;
    int length2 = 8;

    println("\n--- Test Case 2 ---");
    println("Input: [0, 1, 2, 2, 3, 0, 4, 2], val = 2");
    int k2 = solution.removeElement(nums2, length2, val2);
    println("New Length (k): " + k2);
    solution.printResult(nums2, k2);
}