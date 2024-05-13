package electricitybill;

import java.util.Scanner;

public class Bill {


    public int elctricBill(int unit){

       int totalBill= (unit <= 50 && unit < 100)  ? 100 : (unit >= 100 && unit < 200)  ?
               200 : (unit >= 200 && unit < 300) ? 300 : (unit >= 300 && unit < 400) ? 400 :
               (unit >= 400 && unit < 500) ? 500 :1000;
       return totalBill;

    }


}
