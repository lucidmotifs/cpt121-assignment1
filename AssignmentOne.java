import java.util.Scanner;
import java.lang.Math;

public class AssignmentOne { 
    public static void main(String[] args) {
		
		// Constants
		final double SMALL_HIRE_CHARGE = 80.0;
		final double MEDIUM_HIRE_CHARGE = 110.0;
		final double LARGE_HIRE_CHARGE = 140.0;
		
		// Declarations
		String customerName;
		String customerAddr;
		String customerPhone;
		String customerLicenseNum;
		
		String customerCCNum;
		String customerCCExpiry;
		
		String carMakeModel;
		String carRegistration;
		
		// Strings to store the list of infringements and damages
		String infringementList = new String();
		String damageRepairList = new String();
		
		// Rates and total charges
		double surchargeRate;
		double dailyHireRate;		
		double basicHireCharge;
		double adjustedHireCharge;
		double surchargeTotal;
		
		// Extra Costs
		double infringementCost = 0.0;
		double damageRepairCost = 0.0;				
		
		// refers to the pre-arranged length the car will be hired
		int hireLength;
		
		// the actual number of days the car was kept 
		int daysHired;
		
		char carSize;
		char menuSelection;
			
		// Create Scanner instance to read user input
		Scanner in = new Scanner(System.in);
		
		// Customer Name
		System.out.print("Enter Customer Name: ");
		customerName = in.nextLine();
		//in.nextLine();
		
		// Customer Address
		System.out.print("Enter Customer Address: ");
		customerAddr = in.nextLine();
		
		// Customer Phone
		System.out.print("Enter Customer Phone No: ");
		customerPhone = in.nextLine();
		
		// Customer License
		System.out.print("Enter Customer License No: ");
		customerLicenseNum = in.nextLine();
		
		// Customer Credit Card Details
		System.out.println();
		System.out.print("Enter Credit Card No.: ");
		customerCCNum = in.nextLine();
		
		System.out.print("Enter Expiry Date: ");
		customerCCExpiry = in.nextLine();
		
		// Care Hire Details
		System.out.println();
		System.out.print("Enter Hire Length (in days): ");
		hireLength = in.nextInt();
		in.nextLine();
		
		System.out.print("Enter Make / Model of Assigned Vehicle: ");
		carMakeModel = in.nextLine();
		
		System.out.print("Enter Registration of Assigned Vehicle: ");
		carRegistration = in.nextLine();
		
		//System.out.print("Enter Daily Hire Rate: ");
		//dailyHireRate = in.nextDouble();
		
		// Car Size
		System.out.println();
		System.out.print("Enter Car Size - (S)mall, (M)edium, (L)arge: ");
		carSize = in.next().charAt(0);
		in.nextLine();
		
		// Actual Days Hired
		System.out.print("Enter Days Hired: ");
		daysHired = in.nextInt();
		in.nextLine();		
		
		menuSelection = ' ';
		while (!(menuSelection == 'x' || menuSelection == 'X')) {		
		
			// Repair and Infringement menu
			System.out.println();
			System.out.println("Damage Repair / Traffic Infringement Data Entry Menu");
			System.out.println("----------------------------------------------------");
			System.out.println();
			System.out.println("A - Record Damage Repair Details");
			System.out.println("B - Record Traffic Infringement Details");
			System.out.println("X - Exit");
			System.out.println();
			
			// Menu option selection line		
			System.out.print("Enter your selection: ");
			menuSelection = in.next().charAt(0);
			in.nextLine();
			
			switch(menuSelection) {
				case 'a':
				case 'A':
					// Damage Repair Section
					// Declare temporary variables for damage and cost
					String _damage;
					double _cost;
					
					System.out.print("Enter Description of Damage Repair: ");
					_damage = in.nextLine();
					
					System.out.print("Enter Repair Cost: ");
					_cost = in.nextDouble();
					
					// Add formatted string to list, with new damage item added.
					damageRepairList = String.format("%s %n - %s ($%.2f)", damageRepairList, _damage, _cost);
					damageRepairCost += _cost;
					in.nextLine();					
					break;
				case 'b':
				case 'B':
					// Traffic Infringement Section
					// Declare temporary variables for infringement and cost
					String _infringement;
					double _amount;
					
					System.out.print("Enter Details of Traffic Infringement: ");
					_infringement = in.nextLine();
					
					System.out.print("Enter Infringement Fine Amount: ");
					_amount = in.nextDouble();
					
					// Add formatted string to list, with new infrginement added.
					infringementList = String.format("%s %n - %s ($%.2f)", infringementList, _infringement, _amount);
					infringementCost += _amount;
					in.nextLine();
					break;
				case 'x':
				case 'X':
					System.out.println("Exiting data entry menu...");
					break;
				default:
					System.out.println("Error - Invalid menu selection!");
			}		
		} 
		
		// Find Hire Charge
		switch(carSize) {
			case 's':
			case 'S': 	dailyHireRate = SMALL_HIRE_CHARGE;
						break;
			case 'm':
			case 'M':	dailyHireRate = MEDIUM_HIRE_CHARGE;
						break;
			case 'l':
			case 'L':	dailyHireRate = LARGE_HIRE_CHARGE;
						break;
			default:	dailyHireRate = 0.0;
		}
		
		// Calculate hire charge
		basicHireCharge = hireLength * dailyHireRate;
		
		// Surcharge of 200% for any days late
		surchargeRate = dailyHireRate * 2.0;
		
		// Returning car early should not reduce the price
		surchargeTotal = Math.max(daysHired - hireLength, 0) * surchargeRate;
		adjustedHireCharge = basicHireCharge + surchargeTotal;		
		
		// Print out customer details
		System.out.println();
		System.out.println("Customer Details:");
		System.out.println();
		
		System.out.printf("%-25s %40s %n", "Name:", customerName);
		System.out.printf("%-25s %40s %n", "Address:", customerAddr);
		System.out.printf("%-25s %40s %n", "Phone Number:", customerPhone);
		System.out.printf("%-25s %40s %n", "License Number:", customerLicenseNum);
		System.out.printf("%-25s %40s %n", "Credit Card No.:", customerCCNum);
		System.out.printf("%-25s %40s %n", "Expiry Date:", customerCCExpiry);
		
		// Print out car details
		System.out.println();
		System.out.println("Car Hire Details:");
		System.out.println();
		
		System.out.printf("%-25s %40s %n", "Make / Model:", carMakeModel);
		System.out.printf("%-25s %40s %n", "Registration No.:", carRegistration);
		System.out.printf("%-25s %40d %n", "Hire Length (days):", hireLength);
		System.out.printf("%-25s %40.2f %n", "Daily Hire Rate:", dailyHireRate);		
		// Print the base hire charge
		System.out.printf("%-25s %40.2f %n", "Basic Hire Charge:", basicHireCharge);
		
		// Print out surcharge details
		System.out.println();
		System.out.printf("%-25s %40d %n", "Days Hired:", daysHired);
		System.out.printf("%-25s %40.2f %n", "Late Return Surcharge:", surchargeTotal);
		System.out.printf("%-25s %40.2f %n", "Adjusted Hire Charge:", adjustedHireCharge);
		System.out.println();
		
		// Damage Repair
		System.out.println("Damage Repair Details:");
		System.out.println(damageRepairList);
		System.out.println();
		System.out.printf("%-25s %40.2f %n", "Damage Repair Total:", damageRepairCost);
		System.out.println();
		
		// Traffic Infringements
		System.out.println("Traffic Infringement Fine Details:");
		System.out.println(infringementList);
		System.out.println();
		System.out.printf("%-25s %40.2f %n", "Traffic Fine Total:", infringementCost);
		System.out.println();
		
		// Final cost
		System.out.printf("%-25s %40.2f %n", "Final Hire Charge:", (adjustedHireCharge + damageRepairCost + infringementCost));
		System.out.println();
	}
}