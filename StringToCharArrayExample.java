import java.lang.reflect.Array;
import java.util.Arrays;

public class StringToCharArrayExample{  


  public static String ReverseString(String str){
    char [] Chararr= str.toCharArray();
     
    int left=0;
    int right=str.length()-1;

    while(left<str.length()-1){
      char temp=Chararr[left];
      Chararr[left]=Chararr[right];
      Chararr[right]=temp;
      left++;
      right--;
    }
return new String(Chararr);
  }
 
  public static void main(String args[]){  
  
  
    String str="vishur";
 
   
   String name=ReverseString(str);
   System.out.println(name);
   


   String name1="vishu";
String name2="";
  //  for(int i=name1.length()-1; i>=0;i--){

  //   name2+=name1.charAt(i);
  //  }

  

   int i=name1.length()-1;
   while(i>=0){
    name2+=name1.charAt(i);
    i--;
   }
   System.out.println(name2);
}  
  }