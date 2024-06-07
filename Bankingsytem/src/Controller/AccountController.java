package Controller;

import Service.AccountService;
import Service.UserService;
import model.AccountModel;

import java.util.Scanner;

public class AccountController {
    private Scanner scanner;
    private AccountService accountService;
    private  TransactionController transactionController;



    public  AccountController(){
        scanner= new Scanner(System.in);
        accountService= new AccountService();
        transactionController = new TransactionController();




    }


//    public void accountOperation(){
//
//
//
//
//        while(true){
//            showMenu();
//            int choice = Integer.parseInt(scanner.nextLine());
//            try{
//                switch (choice){
//                    case 1:
//
//
//
//                        if(createAccountno()){
//                            transactionController.transactionOperation();
//                        }
//                        break;
//
//                    case 3:
//                        Exiting();
//                        return;
//
//
//
//                }
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }
//
//
//
//
//    }


    //show menu to show the user funcionality
    public void showMenu() {
        System.out.println("1: Open new account");
        System.out.println("2: Get all user details");
        System.out.println("3: update user");
        System.out.println("4: delete user ");
        System.out.println("5: get particular user ");

        System.out.println("3: logout");
    }



    // create accoutn no for the user

    public  boolean createAccountno(){


        String email = promptForInput("Enter your email:", "Please enter your email");

        String security_key = promptForInput("Enter your security key:", "Please enter your security key");
        String balance = promptForInput("Enter your balance:", "Please enter your balance");

//

        AccountModel accountModel = new AccountModel();
        accountModel.setEmail(email);
        accountModel.setBalance(Double.parseDouble(balance));
        accountModel.setSecurity_key(security_key);

       boolean accountCreated= accountService.createAccountno(accountModel);

       if(accountCreated){

           return accountCreated;
       }else {

           return accountCreated;
       }


    }

    public void Exiting() {

        int i = 5;

        System.out.print("log out ");

        try {
            while (i >= 0) {
                System.out.print(".");
                Thread.sleep(500);
                i--;
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void getAccountdetails(){

        System.out.println(" enter your account no");
        long accountno= Long.parseLong(scanner.nextLine());

        AccountModel accountModel = new AccountModel();
        accountModel=accountService.getAccountdetails(accountno);
        System.out.println(accountModel);
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

}
