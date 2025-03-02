import java.util.Scanner;

public class EmployeeInfoSystem {
    public static void main(String[] args) {
      
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Ask for the employee's first name
            System.out.print("Enter employee's first name: ");
            String firstName = scanner.nextLine();
            
            // Ask for the employee's last name
            System.out.print("Enter employee's last name: ");
            String lastName = scanner.nextLine();
            
            // Ask for the employee's age
            System.out.print("Enter employee's age: ");
            int age = scanner.nextInt();
            
            // Ask for the number of hours worked per day
            System.out.print("Enter number of hours worked in a day: ");
            double hoursWorked = scanner.nextDouble();
            
            // Ask for the employee's hourly wage
            System.out.print("Enter hourly wage: ");
            double hourlyWage = scanner.nextDouble();
            
            // Combine first and last name
            String fullName = firstName + " " + lastName;
            
            // Calculate the daily wage by doing hours worked * hourly wage
            double dailyWage = hoursWorked * hourlyWage;
            
            // Display the information of employee
            System.out.println("\nEmployee Information");
            System.out.println("---------------------");
            System.out.println("Full Name: " + fullName);
            System.out.println("Age: " + age);
            
            // Print the daily wage with two decimal places
            System.out.printf("Daily Wage: %.2f\n", dailyWage);
        } // Close the Scanner
    }
}
