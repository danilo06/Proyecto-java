package classEmployees;

import java.sql.Date;

public class CommissionEmployees extends Employees {
	private int grossSales = 0;
	private float CommissionRate = 0;
	private float bonus = 0;

	public CommissionEmployees() {

	}

	public CommissionEmployees(int grossSales, float commissionRate, float bonus,String socialSecurityNumber, String firstName, String lastName, Date birthday,
			String employeeType, String departmentName) {
		super();
		this.grossSales = grossSales;
		CommissionRate = commissionRate;
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
		return CommissionRate;
	}

	public void setCommissionRate(float commissionRate) {
		CommissionRate = commissionRate;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "CommissionEmployees [grossSales=" + grossSales + ", CommissionRate=" + CommissionRate + ", bonus="
				+ bonus + ", socialSecurityNumber=" + socialSecurityNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birthday=" + birthday + ", employeeType=" + employeeType + ", departmentName="
				+ departmentName + "]";
	}

	
	

}
