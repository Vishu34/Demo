import electricitybill.Bill;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the unit no. ");
       int unit = sc.nextInt();
        System.out.println("enter the unit no. is "+ unit);
        Bill bill = new Bill();
        int value =bill.elctricBill(unit);
        System.out.println("your electircity bill is "+ value);
    }


}