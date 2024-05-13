class Animal{  
    Animal(){System.out.println("animal is created");}  

   
    void main(){
        System.out.println("hello this is parent aninal");
    }

    void display1(){
        System.out.println("displaying parent class class ");
    }

    }  
    class Dog extends Animal{  
  
        void main(){
            System.out.println("this is the dog class");
        }

        void change(){
            System.out.println("displaying dong class ");
        }
    }  
    class TestSuper3{  
    public static void main(String args[]){  
    Animal a= new Dog();
    a.main();  
    a.change;
    }}  