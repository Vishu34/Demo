package Service;

import Dao.UserDao;
import model.UserModel;

import java.lang.foreign.SegmentAllocator;
import java.util.List;

public class UserService {

    private  UserDao userDao;

    public  UserService(){
        userDao= new UserDao();
    }



    public  void userRegistration(UserModel user){

        userDao.userRegistration(user);

    }

    public  UserModel userLogin(String email  , String password ){


       return userDao.userLogin(email , password);


    }


    public List<UserModel> getAlluser(){
       return  userDao.getAlluserAccoount();
    }


    public UserModel getParticularuser(int userid)  {
       return  userDao.getParticularuser(userid);

    }

    public boolean deleteUserAccount(int userid)  {
        return userDao.deleteUserAccount(userid);

    }

    public void udpdateUseAccount(UserModel userModel, String security_key , int  userid)  {
        userDao.updateUserAccount(userModel ,security_key, userid);

    }

}
