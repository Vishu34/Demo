import Dao.UserDao;
import controller.UserController;
import model.UserModel;
import service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {


    private Scanner scanner;
private UserController userController;




    public Main (){
      

userController = new UserController();
        scanner= new Scanner(System.in);

    }


    public static void main(String[] args) {

        Main main = new Main();
        main.run();

    }




    public  void run(){





        while(true){


            showMenu();

            int choice = Integer.parseInt(scanner.nextLine());

           
                switch (choice){
                    case 1:
                       userController.userOperationHandling();
                        break;

                    case 2:
                        exitFromdata();
                        break;
                    default:
                        System.out.println("envalid numbver please write fix number ");

                }
            
        }
    }


    public void showMenu(){
        System.out.println("welcome user ");
        System.out.println("1 : create user data ");
      

        System.out.println("2 : exit ");
        System.out.println( "enter the choice");
    }


  

   

    public void exitFromdata(){

        try{
            int i =5 ;
            System.out.print("exiting.");
            while (i>=0){
                System.out.print(". ");
                Thread.sleep(500);
                i--;
            };

            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("messsage error" + e.getMessage());
        }

    }


}