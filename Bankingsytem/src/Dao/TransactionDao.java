package Dao;

import Util.DbUtil;
import model.AccountModel;
import model.TransactionModel;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {



    public void transactionAmount( TransactionModel  transactionModel , Long accountno, String security_key){

       boolean success =false;
      switch (transactionModel.getTransaction_type()){
          case "withdraw":
             success= withDrawTransaction(  transactionModel ,accountno, security_key);
              break;

          case "deposit":
              success=depositTransaction(   transactionModel ,accountno, security_key);
              break;
          case "transfer":
              success=transferTransaction(   transactionModel ,accountno, security_key);
              break;
      }

if(success){
    transactionAdding(  transactionModel ,accountno , security_key );
}else{
    System.out.println(transactionModel.getAmount() + " is failed plese check accoutn or security key");
}




    }




    public  boolean withDrawTransaction( TransactionModel transactionModel ,Long accountno ,   String security_key){


        String q=" update accounts set balance = balance - ? where account_no=? and security_key=?";

       String checkbalace= "select balance from accounts where account_no=?";

boolean withdraw=false;

       try(Connection con = DbUtil.getConnection()){
           con.setAutoCommit(false);
           try( PreparedStatement ptmt= con.prepareStatement(q);
                PreparedStatement ptmt1= con.prepareStatement(checkbalace)){

               ptmt1.setLong(1 ,accountno );
               ResultSet set = ptmt1.executeQuery();

               if(set.next()){
                   Double  check_balance= set.getDouble("balance");


                       if(transactionModel.getAmount()<=check_balance){

                           ptmt.setDouble(1 ,transactionModel.getAmount());
                           ptmt.setLong(2 , accountno);
                           ptmt.setString(3, security_key);
                           int rowaffected= ptmt.executeUpdate();

                           if(rowaffected>0){
                               System.out.println("withdraw successfully");
                               con.commit();
                               con.setAutoCommit(true);
                               return  withdraw =true;
                           }else{
                               System.out.println("transaction failed please check your accoutn or security_key");
                               return  withdraw=false;
                           }

                       }else{
                           System.out.println("in sufficient balance");
                       }

               }

           }

           catch (Exception e){
               e.printStackTrace();
               con.rollback();

           }




       }catch (Exception e){
e.printStackTrace();
       }
        return withdraw;
    }




    public  boolean depositTransaction( TransactionModel transactionModel ,Long accountno ,  String security_key){

        String q=" update accounts set balance = balance + ? where account_no=? and security_key=?";


        String checkbalace= "select balance from accounts where account_no=?";

boolean deposit = false;

        try(Connection con = DbUtil.getConnection()){
            con.setAutoCommit(false);
            try( PreparedStatement ptmt= con.prepareStatement(q);
                 PreparedStatement ptmt1= con.prepareStatement(checkbalace)){

                ptmt1.setLong(1 ,accountno);
                ResultSet set = ptmt1.executeQuery();
                if(set.next()){
                    Double  check_balance= set.getDouble("balance");

                    if(transactionModel.getAmount()<=check_balance){

                        ptmt.setDouble(1 ,transactionModel.getAmount());
                        ptmt.setLong(2 , accountno);
                        ptmt.setString(3, security_key);
                        int rowaffected= ptmt.executeUpdate();

                        if(rowaffected>0){
                            System.out.println("deposit successfully");
                            con.commit();
                            con.setAutoCommit(true);
                            return deposit =true;
                        }else{
                            System.out.println("transaction failed");
                            return deposit =false;
                        }

                    }else{
                        System.out.println("please check your security key or account no.");
                    }
                }

            }

            catch (Exception e){
                e.printStackTrace();
                con.rollback();

            }




        }catch (Exception e){
            e.printStackTrace();
        }
        return  deposit;
    }

    public  boolean transferTransaction( TransactionModel transactionModel ,Long accountno ,  String security_key){

        String sender=" update accounts set balance = balance - ? where account_no=? and security_key=?";

        String reciever=" update accounts set balance = balance + ? where account_no=?";

        String checkbalace= "select balance from accounts where account_no=?";

boolean transfer=false;

        try(Connection con = DbUtil.getConnection()){
            con.setAutoCommit(false);
            try( PreparedStatement ptmt= con.prepareStatement(sender);
                 PreparedStatement ptmt2= con.prepareStatement(reciever);
                 PreparedStatement ptmt1= con.prepareStatement(checkbalace);

                ){
                   ptmt1.setLong(1 , accountno);


                ResultSet set = ptmt1.executeQuery();
                if(set.next()){
                    Double  check_balance= set.getDouble("balance");

                    if(transactionModel.getAmount()<=check_balance){

                        ptmt.setDouble(1 ,transactionModel.getAmount());
                        ptmt.setLong(2 , accountno);
                        ptmt.setString(3, security_key);
                        int rowaffected= ptmt.executeUpdate();

                        if(rowaffected>0){

                            ptmt2.setDouble(1 , transactionModel.getAmount());
                            ptmt2.setLong(2, transactionModel.getReciever_accountno());
                            int rowAffect= ptmt2.executeUpdate();

                            if(rowAffect>0){
                                System.out.println("transfer successfully");

                            }else{
                                System.out.println("please reciever account no");

                            }
                            con.commit();
                            con.setAutoCommit(true);
                            return  transfer=true;
                        }else{
                            System.out.println("transaction failed");
                            return  transfer =false;
                        }

                    }else{
                        System.out.println("please check your accoutn no or security key");
                    }
                }

            }

            catch (Exception e){
                e.printStackTrace();
                con.rollback();

            }




        }catch (Exception e){
            e.printStackTrace();
        }
        return  transfer;
    }

    public void transactionAdding( TransactionModel transactionModel , Long accountno, String security_key){

//
        String q = "insert into transaction (transaction_type , reciever_accountno, sender_id , amount )" +
                "values (? , ? ,? ,? )";

//      String q="  insert into transaction (transaction_type ,  reciever_accountno ,sender_id ,  amount) " +
//              "values ((select id from accounts where account_no=6672798696) , ? ,? ,?  ,? )";

        String senderid = "select * from accounts where account_no=?";

       try(Connection con = DbUtil.getConnection();


       ){
           try(PreparedStatement ptmt = con.prepareStatement(q);
           PreparedStatement ptmt1 = con.prepareStatement(senderid)){

               ptmt1.setLong(1 , accountno);
               ResultSet set = ptmt1.executeQuery();
               if(set.next()){
                   int sender_id =set.getInt("id");


                   if(sender_id!=0){
                      if(transactionModel.getTransaction_type()=="withdraw" || transactionModel.getTransaction_type()=="deposit"){
                          ptmt.setString(1 ,transactionModel.getTransaction_type());
                          ptmt.setLong(2 , transactionModel.getReciever_accountno());
                          ptmt.setInt(3 , sender_id);
                          ptmt.setDouble(4 , transactionModel.getAmount());
                      }else{
                          ptmt.setString(1 ,transactionModel.getTransaction_type());
                          ptmt.setLong(2 , transactionModel.getReciever_accountno());
                          ptmt.setInt(3 , sender_id);
                          ptmt.setDouble(4 , transactionModel.getAmount());
                      }

                      int rowaffected = ptmt.executeUpdate();

                      if(rowaffected>0){
                          System.out.println(transactionModel.getTransaction_type() + " successfully");
                      }else {
                          System.out.println("transaction failed");
                      }


                   }else{
                       System.out.println("senderid is no exist");
                   }
               }else {
                   System.out.println(" account no. is not exist ");
               }

           }catch (Exception e){
               e.printStackTrace();
//
           }

       }catch (Exception e){
e.printStackTrace();
       }

    }



    public List<TransactionModel> getTransactionDetails(Long accountno){

        List <TransactionModel> transactionList = new ArrayList<>();

        String sql1 = "select * from transaction where sender_id= (select id from accounts " +
                "where account_no=?)";

        try(Connection con= DbUtil.getConnection();
            PreparedStatement ptmt= con.prepareStatement(sql1);

        ){
            ptmt.setLong(1, accountno);
            ResultSet set = ptmt.executeQuery();




                while(set.next()){
                    TransactionModel transactionModel= new TransactionModel();
                    transactionModel.setTransaction_type(set.getString("transaction_type"));
                    transactionModel.setReciever_accountno(set.getLong("reciever_accountno"));
                    transactionModel.setSender_id(set.getInt("sender_id"));
                    transactionModel.setTid(set.getInt("tid"));
                    transactionModel.setAmount(set.getDouble("amount"));
                    transactionList.add(transactionModel);
                }



        }catch (Exception e){
            e.printStackTrace();

        }

        return  transactionList;
    }








}
