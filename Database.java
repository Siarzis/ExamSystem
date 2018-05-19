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
			
			Statement s = conn.createStatement();
			//count = s.executeUpdate (
			//		"INSERT INTO candidates_table (candidates_firstname, candidates_surname)"
			//		+ " VALUES"
			//		+ "('Frederick', 'Nicholson'),"
			//		+ "('Dexter ', 'Stone'),"
			//		+ "('Sam ', 'Davidson'),"
			//		+ "('Rory', 'Chambers')");
			s.close();
			//System.out.println (count + " rows were inserted");
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
	
	public boolean isUsernameRegistered(String username) {
		//get username query
		String query = "SELECT username FROM users WHERE username=" +"\""+username+"\""+";";
		
		try {
			Statement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query) ;
			if (rs!= null) {
				return true;
			}
			else {
				return false ;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}
	
	public static void main (String[] args) {
		Database db = new Database();
		db.establishConnection();
	}
}