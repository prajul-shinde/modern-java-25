import static java.lang.IO.println;

class ArrayStack {
    private ArrayList<Integer> stack;

    public ArrayStack() {
        this.stack = new ArrayList<>();
    }

    public void push(int element) {
        stack.add(element);
    }

    public int size() {
        return stack.size();
    }

    public int peek() {
        if (stack.isEmpty())
            return -1;
        return stack.getLast();
    }

    public int pop() {
        if (stack.isEmpty())
            return -1;
        return stack.removeLast();
    }
}

void main() {
    var myStack = new ArrayStack();

    System.out.println("1. Pushing 10, 20, 30...");
    myStack.push(10);
    myStack.push(20);
    myStack.push(30);

    println("Current Size: " + myStack.size());

    println("\n2. Peeking at the top...");
    println("Top Element (Peek): " + myStack.peek()); // Should be 30
    println("Notice size is still: " + myStack.size() + " (Peek doesn't remove it)");

    println("\n3. Popping elements...");
    println("Popped: " + myStack.pop()); // Removes 30
    println("Popped: " + myStack.pop()); // Removes 20

    println("\n4. Final State Check");
    println("Current Size: " + myStack.size()); // Should be 1
    println("Top Element is now: " + myStack.peek()); // Should be 10
}