package stringnumberquery;

import java.util.Arrays;

public class Allquestion {


//    prime number checking

    public static  boolean primeNumber(int n){


        for(int i=2; i<n; i++){
            if(n%i==0){
                return false;
            }

        }
        return true;
    }



//    anagram cheking

    static boolean areAnagram(char[] str1, char[] str2)
    {
        // Get lengths of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2)
            return false;

        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }



//    palindrome number

    public static  int palinDrome(int palinno ){

        int rem , rev=0;

        while(palinno>0){
            rem= palinno%10;
            rev=rev*10+rem;
            palinno = palinno/10;

        }
//        System.out.println(rev);



        return  rev;
    }



}
