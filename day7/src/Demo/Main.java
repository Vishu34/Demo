
package  Demo;

 public class Main{


    public static void main(String[] args) {

       Animal a = new Animal();
       a.setAge(23);
       a.setName("vishu");
        System.out.println(a);
        Animal1 a1 = new Animal1();
        a1.setName("visjfs");
        a1.setName2("dsfsaf");
        a.setAnimal1(a1);
        System.out.println(a.getAnimal1());
        System.out.println(a1);

    }
}
