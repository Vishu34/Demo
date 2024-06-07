package model;

public class UserModel {

 
    private String username;
    private String lastname ;
    private int age ;
    private double salary;

    public UserModel(){}


    public UserModel( double salary, int age, String lastname, String username) {
    
        this.salary = salary;
        this.age = age;
        this.lastname = lastname;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UserModel{" +
               
                ", username='" + username + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
