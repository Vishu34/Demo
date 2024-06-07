package Controller;

import Service.AdminService;
import model.AccountModel;
import model.AlluserModel;
import model.TransactionModel;
import model.UserModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private AdminService adminService;
    private Scanner scanner;

    public AdminController() {
        adminService = new AdminService();
        scanner = new Scanner(System.in);

    }


    public void getAccountDetails(){

        List<AccountModel> list = null;

         list =adminService.getAccountDetails();
        System.out.println(list);
    }

    //get all user data

    public void  getAlluser() throws SQLException {
        List<AlluserModel> list = adminService.getallUser();
        System.out.println(list);

        if(list==null){
            System.out.println("empl");

        }else{
            System.out.println(list);
        }

    }


    public void getParticularuser(){

        System.out.println("enter user's id");
        int userId= Integer.parseInt(scanner.nextLine());
        UserModel userModel = new UserModel();
        userModel= adminService.getParticularuser(userId);
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

    public boolean deleteUserAccount()  {

        System.out.println("enter user's id");
        int userId= Integer.parseInt(scanner.nextLine());
        return adminService.deleteUserAccount(userId);

    }

    public void udpdateUseAccount()  {

        String userId = promptForInput("Enter user id:", "Please enter user id");

        String username = promptForInput("enter username", "Please enter user name");
        String email = promptForInput("Enter  email:", "Please enter  email");
        String password = promptForInput("Enter  password:", "Please enter password");
        String security_key = promptForInput("Enter  security key:", "Please enter security key");



        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setEmail(email);
        userModel.setPassword(password);


        adminService.udpdateUseAccount(userModel , security_key  ,Integer.parseInt(userId));

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



