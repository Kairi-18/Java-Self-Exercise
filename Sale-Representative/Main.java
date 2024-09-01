import java.util.Scanner;

public class Main {
    private int baseSalary = 0;
    private double bonus = 0.0, commission = 0.0, sales = 0.0, service = 0.0;
    private String[] type = {"Probationary Employee", "Regular Employee"};
    private String employeeType = "";

    static Scanner input = new Scanner(System.in);

    public Main(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void allofit() {
        setEmployee(); // Set employee type first

        if (employeeType.equals(type[1])) { // Regular Employee
            getRegularEmployee();
            totalSales();
            displayTotalCompensation();
        } else if (employeeType.equals(type[0])) { // Probationary Employee
            getProbationaryEmployee();
            totalSales();
            displayTotalCompensation();
        }
    }

    private void setEmployee() {
        System.out.println("[ 'R' | 'r'] Regular Employee");
        System.out.println("[ 'P' | 'p'] Probationary Employee");
        System.out.println("Please enter employee type: ");
        char inputChar = input.next().charAt(0);

        if (inputChar == 'r' || inputChar == 'R') {
            employeeType = type[1];
        } else if (inputChar == 'p' || inputChar == 'P') {
            employeeType = type[0];
        } else {
            System.out.println("Invalid input. Please enter 'R' or 'P'.");
            setEmployee(); // Retry if the input is invalid
        }
    }

    private void getRegularEmployee() {
        System.out.print("Enter number of service year/s: ");
        service = input.nextInt();

        if (service > 0 && service < 5) {
            bonus = service * 1000.00;
        } else if (service >= 5) {
            bonus = service * 2000.00;
        } else {
            System.out.println("Invalid number of years.");
            return;
        }
    }

    private void getProbationaryEmployee() {
        System.out.print("Enter number of service month/s: ");
        service = input.nextInt();

        if (service > 0 && service <= 6) {
            bonus = service * 300.00;
        } else if (service > 6 && service <= 12) {
            bonus = service * 600.00;
        } else {
            System.out.println("Invalid number of month/s!");
            return;
        }
    }

    private void totalSales() {
        System.out.println("Enter the total sales for this month: ");
         sales = input.nextDouble();

        if (sales < 10000) {
            commission = 0.00;
        } else if (sales >= 10000 && sales < 100000) {
            commission = sales * 0.04;
        } else {
            commission = sales * 0.08;
        }
    }
    private void displayTotalCompensation() {
      double totalSalary = baseSalary + bonus + commission;
      System.out.println("--------------------------------------------------");
      System.out.println("Type of Sales Representative: " + employeeType);
      System.out.println("Number of Service/s rendered: " + service + " year/s");
      System.out.println("Total Bonus: " + bonus);
      System.out.println("Sales: " + sales);
      System.out.println("Commission: " + commission);
      System.out.println("Total Salary: " + totalSalary);
  }

    public static void main(String[] args) {
        System.out.print("Enter your First name: ");
        input.nextLine();
        System.out.print("Enter your Last name: ");
        input.nextLine();
        System.out.print("Please enter your base salary: ");
        int baseSalary = input.nextInt();

        Main employee = new Main(baseSalary);
        employee.allofit(); // Process based on employee type
    }
}
