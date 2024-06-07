package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.UserModel;
import service.UserService;

public class UserController {
    private Scanner scanner;
    private UserService userService;

    public UserController() {
        scanner = new Scanner(System.in);
        userService = new UserService();

    }

    public void userOperationHandling() {

        while (true) {
            showMenu();

            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        Adduserdata();
                        break;

                    case 2:
                        UpdateuserdataByid();
                        break;
                    case 3:
                        DeleteuserdataByid();
                        break;
                    case 4:
                        Getuserdata();
                        break;
                    case 5:
                        GetuserdataByid();
                        break;
                    case 6:
                    // System.out.println("Returning the Main Menu....");
                    //    return;

                    break;
                       

                    default:
                        System.out.println("your choice is invalid please enter valid choice");
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    // show menu
    public void showMenu() {
        System.out.println("welcome user ");
        System.out.println("1 : addth suer ");

        System.out.println("2 : update user data  ");
        System.out.println("3 : delete user data  ");
        System.out.println("4 : getAlluserdata ");
        System.out.println("5 : get user data by id ");

        System.out.println("6 : exit ");
        System.out.println("enter the choice");
    }

    // user add the data

    public void Adduserdata() throws SQLException {

        System.out.println("enter the fiestname:");
        String fname = scanner.nextLine();

        System.out.println("enter the lastname:");
        String lname = scanner.nextLine();
        System.out.println("enter the age:");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("enter the salary :");
        double salary = Double.parseDouble(scanner.nextLine());

        UserModel user = new UserModel();

        user.setUsername(fname);
        user.setLastname(lname);
        user.setAge(age);
        user.setSalary(salary);
        userService.AdduserData(user);

        System.out.println("user Addded Succcessfully");

    }

    // update user by id

    public void UpdateuserdataByid() throws SQLException {

        System.out.println("enter the id :");
        int userid = Integer.parseInt(scanner.nextLine());

        System.out.println("enter the fiestname:");
        String fname = scanner.nextLine();

        System.out.println("enter the lastname:");
        String lname = scanner.nextLine();
        System.out.println("enter the age:");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("enter the salary :");
        double salary = Double.parseDouble(scanner.nextLine());

        UserModel user = new UserModel();

        user.setUsername(fname);
        user.setLastname(lname);
        user.setAge(age);
        user.setSalary(salary);
        userService.UpdateuserByid(user, userid);

        System.out.println("user updated  Succcessfully");
    }

    // delete the user form the usedata

    public void DeleteuserdataByid() throws SQLException {
        System.out.println("enter the id of the user ");
        int userId = Integer.parseInt((scanner.nextLine()));

        userService.DeleteUserByid(userId);

        System.out.println("user deleted  succcesefully");

    }

    // get all user data

    public void Getuserdata() throws SQLException {

        List<UserModel> list = userService.GetuserData();
        System.out.println(list);

        System.out.println("user Addded Succcessfully");

    }

    public void GetuserdataByid() throws SQLException {

        System.out.println("enter the id of the user ");
        int userId = Integer.parseInt((scanner.nextLine()));

        UserModel userModel = new UserModel();

        userModel = userService.GetuserdataByid(userId);
        System.out.println(userModel);

        System.out.println("user get succcesefully");

    }

    public void exitFromdata() {

        try {
            int i = 5;
            System.out.print("exiting from the user.");
            while (i >= 0) {
                System.out.print(". ");
                Thread.sleep(500);
                i--;
            }
            ;

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("messsage error" + e.getMessage());
        }

    }

}
