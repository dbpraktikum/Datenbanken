import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ExecutionHelper {
	
	/* 
	 * Methode zum ausführen einer gespeicherten Prozedur.
	 * Parameter: conn Datendankverbindung, storedProcedure Name der Prozedur, paramValue Liste der Eingaben
	 * 
	 */
	public static void executeStoredProcedure(Connection conn,String storedProcedure,String[] paramValue){
		StringBuilder sql = new StringBuilder("exec "+ storedProcedure);
		sql.append(" "+paramValue[0]);
		for(int i = 1; i < paramValue.length;i++){
			sql.append(", " + paramValue[i]);
		}
		try {
			Statement stmt = conn.createStatement();
			System.out.println(sql.toString());
			stmt.execute(sql.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static CallableStatement prepareCall(Connection conn, String procedureName){
		CallableStatement cstmt = null;
		try {
			cstmt = conn.prepareCall("{call " + procedureName + "(?)}",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cstmt;
	}
	public static String[] loginDatabase(Connection conn, String userId, String passwort, String rolle){
		String[] loginData = new String[3];
		String sql = "select * from anmelden('" + userId + "' , '" + passwort+"' , '" + rolle +"' )";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				loginData[0] = rs.getString(1);
				loginData[1] = rs.getString(2);
				loginData[2] = rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return loginData;
	}	
	
	public static ResultSet callFunction(Connection conn, String functionName, String[] paramValue){
		ResultSet rs = null;
		Statement stmt = null;
		StringBuilder sql =  new StringBuilder("select * from " + functionName + " (" );
		
		if (paramValue != null){
			sql.append(paramValue[0]);
			for (int i = 1; i < paramValue.length; i++){
				sql.append(", "+ paramValue[i]);
			}
		}
		sql.append(")");
		try {
			stmt = conn.createStatement();
			System.out.println(sql.toString());
			rs = stmt.executeQuery(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rs;
	}
}
