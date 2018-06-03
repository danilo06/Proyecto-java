package connection;

// Fig. 28.29: JdbcRowSetTest.java
// Displaying the contents of the authors table using JdbcRowSet.
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl; // Sun's JdbcRowSet implementation

public class ConsultarConsola {
	// JDBC driver name and database URL
	static final String DATABASE_URL = DbPropertiesReader.getString("db.url");
	static final String USERNAME = DbPropertiesReader.getString("db.user");
	static final String PASSWORD = DbPropertiesReader.getString("db.password");

	// constructor connects to database, queries database, processes
	// results and displays results in window
	public ConsultarConsola() {
		// connect to database books and query database
		try {
			// specify properties of JdbcRowSet
			JdbcRowSet rowSet = new JdbcRowSetImpl();
			rowSet.setUrl(DATABASE_URL); // set database URL
			rowSet.setUsername(USERNAME); // set username
			rowSet.setPassword(PASSWORD); // set password
			System.out.println("--------------------------------------------------");
			rowSet.setCommand("SELECT * FROM employee"); // set query
			rowSet.execute(); // execute query

			ResultSetMetaData metaData = rowSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			System.out.println("Employee Table of Books Database:\n");

			for (int i = 1; i <= numberOfColumns; i++)
				System.out.printf("%-8s\t", metaData.getColumnName(i));
			System.out.println();

			while (rowSet.next()) {
				for (int i = 1; i <= numberOfColumns; i++)
					System.out.printf("%-8s\t", rowSet.getObject(i));
				System.out.println();
			}
			System.out.println("--------------------------------------------------");
			rowSet.setCommand("SELECT * FROM salariedEmployee");
			rowSet.execute(); // execute query

			ResultSetMetaData metaData2 = rowSet.getMetaData();
			int numberOfColumns2 = metaData2.getColumnCount();
			System.out.println("salariedEmployee Table of Books Database:\n");

			for (int i = 1; i <= numberOfColumns2; i++)
				System.out.printf("%-8s\t", metaData2.getColumnName(i));
			System.out.println();

			while (rowSet.next()) {
				for (int i = 1; i <= numberOfColumns2; i++)
					System.out.printf("%-8s\t", rowSet.getObject(i));
				System.out.println();
			}
			System.out.println("--------------------------------------------------");
			rowSet.setCommand("SELECT * FROM commissionEmployee");
			rowSet.execute(); // execute query

			ResultSetMetaData metaData3 = rowSet.getMetaData();
			int numberOfColumns3 = metaData3.getColumnCount();
			System.out.println("commissionEmployee Table of Books Database:\n");

			for (int i = 1; i <= numberOfColumns3; i++)
				System.out.printf("%-8s\t", metaData3.getColumnName(i));
			System.out.println();

			while (rowSet.next()) {
				for (int i = 1; i <= numberOfColumns3; i++)
					System.out.printf("%-8s\t", rowSet.getObject(i));
				System.out.println();
			}
			System.out.println("--------------------------------------------------");
			rowSet.setCommand("SELECT * FROM basePlusCommissionEmployee");
			rowSet.execute(); // execute query

			ResultSetMetaData metaData4 = rowSet.getMetaData();
			int numberOfColumns4 = metaData4.getColumnCount();
			System.out.println("basePlusCommissionEmployee Table of Books Database:\n");

			for (int i = 1; i <= numberOfColumns4; i++)
				System.out.printf("%-8s\t", metaData4.getColumnName(i));
			System.out.println();

			while (rowSet.next()) {
				for (int i = 1; i <= numberOfColumns4; i++)
					System.out.printf("%-8s\t", rowSet.getObject(i));
				System.out.println();
			}
			System.out.println("--------------------------------------------------");
			rowSet.setCommand("SELECT * FROM hourlyEmployee");
			rowSet.execute(); // execute query

			ResultSetMetaData metaData5 = rowSet.getMetaData();
			int numberOfColumns5 = metaData5.getColumnCount();
			System.out.println("hourlyEmployee Table of Books Database:\n");

			for (int i = 1; i <= numberOfColumns5; i++)
				System.out.printf("%-8s\t", metaData5.getColumnName(i));
			System.out.println();

			while (rowSet.next()) {
				for (int i = 1; i <= numberOfColumns5; i++)
					System.out.printf("%-8s\t", rowSet.getObject(i));
				System.out.println();
			}

			
			rowSet.close();
		} 
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	} 

	public static void main(String args[]) {
		ConsultarConsola application = new ConsultarConsola();
	}
} 