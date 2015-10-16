import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Registrierungsanwendung {
	
	//Klassenvariablen in denen die Logininformationen zur Datenbank gespeichert werden.
	private final String databaseUserName = "DB_PR2015_02";
	private final String databaseUserPassword = "Test123!";
	private final String dataBaseUrl = "jdbc:sqlserver://sqlserver.informatik.uni-mainz.de;" +
	         "databaseName=DB_PR2015_02";
	
	
	public boolean registrieren(int personId, String userName, String userPassword) {
		
		
		
		CallableStatement stmt = null;
		StringBuilder sql = new StringBuilder("{call " + "registrieren" + "(?");
		for(int i = 0; i < 3; i++){
			sql.append(",?");
		}
		sql.append(")}");
		try {
			System.out.println(sql.toString());
			stmt = DatabaseConnector.connectToDatabase(databaseUserName, databaseUserPassword).prepareCall(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		try {
			stmt.setInt("p_id", personId);
			stmt.setString("benutzername", userName);
			stmt.setString("passwort", userPassword);
			stmt.registerOutParameter("success", java.sql.Types.INTEGER);
			stmt.execute();
			
			return (1 == stmt.getInt("success"));
		} catch (SQLException e) {
			System.out.println("Benutzername schon vergeben");
			//e.printStackTrace();
		}
		finally {
			   if (stmt != null) try { stmt.close(); } catch(Exception e) {}
		}
		System.out.println("IMMER FALSE");
	return false;
	}
}
