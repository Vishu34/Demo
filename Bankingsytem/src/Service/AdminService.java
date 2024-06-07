package Service;

import Dao.AccountDao;
import Dao.AdminDao;
import Dao.UserDao;
import model.AccountModel;
import model.AlluserModel;
import model.UserModel;

import java.sql.SQLException;
import java.util.List;

public class AdminService {

    private AdminDao adminDao;


    public AdminService() {
        adminDao= new AdminDao();
    }

    public List<AccountModel> getAccountDetails(){

        System.out.println("hllsdfas");

        return adminDao.getAccountDetails();
    }


    public List<AlluserModel> getallUser(){


        return adminDao.getAlluserAccoount();
    }




    public UserModel getParticularuser(int userid)  {
        return  adminDao.getParticularuser(userid);

    }

    public boolean deleteUserAccount(int userid)  {
        return adminDao.deleteUserAccount(userid);

    }

    public void udpdateUseAccount(UserModel userModel, String security_key , int  userid)  {
        adminDao.updateUserAccount(userModel ,security_key, userid);

    }
}
