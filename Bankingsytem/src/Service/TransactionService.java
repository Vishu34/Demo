package Service;

import Dao.TransactionDao;
import model.AccountModel;
import model.TransactionModel;

import java.util.List;

public class TransactionService {

    private  TransactionDao transactionDao;

    public TransactionService (){
        transactionDao= new TransactionDao();
    }

    public void transactionAmount( TransactionModel  transactionModel,Long accountno, String security_key){
        transactionDao.transactionAmount( transactionModel ,accountno, security_key);
    }

    public List<TransactionModel> getAccountdetails(Long accountno) {

        return transactionDao.getTransactionDetails(accountno);

    }



}
