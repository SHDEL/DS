package solutions.pack5_Postfix;
import java.util.StringTokenizer;
public class MyShunting_660019 {
    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }
    public static String infixToPostfix(String infixString) {
        MyQueueListWrap_660019<String> queue = new MyQueueListWrap_660019<>();
        MyStackL_660019 stack = new MyStackL_660019();
        String resultPostfixString = "";
        StringTokenizer st = new StringTokenizer(infixString);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (MyRPN_660019.isNumeric(t)){
                queue.enqueue(t);
            }
            else if (t.equals("(")) {
                stack.push(t);
            } 
            else if (t.equals(")")) {
                while (!stack.peek().equals("(")){
                    queue.enqueue(stack.pop());
                }
                stack.pop(); //discard "("
            } 
            else {
                if(!stack.isEmpty()) {
                    while (!stack.isEmpty() && order(stack.peek()) >= order(t)) {
                        queue.enqueue(stack.pop());
                    }
                }
                /* your code */
                stack.push(t);
            }
            System.out.println("current q = " + queue.dumpToString());
        }
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        resultPostfixString = queue.dumpToString();
        return resultPostfixString; //"happy coding";
    }
    }