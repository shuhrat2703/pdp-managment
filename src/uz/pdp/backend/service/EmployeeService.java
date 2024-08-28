package uz.pdp.backend.service;

import uz.pdp.backend.model.Employee;
import uz.pdp.backend.model.employee.Admin;
import uz.pdp.backend.model.employee.Mentor;
import uz.pdp.backend.model.employee.SellsManager;

public class EmployeeService {

    private Employee[] employees;    // {emp1,emp2,emp3,null,null}

    private int count;

    public EmployeeService(int startLength) {
        this.employees = new Employee[startLength];
        this.count = 0;

        this.employees[0] = new Admin("Salim","s@s", 21, 1000, 3, 160);
        this.employees[1] = new Mentor("Ahmad","s@s", 21, 1000, 3, 160);
        this.employees[2] = new SellsManager("Ali","s@s", 21, 1000, 3, 160);
        this.count = 3;
    }



    public void add(Employee employee){
        if (count< employees.length) {
            employees[count] = employee;
            count++;
        }
    }
    public Employee getEmployee(Integer index){
        if (index>=0&&index<count){
            Employee employee = employees[index];
            return employee;
        }
        return null;
    }


    public Employee[] getEmployees(){
        return employees;
    }

    public Integer getCount(){
        return count;
    }
    // {emp1,emp2,emp3,emp4,null}
    // {emp1,emp3,emp4,emp4,null}

    public boolean delete(Integer index){
        if (index>=0 && index<count){
            count--;
            System.arraycopy(employees,index+1,employees,index,count-index);
            employees[count] = null;

            return true;
        }
        return false;

    }

    public boolean update(Employee employee,Integer index){
        if (index>=0&&index<count) {
            employees[index] = employee;
            return true;
        }
        return false;
    }
}
