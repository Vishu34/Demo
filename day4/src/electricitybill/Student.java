package electricitybill;

public class Student implements  Trial , Comparable<Student> {

   private int rollNO;
   private String name;

    public int getRollNO() {
        return rollNO;
    }

    public Student(int rollNO, String name) {
        this.rollNO = rollNO;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRollNO(int rollNO) {
        this.rollNO = rollNO;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }



    @Override
    public int rollNo() {
        return 0;
    }

    @Override
    public void display() {
        System.out.println("this is the method");
    }

    @Override
    public String toString() {
        return "Student{}";
    }

    @Override
    public int compareTo(Student student) {
        if (rollNO > student.rollNO) {
            System.out.println("roll no. is greater than " + rollNO);
            return rollNO;
        } else if (rollNO < student.rollNO) {
            System.out.println("roll no. is less than " + rollNO);
            return rollNO;
        } else {
            System.out.println(" student roll no. is equal to the  " + rollNO);
            return rollNO;
        }
    }
}
