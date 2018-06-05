package connection;

// Fig. 28.31: PersonQueries.java
// PreparedStatements used by the Address Book application
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonQueries {
	private static final String URL = DbPropertiesReader.getString("db.url");
	static final String USERNAME = DbPropertiesReader.getString("db.user");
	static final String PASSWORD = DbPropertiesReader.getString("db.password");

	private Connection connection = null; // manages connection
	private PreparedStatement selectAllPeople = null;
	private PreparedStatement selectPeopleByLastName = null;
	private PreparedStatement insertNewPerson = null;

	// constructor
	public PersonQueries() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// create query that selects all entries in the AddressBook
			selectAllPeople = connection.prepareStatement("SELECT * FROM address ORDER BY lastName, firstName");

			// create query that selects entries with last names
						// that begin with the specified characters
			selectPeopleByLastName = connection.prepareStatement(
					"SELECT * FROM address WHERE lastName LIKE ? " + "ORDER BY lastName, firstName");


			// create insert that adds a new entry into the database
			insertNewPerson = connection.prepareStatement(
					"INSERT INTO address " + "( firstName, lastName, email, phoneNumber ) " + "VALUES ( ?, ?, ?, ? )");
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		} // end catch
	} // end PersonQueries constructor

	// select all of the addresses in the database
	public List<Person> getAllPeople() {
		List<Person> results = null;
		ResultSet resultSet = null;

		try {
			// executeQuery returns ResultSet containing matching entries
			resultSet = selectAllPeople.executeQuery();
			results = new ArrayList<Person>();

			while (resultSet.next()) {
				results.add(new Person(resultSet.getInt("addressID"), resultSet.getString("firstName"),
						resultSet.getString("lastName"), resultSet.getString("email"),
						resultSet.getString("phoneNumber")));
			} // end while
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
		finally {
			try {
				resultSet.close();
			} // end try
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			} // end catch
		} // end finally

		return results;
	} // end method getAllPeople

	// select person by last name
	public List<Person> getPeopleByLastName(String name) {
		List<Person> results = null;
		ResultSet resultSet = null;

		try {
			selectPeopleByLastName.setString(1, name); // specify last name

			// executeQuery returns ResultSet containing matching entries
			resultSet = selectPeopleByLastName.executeQuery();

			results = new ArrayList<Person>();

			while (resultSet.next()) {
				results.add(new Person(resultSet.getInt("addressID"), resultSet.getString("firstName"),
						resultSet.getString("lastName"), resultSet.getString("email"),
						resultSet.getString("phoneNumber")));
			} // end while
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
		finally {
			try {
				resultSet.close();
			} // end try
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			} // end catch
		} // end finally

		return results;
	} // end method getPeopleByName

	// add an entry
	public int addPerson(String fname, String lname, String email, String num) {
		int result = 0;

		// set parameters, then execute insertNewPerson
		try {
			insertNewPerson.setString(1, fname);
			insertNewPerson.setString(2, lname);
			insertNewPerson.setString(3, email);
			insertNewPerson.setString(4, num);

			// insert the new entry; returns # of rows updated
			result = insertNewPerson.executeUpdate();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		} // end catch

		return result;
	} // end method addPerson

	// close the database connection
	public void close() {
		try {
			connection.close();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
	} // end method close
} // end class PersonQueries

/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/
