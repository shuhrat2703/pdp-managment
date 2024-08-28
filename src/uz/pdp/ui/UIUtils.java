package uz.pdp.ui;


import uz.pdp.backend.EmpType;
import uz.pdp.backend.model.Employee;
import uz.pdp.backend.model.employee.Admin;
import uz.pdp.backend.model.employee.Mentor;
import uz.pdp.backend.model.employee.SellsManager;

import static uz.pdp.backend.EmpType.*;

import java.util.Scanner;

public class UIUtils {
    public static final String MAIN_MENU = """
                    Employee Menu
            1.Show (%s)
            2.Add
            3.Delete
            4.Update """;

    public static final String CHOOSE_EMP_TYPE = """
                   Employee Menu
            1.Admin
            2.Mentor
            3.Sells Manager
            4.Back """;

    public static final String CHOOSE_EMP_FIELDS = """
                    Choose Field
                1.FullName
                2.Email
                3.Age
                4.BaseSalary
                5.Experience
                """;


    private static final Scanner scannerStr = new Scanner(System.in);

    private static final Scanner scannerInt = new Scanner(System.in);

    public static String getStr(String hint){
        Scanner scanner = new Scanner(System.in);
        System.out.print(hint);
        return scanner.nextLine();
    }
    public static Integer getInt(String hint){
        Scanner scanner = new Scanner(System.in);
        System.out.print(hint);
        return scanner.nextInt();
    }
    public static Double getDouble(String hint){
        Scanner scanner = new Scanner(System.in);
        System.out.print(hint);
        return scanner.nextDouble();
    }

    public static String getType(Employee employee){
        if (employee instanceof Admin){
            return ADMIN;
        } else if (employee instanceof Mentor) {
            return MENTOR;
        } else if (employee instanceof SellsManager) {
            return SELLS_MANAGER;
        }
        return "";
    }
}
