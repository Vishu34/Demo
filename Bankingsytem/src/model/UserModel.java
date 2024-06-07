
package  model;


import java.util.List;

public class UserModel {

    private int user_id;
    private String username ;
    private String email;
    private  String password;
    private String userType;
    private AccountModel accountModel;
    private List<TransactionModel> transactionModel;



    public UserModel(){
accountModel = new AccountModel();
    }

    public UserModel(int user_id, List<TransactionModel> transactionModel, AccountModel accountModel, String userType, String password, String email, String username) {
        this.user_id = user_id;
        this.transactionModel = transactionModel;
        this.accountModel = accountModel;
        this.userType = userType;
        this.password = password;
        this.email = email;
        this.username = username;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public AccountModel getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(AccountModel accountModel) {
        this.accountModel = accountModel;
    }

    public List<TransactionModel> getTransactionModel() {
        return transactionModel;
    }

    public void setTransactionModel(List<TransactionModel> transactionModel) {
        this.transactionModel = transactionModel;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", accountModel=" + accountModel +
                ", transactionModel=" + transactionModel +
                '}';
    }
}

