import static java.lang.IO.println;

class BaseballSolution {

    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            switch (op) {
                case "+" -> {
                    int top1 = scores.pop();
                    int top2 = scores.peek();
                    int newScore = top1 + top2;
                    scores.push(top1);
                    scores.push(newScore);
                }
                case "D" -> {
                    int prevScore = scores.peek();
                    scores.push(prevScore * 2);
                }
                case "C" -> scores.pop();
                default -> scores.push(Integer.valueOf(op));
            }
        }
        int totalSum = 0;
        while (!scores.isEmpty()) {
            totalSum += scores.pop();
        }
        return totalSum;
    }
}

void main() {
    BaseballSolution sol = new BaseballSolution();

    // Test Case 1
    String[] ops1 = {"5", "2", "C", "D", "+"};
    println("Test 1 Result: " + sol.calPoints(ops1));
    // Expected: 30 (5 + 10 + 15)

    // Test Case 2 (The tricky one from our dry run)
    String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
    println("Test 2 Result: " + sol.calPoints(ops2));
    // Expected: 27
}