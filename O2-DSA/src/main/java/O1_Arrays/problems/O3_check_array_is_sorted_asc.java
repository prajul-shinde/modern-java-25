import static java.lang.IO.println;

class SortedArraySolution {

    public boolean isSorted(int[] arr, int length) {
        if (length <= 1)
            return true;
        for (var i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }
}

void main() {
    SortedArraySolution solution = new SortedArraySolution();

    // Test Case 1: Sorted
    int[] nums1 = {10, 20, 30, 30, 40};
    int len1 = 5;
    println("Test Case 1 [10, 20, 30, 30, 40]: " + solution.isSorted(nums1, len1));

    // Test Case 2: Not Sorted
    int[] nums2 = {10, 30, 20, 40};
    int len2 = 4;
    println("Test Case 2 [10, 30, 20, 40]: " + solution.isSorted(nums2, len2));

    // Test Case 3: Single Element
    int[] nums3 = {5};
    int len3 = 1;
    println("Test Case 3 [5]: " + solution.isSorted(nums3, len3));
}