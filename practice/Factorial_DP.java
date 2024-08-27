package practice;

public class Factorial_DP {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorialDp(n));
        
    }
    public static int factorialDp(int n){
        int fact = 1;
        int n_1 = 2;
        int i = 2;
        while (i <= n) {
            fact = fact * n_1;
            System.out.println("----------------");
            System.out.println("fact: " + fact);
            System.out.println("n_1: " + n_1);
            i++;
            n_1 = i;
        }
        return fact;
    }
}
