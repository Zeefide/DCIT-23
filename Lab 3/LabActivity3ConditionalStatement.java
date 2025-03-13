import java.util.Scanner;

public class LabActivity3ConditionalStatement {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            // Input of user
            System.out.print("Enter your first name: ");
            String firstName = input.nextLine();

            System.out.print("Enter your last name: ");
            String lastName = input.nextLine();

            System.out.print("Enter your age: ");
            int age = input.nextInt();

            if (age < 18) {
                System.out.println("Minors are not allowed.");
                return;
            }
            if (age >= 65) {
                System.out.println("Senior Citizens are not allowed.");
                return;
            }

            System.out.print("Enter role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): ");
            int jobRoleCode = input.nextInt();

            String jobRole = switch (jobRoleCode) {
                case 1 -> "Manager";
                case 2 -> "Supervisor";
                case 3 -> "Staff";
                case 4 -> "Intern";
                default -> "Undefined";
            };

            System.out.print("Enter hours worked: ");
            float hoursWorked = input.nextFloat();

            if (hoursWorked > 24) {
                System.out.println("Number of hours worked cannot exceed 24 hours.");
                return;
            }
            if (hoursWorked <= 0) {
                System.out.println("Wrong input on daily work hours.");
                return;
            }

            System.out.print("Enter hourly wage: ");
            float hourlyWage = input.nextFloat();

            // Computations
            String fullName = (lastName + ", " + firstName).toUpperCase();
            int yearsToRetirement = 65 - age;
            float dailyWage = hoursWorked * hourlyWage;
            float weeklyWage = dailyWage * 5;
            float monthlyWage = weeklyWage * 4;
            float grossYearlyWage = monthlyWage * 12;
            float netYearlyWage = grossYearlyWage > 250000 
                ? grossYearlyWage - ((grossYearlyWage * 0.32f) + 1500) 
                : grossYearlyWage - 1500;

            // Output
            System.out.println("\nEmployee Information");
            System.out.println("--------------------");
            System.out.println("Full Name: \t" + fullName);
            System.out.println("Age: \t\t" + age + " years old");
            System.out.println("Position: \t" + jobRole);
            System.out.println("Years to Retirement: " + yearsToRetirement + " years");
            System.out.printf("Daily Salary: \tPhp %.2f\n", dailyWage);
            System.out.printf("Weekly Salary: \tPhp %.2f\n", weeklyWage);
            System.out.printf("Monthly Salary: \tPhp %.2f\n", monthlyWage);
            System.out.printf("Gross Yearly Salary: Php %.2f\n", grossYearlyWage);
            System.out.printf("Net Yearly Salary: \tPhp %.2f\n", netYearlyWage);
        }
    }
}
