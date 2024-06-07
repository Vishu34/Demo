package Service;

import Dao.AccountDao;
import model.AccountModel;

public class AccountService {
    private AccountDao accountDao;


    public AccountService(){
        accountDao = new AccountDao();
    }


    public boolean createAccountno(AccountModel accountModel){

        boolean accountCreate=accountDao.addAccountno(accountModel);
        return accountCreate;


    }

    public AccountModel getAccountdetails(Long accountno){

        return accountDao.getuserAccountDetails(accountno);



    }
    
}
