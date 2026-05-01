import static java.lang.IO.print;
import static java.lang.IO.println;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {

    public ListNode reverseList(ListNode head) {
        // 1 -> 2 -> 3 -> 4 -> null
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; // nextTemp = 2, 3, 4, null
            curr.next = prev;  // curr.next = 1->null, 2->1->null 3->2->1->null 4->3->2->1->null
            prev = curr;      // prev = 1 2 3 4
            curr = nextTemp;  // curr = 2 3 4 null
        }
        return prev;
    }
}

void main() {
    // 1. Create a list: 1 -> 2 -> 3 -> 4 -> null
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    printList("Original", head);

    // 2. Reverse it
    Solution sol = new Solution();
    ListNode reversedHead = sol.reverseList(head);

    printList("Reversed", reversedHead);
}

void printList(String label, ListNode head) {
    print(label + ": ");
    ListNode curr = head;
    while (curr != null) {
        print(curr.val + " -> ");
        curr = curr.next;
    }
    println("null");
}