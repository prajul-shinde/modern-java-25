import static java.lang.IO.print;
import static java.lang.IO.println;

class ListNode {

    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class SinglyLinkedList {

    private ListNode head; // dummy node
    private ListNode tail;

    public SinglyLinkedList() {
        this.head = new ListNode(-1);
        this.tail = head;
    }

    // o(1)
    public void insertEnd(int element) {
        this.tail.next = new ListNode(element);
        this.tail = this.tail.next;
    }

    // o(n)
    public void printList() {
        ListNode curr = this.head.next; //skip dummy node
        print("List: ");
        while (curr != null) {
            print(curr.value + " -> ");
            curr = curr.next;
        }
        println("null");
    }

    // o(n)
    public void remove(int index) {
        ListNode curr = head;
        // move to node right before the one we want to delete
        for (var i = 0; i < index && curr != null; i++) {
            curr = curr.next;
        }
        if (curr != null && curr.next != null) {
            // if we are deleting actual tail node, move tail back
            if (curr.next == tail) {
                tail = curr;
            }
            // skip the node
            curr.next = curr.next.next;
        }
    }

    // o(n)
    public void removeEnd() {
        if (head.next == null) return; //list is empty

        ListNode curr = head;
        // walk till we find node right before tail
        while (curr.next != tail) {
            curr = curr.next;
        }

        //set new tail
        curr.next = null;
        tail = curr;
    }

    //o(n)
    public void insert(int index, int value) {
        ListNode curr = head;
        // move the node before the target index
        for (var i = 0; i < index && curr != null; i++)
            curr = curr.next;
        if (curr != null) {
            ListNode newNode = new ListNode(value);
            // connect newNode to rest of list
            newNode.next = curr.next;
            // link current to new node
            curr.next = newNode;

            //update tail if inserted at end
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }
}

void main() {
    SinglyLinkedList list = new SinglyLinkedList();

    println("--- Adding 10, 30 ---");
    list.insertEnd(10);
    list.insertEnd(30);
    list.printList(); // 10 -> 30 -> null

    println("\n--- Inserting 20 in Middle (Index 1) ---");
    list.insert(1, 20);
    list.printList(); // 10 -> 20 -> 30 -> null

    println("\n--- Inserting 5 at Front (Index 0) ---");
    list.insert(0, 5);
    list.printList(); // 5 -> 10 -> 20 -> 30 -> null

    println("\n--- Removing End ---");
    list.removeEnd();
    list.printList(); // 5 -> 10 -> 20 -> null

    println("\n--- Removing Middle (Index 1: the 10) ---");
    list.remove(1);
    list.printList(); // 5 -> 20 -> null
}