package uz.pdp.backend.model.employee;

import uz.pdp.backend.model.Employee;

public class SellsManager extends Employee {

    private int soldCount;


    public SellsManager(String fullName, String email, int age, double baseSalary, int experience, int soldCount) {
        super(fullName, email, age, baseSalary, experience);
        this.soldCount = soldCount;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }

    @Override
    public String toString() {
        return "SellsManager{" + super.toString()+
                "soldCount=" + soldCount +
                '}';
    }
}
