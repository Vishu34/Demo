package service;

import Dao.UserDao;
import model.UserModel;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private  UserDao userDao;

   public UserService(){
        userDao = new UserDao();

    }


    public  void AdduserData(UserModel user ) throws SQLException {
       userDao.Adduser(user);
    }


    public List<UserModel> GetuserData() throws SQLException {
       return  userDao.Getuser();
    }




    public UserModel GetuserdataByid(int id) throws  SQLException {

      return  userDao.GetuserdataByid(id);

    }


    public  void UpdateuserByid(UserModel user ,int  userid)throws  SQLException{

       userDao.UpdateuserByid(user , userid);

    }



    public void DeleteUserByid(int userid)throws  SQLException{

       userDao.DeleteuserByid(userid);


    }


}
