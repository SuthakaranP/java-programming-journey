import java.util.*;

class Main {

    public static int prec(char a) {
        if (a == '^') {
            return 3;
        } else if (a == '*' || a == '/') {
            return 2;
        } else if (a == '+' || a == '-') { // fixed: '-' instead of '*'
            return 1;
        } else {
            return -1;
        }
    }

    public static boolean rightAssociate(char b) {
        return b == '^';
    }

    public static void infixToPostfix(String value) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < value.length(); i++) {
            char val = value.charAt(i);

            // ignore spaces
            if (val == ' ') {
                continue;
            }

            // operand
            if ((val >= 'a' && val <= 'z') ||
                (val >= 'A' && val <= 'Z') ||
                (val >= '0' && val <= '9')) {
                sb.append(val);
            }
            // left parenthesis
            else if (val == '(') {
                stack.push(val);
            }
            // right parenthesis
            else if (val == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // pop '('
                }
            }
            // operator
            else {
                while (!stack.isEmpty() &&
                       stack.peek() != '(' &&
                       (prec(stack.peek()) > prec(val) ||
                        (prec(stack.peek()) == prec(val) && !rightAssociate(val)))) {
                    sb.append(stack.pop());
                }
                stack.push(val);
            }
        }

        // pop remaining operators
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        infixToPostfix(value);
        sc.close();
    }
}
