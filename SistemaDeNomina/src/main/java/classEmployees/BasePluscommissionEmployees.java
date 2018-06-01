package classEmployees;

import java.time.LocalDate;

public class BasePluscommissionEmployees extends Employees {
	private int grossSales = 0;
	private float commissionRate = 0;
	private float baseSalary = 0;
	private float bonus = 0;

	public BasePluscommissionEmployees() {

	}

	public BasePluscommissionEmployees(int grossSales, float commissionRate, float baseSalary, float bonus,String socialSecurityNumber, String firstName, String lastName, LocalDate birthday,
			String employeeType, String departmentName) {
		super();
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
		this.baseSalary = baseSalary;
		this.bonus = bonus;
		//Heredados:
		this.socialSecurityNumber = socialSecurityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.employeeType = employeeType;
		this.departmentName = departmentName;
	}

	public int getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(int grossSales) {
		this.grossSales = grossSales;
	}

	public float getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(float commissionRate) {
		this.commissionRate = commissionRate;
	}

	public float getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(float baseSalary) {
		this.baseSalary = baseSalary;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "BasePluscommissionEmployees [grossSales=" + grossSales + ", commissionRate=" + commissionRate
				+ ", baseSalary=" + baseSalary + ", bonus=" + bonus + ", socialSecurityNumber=" + socialSecurityNumber
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + ", employeeType="
				+ employeeType + ", departmentName=" + departmentName + "]";
	}

	
	

}
