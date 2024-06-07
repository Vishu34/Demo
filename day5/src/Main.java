import java.util.Scanner;

class Test {

    private static Scanner scanner;

    static double sum = 1000.0;

    public static void Accountno(String str, double n) {
        
       
        if (str == "wo") {
            if (n <= sum) {
                sum = sum - n;
                
                System.out.println(" you have w");
                System.out.println(sum);
            }else{
                System.out.println("in sufficient balalnce ");
            }
        } else if (str == "do") {
            sum = sum + n;
            System.out.println(" you have deposit ");
            System.out.println(sum);
        } else {
            System.out.println(sum);
            
        }

    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

       
        int count =1;
       
        System.out.println(count);
        System.out.println(count++);
        System.out.println(count);

    }

}
