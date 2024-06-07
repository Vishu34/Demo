package Dao;

import Util.DbUtil;
import model.AccountModel;
import model.AlluserModel;
import model.TransactionModel;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

//    private int acoount_id;
//    private int user_id;
//    private  String email;
//    private double balance;
//    private String security_key;
//    private long account_no;
//    private model.AlluserModel userModel;



    public List<AccountModel> getAccountDetails() {

        List<AccountModel> list = new ArrayList<>();
       String q="select * from accounts a, user_details u where a.user_id=u.id";
       try(Connection con = DbUtil.getConnection();
           PreparedStatement ptmt = con.prepareStatement(q)){

           ResultSet set = ptmt.executeQuery();

           while(set.next()){
               AccountModel accountModel = new AccountModel();
               accountModel.setAcoount_id(set.getInt("id"));
               accountModel.setAccount_no(set.getLong("account_no"));
               accountModel.setBalance(set.getDouble("balance"));
               accountModel.setSecurity_key(set.getString("security_key"));




list.add(accountModel);

           }
       }catch (Exception e){
           e.printStackTrace();
       }

return  list;
    }



//    /get all user a

    ///get all user and their acccounts
    public List<AlluserModel> getAlluserAccoount() {


        List<AlluserModel> users = new ArrayList<>();



        String allUserAccount = "select * from user_details where usertype='user' ";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ptmt = con.prepareStatement(allUserAccount)) {

            ResultSet set = ptmt.executeQuery();
            while (set.next()) {

                AlluserModel userModel = new AlluserModel();

                userModel.setUser_id(set.getInt("id"));
                userModel.setUsername(set.getString("username"));
                userModel.setEmail(set.getString("email"));
                userModel.setPassword(set.getString("password"));
                userModel.setUserType(set.getString("userType"));
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







