package uz.pdp.backend.model;

public abstract class Employee {
    private String fullName;
    private String email;
    private int age;
    private double baseSalary;
    private int experience;

    public Employee() {

    }

    public Employee(String fullName, String email, int age, double baseSalary, int experience) {
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.baseSalary = baseSalary;
        this.experience = experience;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", baseSalary=" + baseSalary +
                ", experience=" + experience +
                '}';
    }
}
