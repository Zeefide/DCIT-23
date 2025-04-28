import java.util.Scanner;

public class MyMidtermLabExam {
    static final int MAX_TICKETS = 5;
    static String[] descriptions = new String[MAX_TICKETS];
    static String[] urgencies = new String[MAX_TICKETS];
    static String[] statuses = new String[MAX_TICKETS];
    static int ticketCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== IT Ticket Processing System ===");
            System.out.println("1. Add Ticket");
            System.out.println("2. Update Ticket Status");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                System.out.print("Select an option: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    addTicket(scanner);
                    break;
                case 2:
                    updateTicketStatus(scanner);
                    break;
                case 3:
                    showTickets();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    public static void addTicket(Scanner scanner) {
        if (ticketCount >= MAX_TICKETS) {
            System.out.println("Ticket limit reached. Cannot add more tickets.");
            return;
        }

        System.out.print("Enter issue description: ");
        descriptions[ticketCount] = scanner.nextLine();

        String urgency;
        do {
            System.out.print("Enter urgency level (Low, Medium, High): ");
            urgency = scanner.nextLine();
            if (!urgency.equalsIgnoreCase("Low") &&
                !urgency.equalsIgnoreCase("Medium") &&
                !urgency.equalsIgnoreCase("High")) {
                System.out.println("Invalid urgency level. Try again.");
            }
        } while (!urgency.equalsIgnoreCase("Low") &&
                 !urgency.equalsIgnoreCase("Medium") &&
                 !urgency.equalsIgnoreCase("High"));

        urgencies[ticketCount] = capitalize(urgency);
        statuses[ticketCount] = "Pending";
        ticketCount++;

        System.out.println("Ticket added successfully!");
    }

    public static void updateTicketStatus(Scanner scanner) {
        if (ticketCount == 0) {
            System.out.println("No tickets to update.");
            return;
        }

        showTickets();
        System.out.print("Enter the ticket number to update: ");

        int ticketNum = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (ticketNum < 1 || ticketNum > ticketCount) {
            System.out.println("Invalid ticket number.");
            return;
        }

        if (statuses[ticketNum - 1].equals("Resolved")) {
            System.out.println("Ticket already resolved. Cannot update.");
            return;
        }

        System.out.print("Enter new status (In Progress/Resolved): ");
        String newStatus = scanner.nextLine();

        if (!newStatus.equalsIgnoreCase("In Progress") &&
            !newStatus.equalsIgnoreCase("Resolved")) {
            System.out.println("Invalid status entered.");
            return;
        }

        statuses[ticketNum - 1] = capitalize(newStatus);
        System.out.println("Ticket status updated successfully!");
    }

    public static void showTickets() {
        if (ticketCount == 0) {
            System.out.println("No tickets to display.");
            return;
        }

        System.out.println("\n--- List of Tickets ---");
        for (int i = 0; i < ticketCount; i++) {
            System.out.println((i + 1) + ". Description: " + descriptions[i]);
            System.out.println("   Urgency: " + urgencies[i]);
            System.out.println("   Status: " + statuses[i]);
        }
    }

    public static void generateReport() {
        int pendingCount = 0, resolvedCount = 0;

        for (int i = 0; i < ticketCount; i++) {
            if (statuses[i].equals("Resolved")) {
                resolvedCount++;
            } else {
                pendingCount++;
            }
        }

        System.out.println("\n--- Ticket Report ---");
        System.out.println("Total tickets: " + ticketCount);
        System.out.println("Pending/In Progress tickets: " + pendingCount);
        System.out.println("Resolved tickets: " + resolvedCount);
    }

    private static String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
