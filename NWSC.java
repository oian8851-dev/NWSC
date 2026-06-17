
package bill.nwsc;


public class NWSC {
public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        java.util.ArrayList<Customer> customers = new java.util.ArrayList<Customer>();

        
        System.out.println("  NATIONAL WATER AND SEWERAGE CORPORATION  ");
        System.out.println("       Monthly Water Billing System         ");
       

        int i = 1;
        while (i <= 6) {
            System.out.println("--- Customer " + i + " of 6 ---");

            System.out.print("Enter customer name: ");
            String name = s.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("  [!] Name cannot be empty. Please try again.\n");
                continue;
            }

            double consumption = -1;
            while (consumption < 0) {
                System.out.print("Enter monthly water consumption (m3): ");
                try {
                    String input = s.nextLine().trim();
                    consumption = Double.parseDouble(input);
                    if (consumption < 0) {
                        System.out.println("  [!] Consumption cannot be negative. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("  [!] Invalid input. Please enter a numeric value.");
                }
            }

            Customer customer = new Customer(name, consumption);
            customers.add(customer);
            System.out.println("\n" + customer.getBillSummary());
            i++;
        }

        System.out.println("\n============================================");
        System.out.println("          MONTHLY BILLING SUMMARY           ");
        System.out.println("============================================");

        int lifeline = 0, domesticLow = 0, domesticHigh = 0;
        int commercial = 0, industrial = 0, institutional = 0;
        double totalRevenue = 0;

        for (int j = 0; j < customers.size(); j++) {
            Customer c = customers.get(j);
            totalRevenue += c.getTotalBill();

            if (c.getBand().equals("LIFELINE")) {
                lifeline++;
            } else if (c.getBand().equals("DOMESTIC LOW")) {
                domesticLow++;
            } else if (c.getBand().equals("DOMESTIC HIGH")) {
                domesticHigh++;
            } else if (c.getBand().equals("COMMERCIAL")) {
                commercial++;
            } else if (c.getBand().equals("INDUSTRIAL")) {
                industrial++;
            } else if (c.getBand().equals("INSTITUTIONAL")) {
                institutional++;
            }
        }

        double averageBill = totalRevenue / customers.size();

        System.out.println("\n  Customers per Band:");
        System.out.printf("    %-20s : %d customer(s)%n", "LIFELINE",      lifeline);
        System.out.printf("    %-20s : %d customer(s)%n", "DOMESTIC LOW",  domesticLow);
        System.out.printf("    %-20s : %d customer(s)%n", "DOMESTIC HIGH", domesticHigh);
        System.out.printf("    %-20s : %d customer(s)%n", "COMMERCIAL",    commercial);
        System.out.printf("    %-20s : %d customer(s)%n", "INDUSTRIAL",    industrial);
        System.out.printf("    %-20s : %d customer(s)%n", "INSTITUTIONAL", institutional);

        System.out.println();
        System.out.printf("  Total Customers : %d%n",         customers.size());
        System.out.printf("  Total Revenue   : UGX %,.0f%n", totalRevenue);
        System.out.printf("  Average Bill    : UGX %,.0f%n", averageBill);
        System.out.println("============================================");

        s.close();
    }
    
   
}
