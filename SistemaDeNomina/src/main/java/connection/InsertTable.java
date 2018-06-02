package connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InsertTable {
	private static final String URL = DbPropertiesReader.getString("db.url");
	static final String USERNAME = DbPropertiesReader.getString("db.user");
	static final String PASSWORD = DbPropertiesReader.getString("db.password");
	
	private Connection connection = null; // manages connection
	private PreparedStatement insertNewPerson = null;
	
	public InsertTable() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			insertNewPerson = connection.prepareStatement(
					"INSERT INTO `dbeleno86`.`employee` " + 
					"(`socialSecurityNumber`, " + 
					"`firstName`, " + 
					"`lastName`, " + 
					"`birthday`, " + 
					"`employeeType`, " + 
					"`departmentName`) " + 
					"VALUES ( ?, ?, ?, ?, ?, ? )");
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		} // end catch
	} // end PersonQueries constructor
	public int addPerson(String socialNumber, String fname, String lname, Date nacimiento, String tipo, String departamento) {
		int result = 0;

		// set parameters, then execute insertNewPerson
		try {
			insertNewPerson.setString(1, socialNumber);
			insertNewPerson.setString(2, fname);
			insertNewPerson.setString(3, lname);
			insertNewPerson.setDate(4, nacimiento);
			insertNewPerson.setString(5,tipo);
			insertNewPerson.setString(6, departamento);

			// insert the new entry; returns # of rows updated
			result = insertNewPerson.executeUpdate();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		} // end catch

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

