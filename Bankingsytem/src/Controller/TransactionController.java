package Controller;

import Service.TransactionService;
import Service.UserService;
import model.AccountModel;
import model.TransactionModel;
import model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionController {
    private Scanner scanner;
    private TransactionService transactionService;
private UserService userService;


    public TransactionController(){
        scanner= new Scanner(System.in);
        transactionService = new TransactionService();
        userService= new UserService();


    }



//    public void transactionOperation(){
//        while(true){
//            showMenu();
//            int choice = Integer.parseInt(scanner.nextLine());
//            try{
//                switch (choice){
//                    case 1:
//
// transactionAmount("withdraw");
//                        break;
//                    case 2:
//                        transactionAmount("deposit");
//                        break;
//                    case 3:
//                        transactionAmount("transfer");
//                        break;
//                    case 4:
//                        Exiting();
//                        return;
//                    default:
//                        System.out.println("please choice the valid number");
//
//                }
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }
//    }


    //show menu to show the user funcionality
    public void showMenu() {
        System.out.println("1: withdraw amount");
        System.out.println("2: deposit amount");
        System.out.println("3: transfer amount");


        System.out.println("4: logout");
    }


    public void transactionAmount(int userId , String transaction){


       UserModel userModel= userService.getParticularuser(userId);

       long accountno=userModel.getAccountModel().getAccount_no();


        String amount = promptForInput("Enter your amount:", "Please enter your amount");





        TransactionModel transactionModel= new TransactionModel();
        if(transaction=="transfer"){

            String reciever_ac = promptForInput("enter reciever account no", "Please enter reciever account no");




            transactionModel.setReciever_accountno(Long.parseLong(reciever_ac));

        }

        String security_key = promptForInput("Enter your security key:", "Please enter your security key");


        transactionModel.setAmount(Double.parseDouble(amount));
        transactionModel.setTransaction_type(transaction);


        transactionService.transactionAmount( transactionModel ,accountno,  security_key);
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


    // get the transaction details

    public void getAccountdetails() {

        System.out.println(" enter the accoount no ");
         long accountno = Long.parseLong(scanner.nextLine());
       List<TransactionModel> list = new ArrayList<>();
        list= transactionService.getAccountdetails(accountno);


        if(list.isEmpty()){
            System.out.println("thers is no data ");

        }else {
            System.out.println(list);
        }
    }


//esiting ...
    public void Exiting() {

        int i = 5;

        System.out.print("exiting");

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



}
