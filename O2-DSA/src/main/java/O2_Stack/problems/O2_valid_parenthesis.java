import static java.lang.IO.println;

class ParenthesesSolution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (var i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                Character top = stack.pop();
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
                if (c == ')' && top != '(') return false;
            }
        }
        return stack.isEmpty();
    }
}

void main() {

    ParenthesesSolution sol = new ParenthesesSolution();

    println("Test '()[]{}': " + sol.isValid("()[]{}")); // True
    println("Test '([)]': " + sol.isValid("([)]"));     // False
    println("Test '(': " + sol.isValid("("));           // False (not empty at end)
    println("Test ']': " + sol.isValid("]"));           // False (empty at start)
}