package Dao;

import Util.DbUtil;
import model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {



    


    public   void Adduser(UserModel user) throws SQLException {

        String q = "insert into user (username , lastname , age , salary) values (? , ? , ? , ?)  ";
        try(
                Connection con= DbUtil.getConnection();
                PreparedStatement ptmt = con.prepareStatement(q);


        ){

            ptmt.setString( 1, user.getUsername());
            ptmt.setString(2, user.getLastname());
            ptmt.setInt(3, user.getAge());
            ptmt.setDouble( 4 , user.getSalary());
            ptmt.executeUpdate();




        }
    }

    public  List<UserModel> Getuser() throws SQLException {

        List<UserModel> users = new ArrayList<>();
        String q = "select * from user  ";
        try(
                Connection con= DbUtil.getConnection();
                Statement stmt = con.createStatement();
                ResultSet set = stmt.executeQuery(q);

        ){


            while(set.next()){
               UserModel user = new UserModel();
               user.setUsername(set.getString("username"));
                user.setLastname(set.getString("lastname"));
                user.setAge(set.getInt("age"));
                user.setSalary(set.getDouble("salary"));
               users.add(user);

            }

            return users;



        }
    }



    public  UserModel GetuserdataByid(int id ){


        String q = "select * from user where id = ?  ";
        UserModel userModel =null;
        try (
                Connection con = DbUtil.getConnection();
                PreparedStatement stmt = con.prepareStatement(q);


        ) {

             stmt.setInt(1 , id);

          ResultSet set = stmt.executeQuery();
          while(set.next()){
           userModel = new UserModel();
              userModel.setUsername(set.getString("username"));
              userModel.setLastname(set.getString("lastname"));
              userModel.setAge(set.getInt("age"));
              userModel.setSalary(set.getDouble("salary"));

          }

        }catch(Exception e){
            e.printStackTrace();
        }

        return userModel;
    }



    public  void UpdateuserByid(UserModel user , int userId)throws  SQLException{

        String sql = "update user set username=? , lastname=? , age=? , salary=? where id=?";
        try(Connection con= DbUtil.getConnection();
        PreparedStatement ptmt = con.prepareStatement(sql);

        ){


            ptmt.setString(1 ,user.getUsername());
           ptmt.setString(2 , user.getLastname());
           ptmt.setInt(3, user.getAge());
           ptmt.setDouble(4, user.getSalary());

            ptmt.setInt(5 , userId);
            ptmt.executeUpdate();
        }

    }

    public  void DeleteuserByid(int userid )throws  SQLException{

        String  q="Delete from user where id=?";
        try(Connection con =DbUtil.getConnection();
        PreparedStatement ptmt = con.prepareStatement(q);
        ){
            ptmt.setInt(1 , userid);
        }

    }


}
