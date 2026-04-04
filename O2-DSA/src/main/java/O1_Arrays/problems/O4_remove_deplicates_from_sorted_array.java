import static java.lang.IO.print;
import static java.lang.IO.println;

class RemoveDuplicatesSolution {

    public int removeDuplicates(int[] arr, int len) {

//        [1 ,1 ,2 ,2, 3]
        if (len == 0)
            return 0;
        int writer = 1;
        for (var reader = 1; reader < len; reader++) {
            if (arr[reader] != arr[reader - 1]) {
                arr[writer] = arr[reader];
                writer++;
            }
        }
        return writer;
    }

    public void printResult(int[] arr, int length) {
        print("[");
        for (var i = 0; i < length; i++)
            print(arr[i] + " ");
        print("]");
    }
}

void main() {
    RemoveDuplicatesSolution solution = new RemoveDuplicatesSolution();

    // Test Case: [1, 1, 2, 2, 3]
    int[] nums = {1, 1, 2, 2, 3};
    int len = 5;

    println("Original: [1, 1, 2, 2, 3]");
    int k = solution.removeDuplicates(nums, len);

    println("New length (k): " + k);
    solution.printResult(nums, k);
}