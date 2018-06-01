package classEmployees;

import java.time.LocalDate;

public class SalariedEmployees extends Employees {
	private float weeklySalary = 0;
	private float bonus = 0;

	public SalariedEmployees() {

	}

	public SalariedEmployees(float weeklySalary, float bonus,String socialSecurityNumber, String firstName, String lastName, LocalDate birthday,
			String employeeType, String departmentName) {
		super();
		this.weeklySalary = weeklySalary;
		this.bonus = bonus;
		//Heredados:
		this.socialSecurityNumber = socialSecurityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.employeeType = employeeType;
		this.departmentName = departmentName;
	}

	public float getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(float weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

}
