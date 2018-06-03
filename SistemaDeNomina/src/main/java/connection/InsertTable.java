package connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertTable {
	private static final String URL = DbPropertiesReader.getString("db.url");
	static final String USERNAME = DbPropertiesReader.getString("db.user");
	static final String PASSWORD = DbPropertiesReader.getString("db.password");
	
	private Connection connection = null; // manages connection
	private PreparedStatement insertNewEmployee = null;
	private PreparedStatement insertNewsalariedEmployee = null;
	private PreparedStatement insertNewcommissionEmployee = null;
	private PreparedStatement insertNewbasePlusCommissionEmployee = null;
	private PreparedStatement insertNewhourlyEmployee = null;
	
	public InsertTable() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			insertNewEmployee = connection.prepareStatement(
					"INSERT INTO employee " + "(socialSecurityNumber, firstName, lastName, birthday, employeeType, departmentName) " + "VALUES ( ?, ?, ?, ?, ?, ?)");
			//******************************************
			insertNewsalariedEmployee = connection.prepareStatement(
					"INSERT INTO salariedEmployee " + "(socialsecurityNumber, weeklySalary, bonus) " + "VALUES ( ?, ?, ?)");
			//******************************************
			insertNewcommissionEmployee = connection.prepareStatement(
					"INSERT INTO commissionEmployee " + "(socialsecurityNumber, grossSales, commissionRate, bonus) " + "VALUES ( ?, ?, ?, ?)");
			//******************************************
			insertNewbasePlusCommissionEmployee = connection.prepareStatement(
					"INSERT INTO basePlusCommissionEmployee " + "(socialsecurityNumber, grossSales, commissionRate, baseSalary, bonus) " + "VALUES ( ?, ?, ?, ?, ?)");
			//******************************************
			insertNewhourlyEmployee = connection.prepareStatement(
					"INSERT INTO hourlyEmployee " + "(socialsecurityNumber, hours, wage, bonus) " + "VALUES ( ?, ?, ?, ?)");
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		} // end catch
	} // end PersonQueries constructor
	public int addEmployee(String socialNumber, String fname, String lname, Date nacimiento, String tipo, String departamento) {
		int result = 0;
		try {
			insertNewEmployee.setString(1, socialNumber);
			insertNewEmployee.setString(2, fname);
			insertNewEmployee.setString(3, lname);
			insertNewEmployee.setDate(4, nacimiento);
			insertNewEmployee.setString(5,tipo);
			insertNewEmployee.setString(6, departamento);

			result = insertNewEmployee.executeUpdate();
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int addSalariedEmployee(String socialNumber, float weeklySalary , float bonus) {
		int result = 0;
		try {
			insertNewsalariedEmployee.setString(1, socialNumber);
			insertNewsalariedEmployee.setFloat(2, weeklySalary);
			insertNewsalariedEmployee.setFloat(3, bonus);
			
			result = insertNewsalariedEmployee.executeUpdate();
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int addCommissionEmployee(String socialNumber, int grossSales, float commissionRate, float bonus) {
		int result = 0;
		try {
			insertNewcommissionEmployee.setString(1, socialNumber);
			insertNewcommissionEmployee.setInt(2, grossSales);
			insertNewcommissionEmployee.setFloat(3, commissionRate);
			insertNewcommissionEmployee.setFloat(4, bonus);
			result = insertNewcommissionEmployee.executeUpdate();
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}

	public int addBasePlusCommissionEmployee(String socialNumber,int grossSales, float commissionRate, float baseSalary, float bonus) {
		int result = 0;
		try {
			insertNewbasePlusCommissionEmployee.setString(1, socialNumber);
			insertNewbasePlusCommissionEmployee.setInt(2, grossSales);
			insertNewbasePlusCommissionEmployee.setFloat(3, commissionRate);
			insertNewbasePlusCommissionEmployee.setFloat(4, baseSalary);
			insertNewbasePlusCommissionEmployee.setFloat(5, bonus);
			result = insertNewbasePlusCommissionEmployee.executeUpdate();
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	public int addHourlyEmployee(String socialNumber, int hours, float wage, float bonus) {
		int result = 0;
		try {
			insertNewhourlyEmployee.setString(1, socialNumber);
			insertNewhourlyEmployee.setInt(2, hours);
			insertNewhourlyEmployee.setFloat(3, wage);
			insertNewhourlyEmployee.setFloat(4, bonus);
			result = insertNewhourlyEmployee.executeUpdate();
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	
	
	public void close() {
		try {
			connection.close();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} 
	} 
}

