import static java.lang.IO.println;

class StackMaster {

    /**
     * Problem 1: Baseball Game
     * Integer = push score
     * "C" = invalidate (pop)
     * "D" = double last valid score and push
     * "+" = sum last two valid scores and push
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (var op : ops) {
            switch (op) {
                case "C" -> stack.pop();
                case "D" -> {
                    Integer lastScore = stack.peek();
                    stack.push(lastScore * 2);
                }
                case "+" -> {
                    Integer first = stack.pop();
                    Integer second = stack.peek();
                    Integer sumOfPrevTwo = first + second;
                    stack.push(first);
                    stack.push(sumOfPrevTwo);
                }
                default -> stack.push(Integer.parseInt(op));
            }
        }
        int totalSum = 0;
        while (!stack.isEmpty()) {
            totalSum += stack.pop();
        }
        return totalSum;
    }

    /**
     * Problem 2: Valid Parentheses
     * Must close in correct order: () [] {}
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                else {
                    Character top = stack.pop();
                    if (c == '}' && top != '{') return false;
                    if (c == ')' && top != '(') return false;
                    if (c == ']' && top != '[') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

/**
 * Problem 3: Min Stack Class
 * Must get min value in O(1) time.
 */
class MinStackChallenge {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStackChallenge() {
        // TODO: Initialize your stacks
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        // TODO: Push to main. Push current min to minStack.
        stack.push(val);
        if (minStack.isEmpty())
            minStack.push(val);
        else {
            int currentmin = minStack.peek();
            minStack.push(Math.min(val, currentmin));
        }
    }

    public void pop() {
        // TODO: Pop from both to keep them in sync
        stack.pop();
        minStack.pop();
    }

    public int top() {
        // TODO: return top
        return stack.peek();
    }

    public int getMin() {
        // TODO: return top of minStack
        return minStack.peek();
    }
}

void main() {
    StackMaster lab = new StackMaster();

    // --- Test 1: Baseball Game ---
    String[] ops = {"5", "2", "C", "D", "+"};
    println("1. Baseball Score: " + lab.calPoints(ops)); // Expected: 30

    // --- Test 2: Valid Parentheses ---
    println("2a. Is '()[]{}' valid? " + lab.isValid("()[]{}")); // Expected: true
    println("2b. Is '(]' valid? " + lab.isValid("(]"));         // Expected: false

    // --- Test 3: Min Stack ---
    MinStackChallenge minStack = new MinStackChallenge();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    println("3a. Minimum: " + minStack.getMin());   // Expected: -3
    minStack.pop();
    println("3b. Top after pop: " + minStack.top()); // Expected: 0
    println("3c. Minimum now: " + minStack.getMin()); // Expected: -2
}