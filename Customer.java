
package bill.nwsc;


public class Customer {
    private String name;
    private double consumption;
    private String band;
    private double ratePerM3;
    private double fixedServiceCharge;
    private double totalBill;

    public Customer(String name, double consumption) {
        this.name = name;
        this.consumption = consumption;
        calculateBill();
    }

    private void calculateBill() {
        if (consumption >= 0 && consumption <= 5) {
            band = "LIFELINE";
            ratePerM3 = 1000;
            fixedServiceCharge = 2000;
        } else if (consumption <= 20) {
            band = "DOMESTIC LOW";
            ratePerM3 = 2500;
            fixedServiceCharge = 4000;
        } else if (consumption <= 50) {
            band = "DOMESTIC HIGH";
            ratePerM3 = 3800;
            fixedServiceCharge = 7500;
        } else if (consumption <= 100) {
            band = "COMMERCIAL";
            ratePerM3 = 4500;
            fixedServiceCharge = 15000;
        } else if (consumption <= 300) {
            band = "INDUSTRIAL";
            ratePerM3 = 5200;
            fixedServiceCharge = 40000;
        } else {
            band = "INSTITUTIONAL";
            ratePerM3 = 6000;
            fixedServiceCharge = 90000;
        }
        totalBill = (consumption * ratePerM3) + fixedServiceCharge;
    }

    public String getName()               { return name; }
    public double getConsumption()        { return consumption; }
    public String getBand()               { return band; }
    public double getRatePerM3()          { return ratePerM3; }
    public double getFixedServiceCharge() { return fixedServiceCharge; }
    public double getTotalBill()          { return totalBill; }

    public String getBillSummary() {
        return String.format(
            "=====\n" +
            "Customer    : %s\n" +
            "Consumption : %.2f m3\n" +
            "Band        : %s\n" +
            "Rate/m3     : UGX %,.0f\n" +
            "Service Fee : UGX %,.0f\n" +
            "TOTAL BILL  : UGX %,.0f\n",
            name, consumption, band, ratePerM3, fixedServiceCharge, totalBill
        );
    }
}
