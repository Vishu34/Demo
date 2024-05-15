package stringnumberquery;

public class Main {


    public static void main(String[] args)
    {
//        this is the fiboonacci series

        int a =0; int b=1; int n=7;
        Fibonacci.fibo(a , b ,n);

//        prime number

 int primenumber=12;
        if(  Allquestion.primeNumber(primenumber)){
            System.out.println(primenumber+ " is the prime number");
        }else{
            System.out.println(primenumber+ " is not the prime number");
        }



//        anagram number
        char name1[] = { 'g', 'r', 'a', 'm' };
        char name2[] = { 'a', 'r', 'm' };

       if(Allquestion.areAnagram(name1 , name2)){
           System.out.println("this is the anagram ");
       }else {
           System.out.println("this is not the anagram ");
       }


       int palllin=12341;

       int reverse= Allquestion.palinDrome(palllin);
       if(palllin==reverse){
           System.out.println(palllin+"is the palindrom number ");
       }else {
           System.out.println(palllin+"is not  the palindrom number ");
       }


    }
}
