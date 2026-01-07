import java.util.Scanner;

class EmployeeManagementSystem {

    static int[] empId = new int[100];
    static String[] empName = new String[100];
    static double[] empSalary = new double[100];
    static int count = 0;

    // Add employee
    static void addEmployee(int id, String name, double salary) {
        empId[count] = id;
        empName[count] = name;
        empSalary[count] = salary;
        count++;
        System.out.println("Employee added successfully!");
    }

    // Display employees
    static void displayEmployees() {
        if (count == 0) {
            System.out.println("No employee records found!");
            return;
        }

        System.out.println("\n--- Employee List ---");
        System.out.println("ID\tName\tSalary");
        for (int i = 0; i < count; i++) {
            System.out.println(empId[i] + "\t" + empName[i] + "\t" + empSalary[i]);
        }
    }

    // Search employee
    static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (empId[i] == id) {
                System.out.println("Employee Found!");
                System.out.println("ID     : " + empId[i]);
                System.out.println("Name   : " + empName[i]);
                System.out.println("Salary : " + empSalary[i]);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Update salary
    static void updateSalary(int id, double newSalary) {
        for (int i = 0; i < count; i++) {
            if (empId[i] == id) {
                empSalary[i] = newSalary;
                System.out.println("Salary updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Delete employee
    static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (empId[i] == id) {
                for (int j = i; j < count - 1; j++) {
                    empId[j] = empId[j + 1];
                    empName[j] = empName[j + 1];
                    empSalary[j] = empSalary[j + 1];
                }
                count--;
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Management Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    addEmployee(id, name, salary);
                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    searchEmployee(searchId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();
                    updateSalary(updateId, newSalary);
                    break;

                case 5:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    deleteEmployee(deleteId);
                    break;

                case 6:
                    System.out.println("Exiting Employee Management System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}