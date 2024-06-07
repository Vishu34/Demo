package Controller;

import Dao.UserDao;
import Service.UserService;
import com.sun.security.jgss.GSSUtil;
import model.AccountModel;
import model.TransactionModel;
import model.UserModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserController {
    private Scanner scanner;
    private UserDao userDao;
    private UserService userService;
    private AccountController accountController;
    private TransactionController transactionController;

    public UserController() {
        scanner = new Scanner(System.in);
        userService = new UserService();
        accountController= new AccountController();
        transactionController=new TransactionController();
        userDao = new UserDao();
    }


//    public  void userOperation() {
//
//        while (true) {
//            showMenu();
//            int choice = Integer.parseInt(scanner.nextLine());
//
//            try {
//
//                switch (choice) {
//                    case 1:
//
//                        userRegistration();
//
//
//                        break;
//                    case 2:
//
//
//               userLogin();
//                        break;
//                    case 3:
//                        Exiting();
//                        return;
//                    default:
//                        System.out.println("please enter the valid number ");
//                        break;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

    //show menu to show the user funcionality
    public  void showMenu() {
        System.out.println("1: register yourself");
        System.out.println("2 : login yourself");
        System.out.println("3: exit");
    }


    // register the user

    public  void userRegistration() {

        String usertype = promptForInput("Select user type: user/admin", "Please select user type");
        String name = promptForInput("Enter your name:", "Please enter your name");
        String email = promptForInput("Enter your email:", "Please enter your email");
        String password = promptForInput("Enter your password:", "Please enter your password");

            UserModel userModel = new UserModel();
            userModel.setUsername(name);
            userModel.setEmail(email);
            userModel.setPassword(password);
            userModel.setUserType(usertype);

            userService.userRegistration(userModel);



    }


    //validation checking for userragistration ;
    private  String promptForInput(String promptMessage, String errorMessage) {
        String input = "";
        while (input.isEmpty() || input.isBlank()) {
            System.out.println(promptMessage);
            input = scanner.nextLine();
            if (input.isEmpty() || input.isBlank()) {
                System.out.println(errorMessage);
            }
        }
        return input;
    }






    //use login

    public UserModel  userLogin() {



        String email = promptForInput1("Enter your email:", "Please enter your email");
        String password = promptForInput1("Enter your password:", "Please enter your password");






            UserModel userModel = new UserModel();


            userModel= userService.userLogin(email , password);

            return userModel;

    }


// usermodel checking any records are empty or not  validation cehcking
    private  String promptForInput1(String promptMessage, String errorMessage) {
        String input = "";
        while (input.isEmpty() || input.isBlank()) {
            System.out.println(promptMessage);
            input = scanner.nextLine();
            if (input.isEmpty() || input.isBlank()) {
                System.out.println(errorMessage);
            }
        }
        return input;
    }





    //find the all user data

    public void  getAlluser() throws SQLException {
        List<UserModel> list = userService.getAlluser();


        if(list==null){
            System.out.println("empl");

        }else{
            System.out.println(list);
        }

    }

    public void getParticularuser(int userId){

        System.out.println("your id is "+ userId);
        UserModel userModel = new UserModel();
        userModel= userService.getParticularuser(userId);
        System.out.println(userModel);

        System.out.println("..................................................................................................................................................................................................................");
        System.out.println("userId" + " " + " username" +" "+   "email " + " " + " password" + " "+ "accountno" + " " + "balance" ) ;

        System.out.println(userModel.getUser_id() +" " +userModel.getUsername() + " "+ userModel.getEmail() +" " + userModel.getPassword()
        + " " + userModel.getAccountModel().getAccount_no() + " "+ userModel.getAccountModel().getBalance() );

        System.out.println("..................................................................................................................................................................................................................");

        if(userModel.getTransactionModel()!=null){
            System.out.println("..................................................................................................................................................................................................................");
           for(TransactionModel t :userModel.getTransactionModel()){
               System.out.println("transaction_type" + " "+ "amount" + " " + " "+ "senderid" + " "+ "date"+" "+ "recieveraccountno");
               System.out.println(t.getTransaction_type() + " " + t.getAmount() + " "+ " "+t.getSender_id()+
                  " "+     t.getDate() + " "+ t.getReciever_accountno() );
           }
            System.out.println("..................................................................................................................................................................................................................");

        }
    }



    // delete from user accoutn particular user

    public boolean deleteUserAccount(int userid)  {

        System.out.println(" your id is  " + userid);


        return userService.deleteUserAccount(userid);

    }

    public void udpdateUseAccount(int userId)  {

        String username = promptForInput2("enter username", "Please enter user name");
        String email = promptForInput2("Enter your email:", "Please enter your email");
        String password = promptForInput2("Enter your password:", "Please enter your password");
        String security_key = promptForInput2("Enter your security key:", "Please enter your security key");


        System.out.println(" your id  is" + userId);




        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setEmail(email);
        userModel.setPassword(password);


       userService.udpdateUseAccount(userModel , security_key  ,userId);

    }


    //validation checking for userragistration ;
    private  String promptForInput2(String promptMessage, String errorMessage) {
        String input = "";
        while (input.isEmpty() || input.isBlank()) {
            System.out.println(promptMessage);
            input = scanner.nextLine();
            if (input.isEmpty() || input.isBlank()) {
                System.out.println(errorMessage);
            }
        }
        return input;
    }



}
