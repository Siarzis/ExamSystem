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
	}
	
	public void createDatabaseTable() {
		// create new table
		
		Statement s = null;
		try { 
			s = conn.createStatement();
			int count;
			s.executeUpdate ("DROP TABLE IF EXISTS candidates_table");
			s.executeUpdate (
					"CREATE TABLE candidates_table ("
					+ "id INT UNSIGNED NOT NULL AUTO_INCREMENT,"
					+ "PRIMARY KEY (id),"
					+ "username CHAR(20) NOT NULL, password CHAR(20) NOT NULL)");
			count = s.executeUpdate (
					"INSERT INTO candidates_table (username, password)"
					+ " VALUES"
					+ "('Frederick', '=qXuSzq7n>n:T7nR'),"
					+ "('Dexter', 'ryqDY6MrdtWhM{x'),"
					+ "('Sam', 'A?Js[F/.3xk7]W/6'),"
					+ "('Rory', '=M2AL-4t%h[=j*ky')");
			System.out.println (count + " rows were inserted");
		}
		catch (SQLException e) {
			System.err.println ("Error message: " + e.getMessage ());
			System.err.println ("Error number: " + e.getErrorCode ());
		}
		finally {
			try { if (s != null) s.close(); } catch (Exception e) {};
			try {
				if (conn != null) {
					conn.close();
					System.out.println("Database connection terminated");
				}
			} catch (Exception e) {};
		}
	}
	
	public boolean isUsernameRegistered(String usr, String pass) {
		
		boolean flag = false;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			s = conn.createStatement();
			
			// check if record exist
			s.executeQuery(
					"SELECT * "
					+ "FROM candidates_table "
					+ "WHERE username = '"+usr+"' AND password = '"+pass+"'");
			rs = s.getResultSet();
			if (rs.next()) {
				System.out.println("Success!");
				int idVal = rs.getInt("id");
				String nameVal = rs.getString("username");
				String catVal = rs.getString ("password");
				System.out.println ("id = " + idVal + ", Username = " + nameVal + ", Password = " + catVal);
				flag = true;
			}
			else {
				System.out.println("Failure...");
			}
		}
		catch (SQLException e) {
			System.err.println ("Error message: " + e.getMessage ());
			System.err.println ("Error number: " + e.getErrorCode ());
		}
		finally {
			try { if (rs != null) rs.close();} catch (Exception e) {};
			try { if (s != null) s.close(); } catch (Exception e) {};
			try {
				if (conn != null) {
					conn.close();
					System.out.println("Database connection terminated");
				}
			} catch (Exception e) {};
		}
		return flag;
	}

	public static void main (String[] args) {
		//Database db = new Database();
		//db.establishConnection();
		//db.createDatabaseTable();
		//db.establishConnection();
		//db.isUsernameRegistered("Frederick", "=qXuSzq7n>n:T7nR");
	}
}