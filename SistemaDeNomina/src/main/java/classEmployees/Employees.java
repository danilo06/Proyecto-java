package classEmployees;

import java.sql.Date;

public class Employees {
	protected String socialSecurityNumber;
	protected String firstName;
	protected String lastName;
	protected Date birthday;
	protected String employeeType;
	protected String departmentName;

	public Employees() {

	}

	public Employees(String socialSecurityNumber, String firstName, String lastName, Date birthday,
			String employeeType, String departmentName) {
		super();
		this.socialSecurityNumber = socialSecurityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.employeeType = employeeType;
		this.departmentName = departmentName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
