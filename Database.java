import java.sql.*;

public class Database {
	
	private Connection conn = null;
	
	public void establishConnection() {
		try {
			String username = "root";
			String password = "#11Dijkardmysql";
			String url = "jdbc:mysql://localhost:3306/candidates?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Database connection established");
		}
		catch (Exception e) {
			System.err.println(e);
			System.err.println("Cannot connect to database server");
		}
		finally {
			if (conn != null) {
				try {
					conn.close ();
					System.out.println("Database connection terminated");
				}
				catch (Exception e) {
					/* ignore close errors */
				}
			}
		}
	}
	
	public void createDatabaseTable () {
		// create new table
		try { 
			Statement s = conn.createStatement();
			int count;
			s.executeUpdate ("DROP TABLE IF EXISTS candidates_table");
			s.executeUpdate (
					"CREATE TABLE candidates_table ("
					+ "id INT UNSIGNED NOT NULL AUTO_INCREMENT,"
					+ "PRIMARY KEY (id),"
					+ "firstname CHAR(100) NOT NULL, surname CHAR(100) NOT NULL)");
			count = s.executeUpdate (
					"INSERT INTO candidates_table (firstname, surname)"
					+ " VALUES"
					+ "('Frederick', 'Nicholson'),"
					+ "('Dexter', 'Stone'),"
					+ "('Sam', 'Davidson'),"
					+ "('Rory', 'Chambers')");
			System.out.println (count + " rows were inserted");
		}
		catch (SQLException e) {
			System.err.println ("Error message: " + e.getMessage ());
			System.err.println ("Error number: " + e.getErrorCode ());
		}
	}
	
	public boolean isUsernameRegistered() {
		boolean flag = false;
		
		try {
			Statement s = conn.createStatement();
			
			// check if record exist
			s.executeQuery("SELECT * FROM candidates_table WHERE firstname = 'Sam'");
			ResultSet rs = s.getResultSet();
			if (rs.next()) {
				System.out.println("Success!");
				int idVal = rs.getInt ("id");
				String nameVal = rs.getString ("firstname");
				String catVal = rs.getString ("surname");
				System.out.println ("id = " + idVal + ", FirstName = " + nameVal + ", Surname = " + catVal);
				flag = true;
			}
			else {
				System.out.println("Failure...");
			}
			rs.close();
			s.close();
		}
		catch (SQLException e) {
			System.err.println ("Error message: " + e.getMessage ());
			System.err.println ("Error number: " + e.getErrorCode ());
		}
		return flag;
	}

	public static void main (String[] args) {
		Database db = new Database();
		db.establishConnection();
	}
}