package model;

import java.sql.Timestamp;

public class TransactionModel {


    private int tid;
    private long  reciever_accountno;
    private int sender_id;
    private String transaction_type;
    private double amount;
    private Timestamp date;






    public TransactionModel(){

    }

    public TransactionModel(int tid, Timestamp date, double amount, String transaction_type, int sender_id, long reciever_accountno) {
        this.tid = tid;
        this.date = date;
        this.amount = amount;
        this.transaction_type = transaction_type;
        this.sender_id = sender_id;
        this.reciever_accountno = reciever_accountno;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public long getReciever_accountno() {
        return reciever_accountno;
    }

    public void setReciever_accountno(long reciever_accountno) {
        this.reciever_accountno = reciever_accountno;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TransactionModel{" +
                "tid=" + tid +
                ", reciever_accountno=" + reciever_accountno +
                ", sender_id=" + sender_id +
                ", transaction_type='" + transaction_type + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}




