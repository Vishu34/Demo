package stringnumberquery;

public class Fibonacci {

//    fibonacci series 0 to 7
    public static void fibo(int a , int b, int n){

        if(n==0){
            return ;
        }

        System.out.println(a);
        fibo(b, a+b , n-1);
    }
}
