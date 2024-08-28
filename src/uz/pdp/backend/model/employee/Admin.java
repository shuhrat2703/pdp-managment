package uz.pdp.backend.model.employee;

import uz.pdp.backend.model.Employee;

public class Admin extends Employee {

    private int workedHour;

    public Admin(String fullName, String email, int age, double baseSalary, int experience, int workedHour) {
        super(fullName, email, age, baseSalary, experience);
        this.workedHour = workedHour;
    }

    public int getWorkedHour() {
        return workedHour;
    }

    public void setWorkedHour(int workedHour) {
        this.workedHour = workedHour;
    }

    @Override
    public String toString() {
        return "Admin{" + super.toString()+
                "workedHour=" + workedHour +
                '}';
    }
}
