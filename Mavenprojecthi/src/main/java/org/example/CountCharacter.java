// Java program to convert a String to a currency format using number format 

package org.example;
public class CountCharacter    
{    
    public static void hello(String name){
        String str="";
        int part=4;
        if(name.length()%part!=0){
            System.out.println("this can be devided");
        }

        

       int start=0;
       int end=part;
       while(start<name.length()){
         str=name.substring(start, end);
        start=end;
end+=part;

System.out.println(str);
       }

       
    }
    public static void main(String[] args) {    
       
            
        String name ="aaaabbbbcccc";

       
     hello(name);
    
      
    }    
}    