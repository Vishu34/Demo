package model;

public class AccountModel {


    private int acoount_id;
  private int user_id;
    private  String email;
    private double balance;
    private String security_key;
    private long account_no;



    public AccountModel() {
    }

    public AccountModel(int acoount_id, int user_id, String email, double balance, String security_key, long account_no) {
        this.acoount_id = acoount_id;
        this.user_id = user_id;
        this.email = email;
        this.balance = balance;
        this.security_key = security_key;
        this.account_no = account_no;
    }

    public int getAcoount_id() {
        return acoount_id;
    }

    public void setAcoount_id(int acoount_id) {
        this.acoount_id = acoount_id;
    }

    public long getAccount_no() {
        return account_no;
    }

    public void setAccount_no(long account_no) {
        this.account_no = account_no;
    }

    public String getSecurity_key() {
        return security_key;
    }

    public void setSecurity_key(String security_key) {
        this.security_key = security_key;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "acoount_id=" + acoount_id +
                ", user_id=" + user_id +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", security_key='" + security_key + '\'' +
                ", account_no=" + account_no +
                '}';
    }
}
