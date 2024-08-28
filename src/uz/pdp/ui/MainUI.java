package uz.pdp.ui;

import uz.pdp.backend.model.Employee;
import uz.pdp.backend.model.employee.Admin;
import uz.pdp.backend.model.employee.Mentor;
import uz.pdp.backend.model.employee.SellsManager;
import uz.pdp.backend.service.EmployeeService;
import static uz.pdp.backend.EmpType.*;

import java.util.Scanner;


public class MainUI {

    private static EmployeeService service = new EmployeeService(5);



    public static void main(String[] args) {
        System.out.println("Hello My User");

         while (true){
             System.out.println(UIUtils.MAIN_MENU.formatted(service.getCount()));
             Integer choose = UIUtils.getInt("Choose: ");
             switch (choose){
                 case 1:
                     showEmp();
                     break;
                 case 2:
                     addEmp();
                     break;
                 case 3:
                     deleteEmp();
                     break;
                 case 4:
                     updateEmp();
                     break;
                 case 0:
                     return;
                 default:
                     System.out.println("Wrong Option❌❌❌");
                     System.out.println("Try again❌❌❌");
             }
         }
    }

    private static void updateEmp() {
        while (true) {
            showEmployees();
            Integer count = service.getCount() +1;
            System.out.println(count+ ". Exit");
            Integer index = UIUtils.getInt("Choose Emp: ");
            if (count==index){
                return;
            }
            Employee employee = service.getEmployee(index);
            System.out.println(employee);
            String type = UIUtils.getType(employee);
            System.out.print(UIUtils.CHOOSE_EMP_FIELDS);
            String typeField = "";
            switch (type){
                case MENTOR:
                    typeField = "Group Count";
                    break;
                case ADMIN:
                    typeField = "WorkedHour";
                    break;
                case SELLS_MANAGER:
                    typeField = "SoldCount";
                    break;
            }
            System.out.println("6."+typeField);
            Integer fieldNumber= UIUtils.getInt("Choose : ");
            changeEmployeeByField(fieldNumber, employee,index);
        }
    }

    private static void changeEmployeeByField(int fieldNumber,Employee employee,Integer empIndex) {

        switch (fieldNumber){
            case 1:
                String newFullName = UIUtils.getStr("Enter New Full Name: ");
                employee.setFullName(newFullName);
                break;
            case 2:
                String newEmail = UIUtils.getStr("Enter New Email: ");
                employee.setEmail(newEmail);
                break;
            case 3:
                Integer newAge = UIUtils.getInt("Enter New Age: ");
                employee.setAge(newAge);
                break;
            case 4:
                Double newBaseSalary = UIUtils.getDouble("Enter New BaseSalary: ");
                employee.setBaseSalary(newBaseSalary);
                break;
            case 5:
                Integer newExperience = UIUtils.getInt("Enter New Experience: ");
                employee.setExperience(newExperience);
                break;
            case 6:
                String type = UIUtils.getType(employee);
                switch (type){
                    case MENTOR -> {
                        Integer newGroupCount = UIUtils.getInt("Enter New Group Count: ");
                        Mentor mentor = (Mentor) employee;
                        mentor.setGroupCount(newGroupCount);
                    }
                    case ADMIN -> {
                        Integer newWorkedHour = UIUtils.getInt("Enter New Worked Hour: ");
                        Admin admin = (Admin) employee;
                        admin.setWorkedHour(newWorkedHour);
                    }
                    case SELLS_MANAGER -> {
                        Integer newSoldCount = UIUtils.getInt("Enter New Sold Count: ");
                        SellsManager sellsManager = (SellsManager) employee;
                        sellsManager.setSoldCount(newSoldCount);
                    }
                }
                break;
        }
        System.out.println("Updated Successfully");
    }

    private static void deleteEmp() {
        showEmployees();
        Integer chooseEmp = UIUtils.getInt("Choose Emp: ");
        boolean isDelete = service.delete(chooseEmp - 1);
        if (isDelete){
            System.out.println("Deleted Successfully");
        }else {
            System.out.println("Something Wrong");
        }
    }

    private static void addEmp() {
        while (true){

            System.out.println(UIUtils.CHOOSE_EMP_TYPE);
            Integer type = UIUtils.getInt("Choose Type: ");
            if (type==0){
                return;
            } else if (type>3||type<1) {
                System.out.println("Wrong Option❌❌❌");
                System.out.println("Try again❌❌❌");
                continue;
            }

            Employee employee = null;


            System.out.println("Enter Employee Info: ");
            String fullName = UIUtils.getStr("Full Name: ");
            String email = UIUtils.getStr("Email: ");
            int age = UIUtils.getInt("Age: ");
            double baseSalary = UIUtils.getInt("Base Salary: ");
            int experience = UIUtils.getInt("Experience: ");
            switch (type){
                case 1:
                    int workedHour = UIUtils.getInt("WorkedHour: ");
                    employee = new Admin(fullName, email, age, baseSalary, experience, workedHour);
                    break;
                case 2:
                    int countGroup = UIUtils.getInt("Count Group: ");
                    employee = new Mentor(fullName, email, age, baseSalary, experience, countGroup);
                    break;
                case 3:
                    int soldCount = UIUtils.getInt("Sold Count: ");
                    employee = new SellsManager(fullName, email, age, baseSalary, experience, soldCount);
                    break;
                default:
                    System.out.println("Wrong Option❌❌❌");
                    System.out.println("Try again❌❌❌");
            }
            if (employee!=null)
                service.add(employee);
        }
    }

    private static void showEmp() {
      while (true){
          showEmployees();
          System.out.println("0.Back🔙");
          Integer chooseEmp = UIUtils.getInt("Choose Employee: ")-1;
          if (chooseEmp==0){
              return;
          }
          Employee employee = service.getEmployee(chooseEmp-1);
          if (employee==null){
              System.out.println("Wrong Option❌❌❌");
              System.out.println("Try again❌❌❌");
              continue;
          }
          System.out.println("=======================================");
          System.out.println(employee);
          System.out.println("=======================================");
      }
  }

    private static void showEmployees(){
        Employee[] employees = service.getEmployees();
        Integer count = service.getCount();
        System.out.println("=======================================");
        for (int i = 0; i < count; i++) {
          Employee employee = employees[i];
            String type = UIUtils.getType(employee);
            System.out.println((i+1)+". "+employee.getFullName()+"("+type+")");
        }
    }

}
