package week_6;
import java.text.DecimalFormat;

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		// Here we create our objects along with arguments
		Employee salariedEmployee = new SalariedEmployee("Zanjoe Langa", "67", 60000.00);
		Employee hourlyEmployee = new HourlyEmployee("Denise Seradilla", "69", 20.00, 40);
		Employee commissionBasedEmployee = 
	    new CommissionBasedEmployee("Charles Sualog", "70", 10000.00, 10);
		
		// Display all employee info
		salariedEmployee.displayEmployeeInfo();
		hourlyEmployee.displayEmployeeInfo();
		commissionBasedEmployee.displayEmployeeInfo();
	}
}

abstract class Employee {
	// Formatting just for cleaner outputs
	static final DecimalFormat df = new DecimalFormat("0.##");
	// Encapsulation
	private String name, employeeId;

	Employee(String name, String employeeId) {
		this.name = name;
		this.employeeId = employeeId;
	}	
	
	// Getters for encapsulated variables
	String getName() {
		return name;
	}
	String getEmployeeId() {
		return employeeId;
	}
	
	// Abstract methods so every subclasses must have them as well
	abstract double calculateEarnings();
	abstract void displayEmployeeInfo();
}

// Salaried Employee class
class SalariedEmployee extends Employee {
	// Encapsulation
	private double annualSalary; 
	
	SalariedEmployee(String name, String employeeId, double annualSalary) {
		super(name, employeeId);
		this.annualSalary = annualSalary;
	}
	
	double calculateEarnings() {
		return annualSalary;
	}
	
	void displayEmployeeInfo() {
		System.out.printf("Salaried Employee :  Name = %s" 
		+ ", Employee ID = %s, Annual Salary = $%.2f\n", getName(), getEmployeeId(), annualSalary);
	}
}

// Hourly Employee class
class HourlyEmployee extends Employee {
	// Encapsulation
	private double hourlyRate, hoursWorked; 
	
	HourlyEmployee(String name, String employeeId, double hourlyRate, double hoursWorked) {
		super(name, employeeId);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}
	
	double calculateEarnings() {
		 return hourlyRate * hoursWorked;
	}
	
	void displayEmployeeInfo() {
		double earnings = calculateEarnings();
		System.out.printf("Hourly Employee   :  Name = %s" 
		+ ", Employee ID = %s, Hourly Rate = $%.2f"
		+ ", Hours Worked = " +  df.format(hoursWorked) + ", Earnings = $%.2f\n", getName(), 
		getEmployeeId(), hourlyRate, earnings);
	}
}

// Commission Based Employee class
class CommissionBasedEmployee extends Employee {
	// Encapsulation
	private double salesAmount, commissionRate; 
	
	CommissionBasedEmployee(String name, String employeeId, double salesAmount, double commissionRate) {
		super(name, employeeId);
		this.salesAmount = salesAmount;
		// This is just to make the rate (for example) 0.10 and 10 act the same
		if (commissionRate > 1) {
	        this.commissionRate = commissionRate / 100.0; 
	    } else {
	        this.commissionRate = commissionRate; 
	    }
	}
	
	double calculateEarnings() {
		 return salesAmount * commissionRate;
	}
	
	void displayEmployeeInfo() {
		double earnings = calculateEarnings();
		System.out.printf("Commission-Based Employee :  Name = %s" 
		+ ", Employee ID = %s, Sales Amount = $%.2f"
		+ ",\nCommission Rate = %.0f%%, Earnings = $%.2f\n", getName(), 
		getEmployeeId(), salesAmount, commissionRate * 100, earnings);
	}
}

