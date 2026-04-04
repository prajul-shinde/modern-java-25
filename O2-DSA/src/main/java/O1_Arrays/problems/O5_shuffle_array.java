import static java.lang.IO.print;
import static java.lang.IO.println;

class ShuffleArraySolution {

    public int[] shuffle(int[] nums, int n) {
        // The total size is 2 * n
        int[] result = new int[2 * n];

        // We only need to loop n times because each loop handles one X and one Y
        for (int i = 0; i < n; i++) {
            // Place the X element at the even index
            result[2 * i] = nums[i];

            // Place the Y element at the odd index
            result[2 * i + 1] = nums[n + i];
        }

        return result;
    }

    public void printArray(int[] arr) {
        for (int num : arr) {
            print(num + " ");
        }
        println("");
    }
}

void main() {
    ShuffleArraySolution solution = new ShuffleArraySolution();

    // Example 1: nums = [2,5,1,3,4,7], n = 3
    int[] nums1 = {2, 5, 1, 3, 4, 7};
    int n1 = 3;

    println("Input: [2, 5, 1, 3, 4, 7], n = 3");
    int[] res1 = solution.shuffle(nums1, n1);
    print("Output: ");
    solution.printArray(res1);

    // Example 2: nums = [1,2,3,4,4,3,2,1], n = 4
    int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
    int n2 = 4;

    println("\nInput: [1, 2, 3, 4, 4, 3, 2, 1], n = 4");
    int[] res2 = solution.shuffle(nums2, n2);
    print("Output: ");
    solution.printArray(res2);
}