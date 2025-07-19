import java.util.*;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class EmployeeManagementSystem {
    private List<Employee> employees = new ArrayList<>();

    // Add a new employee
    public void addEmployee(int id, String name) {
        employees.add(new Employee(id, name));
        System.out.println("Employee added successfully.");
    }

    // Search for an employee by ID
    public void searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println("Employee found: " + emp);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // Remove an employee by ID
    public void removeEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // Display employees in sorted order by ID
    public void displayById() {
        employees.sort(Comparator.comparingInt(Employee::getId));
        System.out.println("Employees sorted by ID:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    // Display employees in sorted order by name
    public void displayByName() {
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("Employees sorted by Name:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Remove Employee by ID");
            System.out.println("4. Display Employees by ID");
            System.out.println("5. Display Employees by Name");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    ems.addEmployee(id, name);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    ems.searchEmployee(searchId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    ems.removeEmployee(removeId);
                    break;
                case 4:
                    ems.displayById();
                    break;
                case 5:
                    ems.displayByName();
                    break;
                case 6:
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}