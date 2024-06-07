import Controller.AccountController;
import Controller.AdminController;
import Controller.TransactionController;
import Controller.UserController;
import Dao.AccountDao;
import Dao.UserDao;
import model.UserModel;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
  private UserController userController;
  private AccountController accountController;
  private TransactionController transactionController;
  private  AdminController adminController;
  private Scanner scanner;
  private  UserDao userDao;
  private  UserModel userModel=null;
  private AccountDao accountDao;



    public Main(){
userController = new UserController();
accountController= new AccountController();
transactionController=new TransactionController();
adminController = new AdminController();
userDao =new UserDao();
accountDao = new AccountDao();

userModel = new UserModel();

scanner = new Scanner(System.in);
    }

    
    public static void main(String[] args)  throws SQLException{


        Main main  = new Main();
        main.run();
    
    };


    public  void run() throws SQLException {

        while (true){
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1 :
                    userController.userRegistration();

                    break;
                case 2 :
                 userModel = userController.userLogin();
                 if(userModel!=null) {
                     if (userModel.getUserType().equals("admin")) {

                         boolean number = true;
                         while (number) {
                             System.out.println("1: get particular user");
                             System.out.println("2: update particular user");
                             System.out.println("3: delete particular user");
                             System.out.println("4: view all account details");

                             System.out.println("5: view all user details");

                             System.out.println("6: logout");
                             int choicenumber = Integer.parseInt(scanner.nextLine());
                             switch (choicenumber) {

                                 case 1:
                                     adminController.getParticularuser();
                                     break;
                                 case 2:
                                     adminController.udpdateUseAccount();
                                     break;

                                 case 3:


                                     adminController.deleteUserAccount();


                                     break;


                                 case 4:

                                     adminController.getAccountDetails();

                                     break;
                                 case 5:


                                     adminController.getAlluser();
                                     break;

                                 case 6:
                                     System.out.println("exiting ");
                                     number = false;

                                     break;

                                 default:
                                     System.out.println("invalid choice please try again ");
                                     break;
                             }


                         }

                     } else if (userModel.getUserType().equals("user") && userModel.getEmail() != null) {


                         System.out.println("user Logged in ");
                         if (!accountDao.getAccountExist(userModel.getEmail())) {
                             System.out.println("1: open new account");
                             System.out.println("2: exit");
                             int number = scanner.nextInt();
                             scanner.nextLine();

                             if (number == 1) {
                                 accountController.createAccountno();
                             } else {
                                 break;
                             }
                         }

                         int choicenum = 0;

                         while (choicenum != 7) {


                             System.out.println("1: get particular user");
                             System.out.println("2: update user");
                             System.out.println("3: delete user");
                             System.out.println("4: withdraw amount");
                             System.out.println("5: deposit amount");
                             System.out.println("6: transfer amount");


                             System.out.println("7: logout");


                             System.out.println("Enter your choice:");
                             int choicenum1 = scanner.nextInt();
                             scanner.nextLine();

                             switch (choicenum1) {

                                 case 1:
                                     userController.getParticularuser(userModel.getUser_id());
                                     break;
                                 case 2:
                                     userController.udpdateUseAccount(userModel.getUser_id());
                                     break;

                                 case 3:


                                     if (userController.deleteUserAccount(userModel.getUser_id())) {
                                         choicenum = 7;
                                         System.out.println("you are logging out you data has been deleted ");
                                     }


                                     break;
                                 case 4:
                                     transactionController.transactionAmount(userModel.getUser_id(), "withdraw");
                                     break;
                                 case 5:
                                     transactionController.transactionAmount(userModel.getUser_id(), "deposit");
                                     ;

                                     break;
                                 case 6:
                                     transactionController.transactionAmount(userModel.getUser_id(), "transfer");
                                     break;


                                 case 7:
                                     LogOUt();
                                     choicenum = 7;
                                     userModel = null;
                                     break;

                                 default:
                                     System.out.println("invalid choice please try again ");
                                     break;
                             }

                         }
                     } else {
                         System.out.println(" incorrect email or password");
                     }
                 }else{
                     System.out.println("user is not login check it email or password");
                 }
break;

                case 3:

                    Exiting();
                    break;


                default:
                    System.out.println("please enter the valid number ");
                    break;
            }
        }

    }


    // show menu to show the userdetails;

    public void showMenu(){

        System.out.println("1: register user");
        System.out.println("2: login user");

        System.out.println("3: exit");

        System.out.println("Enter your choice:");

    }


    public  void Exiting(){

        int i = 5;

        System.out.print("Exiting");

        try {
            while (i>=0){
                System.out.print(".");
                Thread.sleep(500);
                i--;
            }
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void LogOUt(){

        int i = 5;

        System.out.print("log out");

        try {
            while (i>=0){
                System.out.print(".");
                Thread.sleep(500);
                i--;
            }
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}