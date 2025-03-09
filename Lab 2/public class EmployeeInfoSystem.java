import java.util.Scanner;

class EmployeeInfoSystem { // Removed 'public' to match file name requirement
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            // User Input
            System.out.print("Enter Employee's First Name: ");
            String firstName = input.nextLine();

            System.out.print("Enter Employee's Last Name: ");
            String lastName = input.nextLine();

            System.out.print("Enter Employee's Age: ");
            int age = input.nextInt();

            System.out.print("Enter Number of Hours Worked in a Day: ");
            float hoursWorked = input.nextFloat();

            System.out.print("Enter Hourly Wage: ");
            float hourlyWage = input.nextFloat();

            // Computations
            String fullName = (lastName + " " + firstName).toUpperCase();
            int yearsToRetirement = Math.abs(65 - age);
            int dailyWage = Math.round(hoursWorked * hourlyWage);
            int weeklyWage = dailyWage * 5;
            int monthlyWage = weeklyWage * 4;
            int grossYearlyWage = monthlyWage * 12;
            double netYearlyWage = grossYearlyWage - ((grossYearlyWage * 0.32) + 1500);

            // Output
            System.out.println("\n===== Employee Information =====");
            System.out.println("Full Name: " + fullName);
            System.out.println("Years to Retirement: " + yearsToRetirement);
            System.out.println("Daily Wage: Php " + dailyWage);
            System.out.println("Weekly Wage: Php " + weeklyWage);
            System.out.println("Monthly Wage: Php " + monthlyWage);
            System.out.println("Gross Yearly Wage: Php " + grossYearlyWage);
            System.out.printf("Net Yearly Wage: Php %.2f\n", netYearlyWage);
        }
    }
}