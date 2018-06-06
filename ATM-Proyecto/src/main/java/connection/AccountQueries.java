package connection;

//clon
// Fig. 28.31: PersonQueries.java
// PreparedStatements used by the Address Book application
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cuenta;

public class AccountQueries {
	private static final String URL = DbPropertiesReader.getString("db.url");
	static final String USERNAME = DbPropertiesReader.getString("db.user");
	static final String PASSWORD = DbPropertiesReader.getString("db.password");

	private Connection connection = null; // manages connection
	private PreparedStatement selectAllPeople = null;
	private PreparedStatement selectAccount = null;
	private PreparedStatement updateAccount = null;
	// constructor
	public AccountQueries() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// create query that selects all entries in the AddressBook
			selectAllPeople = connection.prepareStatement("SELECT * FROM cuenta ORDER BY accountNumber");

			selectAccount = connection.prepareStatement("SELECT * FROM cuenta WHERE accountNumber  = ? ");
			
			updateAccount = connection.prepareStatement("UPDATE cuenta SET availableBalance = ?, totalBalance = ? WHERE accountNumber = ? ");
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		} // end catch
	} // end PersonQueries constructor

	// select all of the addresses in the database
	public List<Cuenta> getAllCuenta() {
		List<Cuenta> results = null;
		ResultSet resultSet = null;

		try {
			// executeQuery returns ResultSet containing matching entries
			resultSet = selectAllPeople.executeQuery();
			results = new ArrayList<Cuenta>();

			while (resultSet.next()) {
				results.add(
						new Cuenta(resultSet.getInt("accountNumber"), resultSet.getInt("numberPersonalIdentification"),
								resultSet.getDouble("availableBalance"), resultSet.getDouble("totalBalance")));
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

	public int setCuenta(double saldoDisponible, double saldoTotal, int numCuenta) {
		int result = 0;
		try {
			updateAccount.setDouble(1, saldoDisponible);
			updateAccount.setDouble(2, saldoTotal);
			updateAccount.setInt(3, numCuenta);
			
			result = updateAccount.executeUpdate();
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	public Cuenta getCuenta(int num) {
		List<Cuenta> results = null;
		ResultSet resultSet = null;
		Cuenta cuenta = null;
		try {
			selectAccount.setInt(1,num);
			
			resultSet = selectAccount.executeQuery();
			results = new ArrayList<Cuenta>();

			while (resultSet.next()) {
				results.add(
						new Cuenta(resultSet.getInt("accountNumber"), resultSet.getInt("numberPersonalIdentification"),
								resultSet.getDouble("availableBalance"), resultSet.getDouble("totalBalance")));
			}
			
			if (results.isEmpty() == true) // verificar si encontro la cuenta
			{
				cuenta = null;
			}else
			{
				cuenta = results.get(0);
			}
		} catch (SQLException sqlException) {
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

		return cuenta;
	}
	
	public void close() {
		try {
			connection.close();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
	} // end method close
} // end class PersonQueries
