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
	public static CallableStatement prepareCall(Connection conn, String procedureName, int numberOfParameter){
		CallableStatement cstmt = null;
		StringBuilder sql = new StringBuilder("{call " + procedureName + "(?");
		for(int i = 0; i < numberOfParameter - 1; i++){
			sql.append(",?");
			System.out.println(i);
		}
		sql.append(")}");
		try {
			System.out.println(sql.toString());
			cstmt = conn.prepareCall(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cstmt;
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
	
	public static ResultSet callFunction(Connection conn, String functionName, int value){
		String[] input = new String[1];
		input[0] = ""+ value;
		return ExecutionHelper.callFunction(conn, functionName,input);
	}
	
	public static ResultSet callFunction(Connection conn, String functionName, String value){
		String[] input = new String[1];
		input[0] = "'"+ value + "'";
		return ExecutionHelper.callFunction(conn, functionName,input);
	}
	
}
