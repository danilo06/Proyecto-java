package classEmployees;

import java.time.LocalDate;

public class HourlEmployees extends Employees {
	private int hours = 0;
	private float wage = 0;
	private float bonus = 0;

	public HourlEmployees() {

	}

	public HourlEmployees(int hours, float wage, float bonus,String socialSecurityNumber, String firstName, String lastName, LocalDate birthday,
			String employeeType, String departmentName) {
		super();
		this.hours = hours;
		this.wage = wage;
		this.bonus = bonus;
		//Heredados:
		this.socialSecurityNumber = socialSecurityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.employeeType = employeeType;
		this.departmentName = departmentName;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public float getWage() {
		return wage;
	}

	public void setWage(float wage) {
		this.wage = wage;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "HourlEmployees [hours=" + hours + ", wage=" + wage + ", bonus=" + bonus + ", socialSecurityNumber="
				+ socialSecurityNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday="
				+ birthday + ", employeeType=" + employeeType + ", departmentName=" + departmentName + "]";
	}
	

}
