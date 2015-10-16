import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Loginanwendung {
	
	//Klassenvariablen in denen die Logininformationen zur Datenbank gespeichert werden.
	private final String databaseUserName = "DB_PR2015_02";
	private final String databaseUserPassword = "Test123!";
	private final String dataBaseUrl = "jdbc:sqlserver://sqlserver.informatik.uni-mainz.de;" +
	         "databaseName=DB_PR2015_02";
	
	
	public int login(String userName, String userPassword, String rolle) {
		int loginData = -1;
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 conn = DriverManager.getConnection(dataBaseUrl, databaseUserName, databaseUserPassword);
			 loginData = loginDatabase(conn, userName ,  userPassword, rolle);
			 conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			   if (rs != null) try { rs.close(); } catch(Exception e) {}
			   if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			   if (conn != null) try { conn.close(); } catch(Exception e) {}
		}
	return loginData;
	}
	
	private static int loginDatabase(Connection conn, String userId, String passwort, String rolle){
		int loginData = -1;
		String sql = "select DB_PR2015_02.dbo.anmelden('" + userId + "' , '" + passwort+"' , '" + rolle +"' )";
		Statement stmt;
		try {
			System.out.println(sql);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				loginData = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return loginData;
	}	
	
}


