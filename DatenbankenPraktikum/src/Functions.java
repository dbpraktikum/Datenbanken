import java.sql.Connection;
import java.sql.ResultSet;


public class Functions {
	
	public static ResultSet sachbearbeiterSuchtSeineFluechtlinge(Connection conn, int sid){
		String[] input = new String[1];
		input[0] = ""+sid;
		return ExecutionHelper.callFunction(conn, "SachbearbeiterSiehtAlleSeineFluechtling",input);
	}
	
	public static ResultSet sachbearbeiterSuchtSpezielleFluechtlinge(Connection conn, int fid){
		String[] input = new String[1];
		input[0] = ""+fid;
		return ExecutionHelper.callFunction(conn, "SachbearbeiterSiehtSpeziellenFluechtling",input);
	}
	
	public static ResultSet alleBundeslaenderSehen(Connection conn){
		return ExecutionHelper.callFunction(conn, "AlleBundeslaenderSehen",null);
	}
	
	public static ResultSet angeboteSehenAndere(Connection conn, int gid){
		String[] input = new String[1];
		input[0] = ""+gid;
		return ExecutionHelper.callFunction(conn, "Angebotesehen_Andere",input);
	}
	public static ResultSet angeboteSehenSprachkurse(Connection conn, int gid){
		String[] input = new String[1];
		input[0] = ""+gid;
		return ExecutionHelper.callFunction(conn, "Angebotesehen_Sprachkurse",input);
	}
	public static ResultSet kreiseImBundesland(Connection conn, String bundeslandName){
		String[] input = new String[1];
		input[0] = "'"+ bundeslandName + "'";
		return ExecutionHelper.callFunction(conn, "Angebotesehen_Sprachkurse",input);
	}
	public static ResultSet adresseEinerUnterkunft(Connection conn,int uid){
		String[] input = new String[1];
		input[0] = ""+ uid;
		return ExecutionHelper.callFunction(conn, "AdresseUnterkunft",input);
	}
	
	
	
	public static void main(String... args){
		System.out.println(alleBundeslaenderSehen(DatabaseConnector.connectToDatabase("DB_PR2015_02_01", "Test123!")));
	}
}
