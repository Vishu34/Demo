package interfacemethod;

public class Student implements  Trial , Comparable<Student>{

    private  String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public Student() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void display() {

    }

    @Override
    public void enjoying() {

    }

    @Override
    public int compareTo(Student student) {
        if(marks>student.marks){
            System.out.println("rollno is greater than student rollno");
            return marks;

        }else if(marks<student.marks){
            System.out.println("rollno is less than student rollno");
            return marks;
        }else{
            System.out.println("rollno is equal to student rollno");
            return marks;
        }
    }
}
