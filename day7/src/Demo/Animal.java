package Demo;

public  class   Animal{
    private String name;
    private int age ;

    private Animal1 animal1;

    public Animal() {
    }

    public Animal(String name, int age, Animal1 animal1) {
        this.name = name;
        this.age = age;
        this.animal1 = animal1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal1 getAnimal1() {
        return animal1;
    }

    public void setAnimal1(Animal1 animal1) {
        this.animal1 = animal1;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +

                '}';
    }
}

