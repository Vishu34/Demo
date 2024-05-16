// Java program to find all Armstrong numbers
// in a given range

// Importing necessary libraries
import interfacemethod.Student;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;
class Main {



     public static void main(String[] args){


          Student s = new Student("vishu" , 23423424);
          Student s1 = new Student("vishu" , 23444);
          System.out.println(s1.compareTo(s));
          s.display();
          s.enjoying();


          Date date = new Date();

          // Format date for US locale
//          DateFormat usFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
//          String usFormatted = usFormat.format(date);
//          System.out.println("Formatted for US: " + usFormatted);
//
//          // Format date for French locale
//          DateFormat frenchFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE);
//          String frenchFormatted = frenchFormat.format(date);
//          System.out.println("Formatted for France: " + frenchFormatted);

          double number = 123456.78;

          // Format number for US locale
          NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
          String usFormatted = usFormat.format(number);
          System.out.println("Formatted for US: " + usFormatted);

          // Format number for Indian locale
          NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
          String indiaFormatted = indiaFormat.format(number);
          System.out.println("Formatted for India: " + indiaFormatted);

     }
}
