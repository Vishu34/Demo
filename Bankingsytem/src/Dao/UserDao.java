package Dao;

import Util.DbUtil;
import model.AccountModel;
import model.TransactionModel;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class UserDao {


    public void userRegistration(UserModel user) {

        String sql = "insert into user_details (username , email , password , usertype)" +
                "values(? ,? , ?, ?)";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement ptmt = connection.prepareStatement(sql);

        ) {


            if (!userAlreadyExist(user.getEmail())) {

                ptmt.setString(1, user.getUsername());
                ptmt.setString(2, user.getEmail());
                ptmt.setString(3, user.getPassword());
                ptmt.setString(4, user.getUserType());
                int rowaffected = ptmt.executeUpdate();


                if (user.getUsername().isEmpty()) {
                    System.out.println("user is required please fill username ");
                } else if (user.getEmail().isEmpty()) {
                    System.out.println("email is required please fill email");
                } else if (user.getPassword().isEmpty()) {
                    System.out.println("password is required please fill password");
                } else if (!user.getUsername().isEmpty() || !user.getEmail().isEmpty() || !user.getPassword().isEmpty()) {
                    if (rowaffected > 0) {
                        System.out.println(rowaffected);
                        System.out.println(" registration successfully");
                    } else {
                        System.out.println("registraion failed");
                        System.out.println(rowaffected);
                    }

                }

            } else {
                System.out.println("user email is already exist");
            }


        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    public boolean userAlreadyExist(String email) {


        String sql = "select * from user_details where email=?";


        boolean emialexist = false;
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ptmt = con.prepareStatement(sql);

        ) {
            ptmt.setString(1, email);

            ResultSet set = ptmt.executeQuery();
            if (set.next()) {
                return
                        emialexist = true;
            } else {
                return
                        emialexist = false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return emialexist;


    }


    public UserModel userLogin(String email , String password) {

        UserModel userModel = null;
        String sql = "select * from user_details where email=? and password=?";

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement ptmt = connection.prepareStatement(sql);

        ) {


            ptmt.setString(1, email);
            ptmt.setString(2, password);
            ResultSet set = ptmt.executeQuery();

            if (set.next()) {
                userModel= new UserModel();
                userModel.setUser_id(set.getInt("id"));
                userModel.setUsername(set.getString("username"));
                userModel.setEmail(set.getString("email"));
                userModel.setPassword(set.getString("password"));
                userModel.setUserType(set.getString("userType"));




            } else {
                return userModel;

            }


        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return userModel;

    }


//get all user and their acccounts

    public List<UserModel> getAlluserAccoount() {


        List<UserModel> users = new ArrayList<>();




        String allUserAccount = "select * from user_details , accounts , transaction";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ptmt = con.prepareStatement(allUserAccount)) {

            ResultSet set = ptmt.executeQuery();
            while (set.next()) {
                UserModel userModel = new UserModel();
                userModel.setUser_id(set.getInt("id"));
                userModel.setUsername(set.getString("username"));
                userModel.setEmail(set.getString("email"));
                userModel.setPassword(set.getString("password"));



                users.add(userModel);



            }





        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }


    public UserModel getParticularuser(int userId) {
        UserModel user = new UserModel();

        String userQuery = "SELECT * FROM user_details WHERE id = ?";
        String userAccountQuery = "SELECT * FROM accounts WHERE user_id = ?";
        String userTransactionQuery = "SELECT * FROM transaction WHERE sender_id = (SELECT account_id FROM user_details WHERE id = ?)";

        try (Connection con = DbUtil.getConnection()) {

            // Fetch user details
            try (PreparedStatement ptmt = con.prepareStatement(userQuery)) {
                ptmt.setInt(1, userId);
                ResultSet set = ptmt.executeQuery();
                if (set.next()) {
                    user.setUser_id(set.getInt("id"));
                    user.setUsername(set.getString("username"));
                    user.setEmail(set.getString("email"));
                    user.setPassword(set.getString("password"));
                }
            }

            // Fetch account details
            try (PreparedStatement ptmt2 = con.prepareStatement(userAccountQuery)) {
                ptmt2.setInt(1, userId);
                ResultSet set2 = ptmt2.executeQuery();
                if (set2.next()) {
                    AccountModel accountModel = new AccountModel();
                    accountModel.setAcoount_id(set2.getInt("id"));
                    accountModel.setAccount_no(set2.getLong("account_no"));
                    accountModel.setBalance(set2.getDouble("balance"));
                    accountModel.setSecurity_key(set2.getString("security_key"));
                    user.setAccountModel(accountModel);
                }
            }

            // Fetch transaction details
            try (PreparedStatement ptmt3 = con.prepareStatement(userTransactionQuery)) {
                ptmt3.setInt(1, userId);
                ResultSet set3 = ptmt3.executeQuery();
                List<TransactionModel> transactionList = new ArrayList<>();
                while (set3.next()) {

                    TransactionModel transactionModel = new TransactionModel();
                    transactionModel.setTransaction_type(set3.getString("transaction_type"));
                    transactionModel.setReciever_accountno(set3.getLong("reciever_accountno"));
                    transactionModel.setSender_id(set3.getInt("sender_id"));
                    transactionModel.setAmount(set3.getDouble("amount"));
                    transactionModel.setDate(set3.getTimestamp("created_date"));
                    transactionList.add(transactionModel);

                    user.setTransactionModel(transactionList);
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }




    /// delete particular user


    public  boolean deleteUserAccount(int userid){

        String sql = " delete from user_details where id =?";

        boolean userdeleted= false;
        try(Connection con= DbUtil.getConnection();
        PreparedStatement ptmt=con.prepareStatement(sql)){

            ptmt.setInt(1 , userid);
            int rowAffected = ptmt.executeUpdate();

            if(rowAffected>0){
                System.out.println(" user is deleted successfully");
                return userdeleted=true;

            }else{
                System.out.println(" user is not deleted please check");
                return  userdeleted=false;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return userdeleted;
    }




    // update the user account


    public  void updateUserAccount(UserModel userModel , String security_key, int userid) {

        String sql1, sql2;

        sql1 = "update user_details set username=? ,  email=?  , password =? where id=? ";

        sql2 = "update accounts set  security_key=? where user_id =?";

        try (Connection con = DbUtil.getConnection();
             PreparedStatement ptmt = con.prepareStatement(sql1);
             PreparedStatement ptmt1 = con.prepareStatement(sql2)) {

            ptmt.setString(1, userModel.getUsername());
            ptmt.setString(2, userModel.getEmail());
            ptmt.setString(3, userModel.getPassword());
            ptmt.setInt(4, userid);


            int rowAffected = ptmt.executeUpdate();

            ptmt1.setString(1 , security_key);
            ptmt1.setInt(2 , userid);

            int rowaffected1 = ptmt1.executeUpdate();


            if (rowAffected>0 && rowaffected1>0) {
                System.out.println(" user is updated successfully");
            } else {
                System.out.println(" user is not updated please check");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }






}
