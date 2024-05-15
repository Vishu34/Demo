import electricitybill.Bill;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String name="987-098yt";
        String s="";
        for(int i=name.length()-1; i<0; i--){
           s+= name.charAt(i);
        }
        System.out.println(s);
    }


}