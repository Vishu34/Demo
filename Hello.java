
import java.text.DecimalFormat;

import java.util.Scanner;





class Hello {
    public static void main(String[] args) {

        // take a float variable and print upto 2 decimal value;
        
      float a =23.34f;
      float b=234.2342f;
      double c=345.3434534;
      double high=345.3434534;

       
DecimalFormat df = new DecimalFormat("#.##");

System.out.println(df.format(b));
System.out.println(df.format(c));
System.out.printf("%.2f\n" , b);
System.out.printf("%.2f", c);



// find the second highest value in array of an integer


  Scanner sc = new Scanner(System.in);
  System.out.println(" enter the length of the array:");

  int size= sc.nextInt();
int arr[]= new int[size];

  
  System.out.println(" Enter the element of the array:");

  for(int i=0; i<size; i++){
arr[i]=sc.nextInt();
  }


  int max = Integer.MIN_VALUE;
  int secondhighest= Integer.MIN_VALUE;

  for(int num :arr){
    if(num>max){
        secondhighest=max;
        max=num;
    }else if(num> secondhighest && num <max){
        secondhighest=num;
    }
  }

  System.out.println(" the second highest number is :" + secondhighest);

  sc.close();

//   wap to swap variable without using 3rd variable using 
//   arithmetic operation and without using arithmetic operation


int a1=8;
int b1=3;

a1=a1+b1;
b1=a1-b1;
a1=a1-b1;

System.out.println("after swapping :");
System.out.println("a= is" + a1);
System.out.println("b= is" + b1);


// without arithmetic operation

a1=a1^b1;
b1=a1^b1;
a1=a1^b1;
System.out.println("after swapping :");
System.out.println("a= is" + a1);
System.out.println("b= is" + b1);


// by using the temp 

int temp=a1;
a1=b1;
b1=temp;


System.out.println("after swapping :");
System.out.println("a= is" + a1);
System.out.println("b= is" + b1);




    }
}