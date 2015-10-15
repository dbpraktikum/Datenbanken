import java.sql.CallableStatement;
import java.sql.SQLException;



public class Registrierungsanwendung {
	
	//Klassenvariablen in denen die Logininformationen zur Datenbank gespeichert werden.
	private final String databaseUserName = "DB_PR2015_02_01";
	private final String databaseUserPassword = "Test123!";
	private final String dataBaseUrl = "jdbc:sqlserver://sqlserver.informatik.uni-mainz.de;" +
	         "databaseName=DB_PR2015_02";
	
	
	public String[] login(int personId, String userName, String userPassword, String rolle) {
		String[] loginData = null;
		CallableStatement stmt = ExecutionHelper.prepareCall(DatabaseConnector.connectToDatabase(databaseUserName, databaseUserPassword), "registrieren", 4);
		
		try {
			stmt.setInt("p_id", personId);
			stmt.setString("rolle", rolle);
			stmt.setString("benutzername", userName);
			stmt.setString("passwort", userPassword);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			   if (stmt != null) try { stmt.close(); } catch(Exception e) {}
		}
	return loginData;
	}
}
