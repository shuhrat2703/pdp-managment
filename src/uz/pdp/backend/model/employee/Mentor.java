package uz.pdp.backend.model.employee;

import uz.pdp.backend.model.Employee;

public class Mentor extends Employee {


    private int groupCount;


    public Mentor(String fullName, String email, int age, double baseSalary, int experience, int groupCount) {
        super(fullName, email, age, baseSalary, experience);
        this.groupCount = groupCount;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    @Override
    public String toString() {
        return "Mentor{" + super.toString()+
                "groupCount=" + groupCount +
                '}';
    }
}
