package solutions.pack5_Postfix;

import java.util.regex.Pattern;

public class MyRPN_660019 {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum){
        if(strNum == null){
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
    public static double computeRPN(String rpn){
        String [] data = rpn.split(" ");
        MyStackA_660019 stack = new MyStackA_660019();
        for (String i : data){
            if (isNumeric(i)){
                stack.push(Double.parseDouble(i));
            }
            else{
                double b = stack.pop();
                double a = stack.pop();
                if (i.equals("+")){
                    stack.push(a + b);
                }
                else if (i.equals("-")){
                    stack.push(a - b);
                }
                else if (i.equals("*")){
                    stack.push(a * b);
                }
                else if (i.equals("/")){
                    stack.push(a / b);
                }
            }
            
        }
        return stack.pop();
    }
    
}
