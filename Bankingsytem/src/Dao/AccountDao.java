package Dao;

import Util.DbUtil;
import model.AccountModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDao {



    public AccountDao(){

    }

    
    
    public boolean addAccountno(AccountModel accountModel){

        String sql ="INSERT INTO accounts (balance, security_key , account_no,  user_id)" +
                "VALUES" +
                " (? , ? , FLOOR(1000000000 + RAND() * 9000000000), (select id from user_details where email=?) )";
        String accountDetails="select * from accounts where account_no=?";

        String updateAccountid= "update user_details set account_id =? where email=?";



        boolean accountCreated= false;


        try(Connection con = DbUtil.getConnection();
            PreparedStatement ptmt = con.prepareStatement(sql);


        ){

           if(!getAccountExist(accountModel.getEmail())){
               ptmt.setDouble(1 , accountModel.getBalance());
               ptmt.setString(2 , accountModel.getSecurity_key());

               ptmt.setString(3 , accountModel.getEmail());





               int rowaffected=ptmt.executeUpdate();

               if(rowaffected>0){


                   System.out.println("account is created Successfully");
                  long  accountno = generateAccount(accountModel.getEmail());
                   System.out.println("your account number is :"+ accountno);




                   if(accountno!=0l){



                       // finding out the accountid to put into user-details
                       PreparedStatement ptmt3=con.prepareStatement(accountDetails);
                       ptmt3.setLong(1 , accountno);
                       ResultSet set = ptmt3.executeQuery();
                       if(set.next()){
                           int account_id= set.getInt("id");
                           AccountModel accountModel1 = new AccountModel();
                           accountModel1.setAccount_no(set.getLong("account_no"));
                           System.out.println(account_id);
                           if(account_id!=0l){
                               PreparedStatement ptmt4= con.prepareStatement(updateAccountid);
                               ptmt4.setInt(1 , account_id);
                               ptmt4.setString(2 ,accountModel.getEmail());
                               int roaffected= ptmt4.executeUpdate();
                               if(roaffected>0){
                                   System.out.println("account id have bee added to user table");
                               }else{
                                   System.out.println("user_details could'nt updated account_id");
                               }

                           }else{
                               System.out.println("account id is'nt creaeted will not get account id");
                           }
                       }else{
                           System.out.println(" account details query is not working.");

                       }

                       return accountCreated=true;

                   }else{

                   }

               }else{
                   System.out.println("please check your email");
                   return  accountCreated=false;
               }
           }else{
                System.out.println(" acccount is already exist");
            }



        }catch (Exception e){
            e.printStackTrace();
        }
return accountCreated;

    }






    public boolean getAccountExist(String email){


        String sql1 = "select * from accounts where user_id = (select id from user_details where email=?)";
        boolean accountExist=false;
        try(Connection con= DbUtil.getConnection();
            PreparedStatement ptmt= con.prepareStatement(sql1);

        ){
            ptmt.setString(1, email);
            ResultSet set = ptmt.executeQuery();

            if(set.next()){
                return accountExist=true;
            }else{
                return  accountExist=false;
            }

        }catch (Exception e){
            e.printStackTrace();

        }

        return accountExist;

    }


    public long generateAccount(String email){

        String sql1 = "select * from accounts where user_id = (select id from user_details where email=?)";
        long accountExist = 0L;
        try(Connection con= DbUtil.getConnection();
            PreparedStatement ptmt= con.prepareStatement(sql1);

        ){
            ptmt.setString(1, email);
            ResultSet set = ptmt.executeQuery();

            if(set.next()){
               accountExist= set.getLong("account_no");
               
            }else{
                return  accountExist=0L;
            }

        }catch (Exception e){
            e.printStackTrace();

        }

        return  accountExist;
    }





    public AccountModel getuserAccountDetails(Long accountno){

        AccountModel accountModel= new AccountModel();
        String sql1 = "select * from accounts where account_no= ?";

        try(Connection con= DbUtil.getConnection();
            PreparedStatement ptmt= con.prepareStatement(sql1);

        ){
            ptmt.setLong(1, accountno);
            ResultSet set = ptmt.executeQuery();

            if(set.next()){

                accountModel.setAcoount_id(set.getInt("id"));
                accountModel.setAccount_no(set.getLong("account_no"));
                accountModel.setBalance(set.getDouble("balance"));
                accountModel.setSecurity_key(set.getString("security_key"));
                accountModel.setUser_id(set.getInt("user_id"));


            }else{
                System.out.println(" there is no account here ");
            }

        }catch (Exception e){
            e.printStackTrace();

        }

        return  accountModel;
    }









}
