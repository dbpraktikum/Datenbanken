import java.sql.Connection;
import java.sql.ResultSet;


public class Functions {
	
	public static ResultSet adresseEinerUnterkunft(Connection conn, int uid){
		return ExecutionHelper.callFunction(conn, "AdresseUnterkunft",uid);
	}
	
	public static ResultSet alleBundeslaenderSehen(Connection conn){
		String[] i = null;
		return ExecutionHelper.callFunction(conn, "AlleBundeslaenderSehen",i);
	}
	
	public static ResultSet angeboteSehenAndere(Connection conn, int gid){
		return ExecutionHelper.callFunction(conn, "Angebotesehen_Andere",gid);
	}
	
	public static ResultSet angeboteSehenSprachkurse(Connection conn, int gid){
		return ExecutionHelper.callFunction(conn, "Angebotesehen_Sprachkurse",gid);
	}
	
	public static ResultSet anzeigenBundesland(Connection conn, String name){
		return ExecutionHelper.callFunction(conn, "Anzeigen_Bundesland",name);
	}
	
	public static ResultSet anzeigenGemeinde(Connection conn, int gid){
		return ExecutionHelper.callFunction(conn, "Anzeigen_Gemeinde",gid);
	}
	
	public static ResultSet anzeigenKreis(Connection conn, String kreisName){
		return ExecutionHelper.callFunction(conn, "Anzeigen_Kreis",kreisName);
	}
	
	public static ResultSet anzeigenAusstattungUnterkunft(Connection conn, int uid){
		return ExecutionHelper.callFunction(conn, "AusstattungUnterkunft",uid);
	}
	
	public static ResultSet anzeigenFluechtlingeInGemeinde(Connection conn, int gid){
		return ExecutionHelper.callFunction(conn, "FluechtlingeInGemeinde",gid);
	}
	
	public static ResultSet anzeigenFluechtlingeInGemeindeKommenAus(Connection conn, int gid, int kommtausId){
		String[] input = new String[2];
		input[0] = ""+ gid;
		input[1] = ""+ kommtausId;
		return ExecutionHelper.callFunction(conn, "FluechtlingeInGemeindeKommenAus",input);
	}
	
	public static ResultSet anzeigenFluechtlingeInKreis(Connection conn, String kreisName){
		return ExecutionHelper.callFunction(conn, "FluechtlingeInKreis",kreisName);
	}
	
	public static ResultSet anzeigenFluechtlingeInKreisKommenAus(Connection conn, String kreisName, int kommtausId){
		String[] input = new String[2];
		input[0] = "'"+ kreisName + "'";
		input[1] = "" + kommtausId;
		return ExecutionHelper.callFunction(conn, "FluechtlingeInKreisKommenAus",input);
	}
	
	public static ResultSet anzeigenFluechtlingeInUnterkunft(Connection conn, int uid){
		return ExecutionHelper.callFunction(conn, "FluechtlingeInUnterkunft",uid);
	}
	
	public static ResultSet anzeigenFluechtlingeInUnterkunftKommenAus(Connection conn, int uid, int kommtausId){
		String[] input = new String[2];
		input[0] = ""+ uid;
		input[1] = "" + kommtausId;
		return ExecutionHelper.callFunction(conn, "FluechtlingeInKreisKommenAus",input);
	}
	
	public static ResultSet sucheFluechtlingMitOrginalName(Connection conn, String vorname, String nachname){
		String[] input = new String[2];
		input[0] = "'"+ vorname + "'";
		input[1] = "'" + nachname + "'";
		return ExecutionHelper.callFunction(conn, "FluechtlingeSuchenOrginalname",input);
	}
	
	public static ResultSet anzeigenFluechtling(Connection conn, int fid){
		return ExecutionHelper.callFunction(conn, "FluechtlingPersoenlicheDaten",fid);
	}
	
	public static ResultSet anzeigenFluechtlinQualifikationen(Connection conn, int fid){
		return ExecutionHelper.callFunction(conn, "FluechtlingQualifikationen",fid);
	}
	
	public static ResultSet anzeigenFluechtlinSprachen(Connection conn, int fid){
		return ExecutionHelper.callFunction(conn, "FluechtlingSprachen",fid);
	}
	
	public static ResultSet anzeigenFluechtlinVerwandschaft(Connection conn, int fid){
		return ExecutionHelper.callFunction(conn, "FluechtlingVerwandtMit",fid);
	}
	
	public static ResultSet anzeigenGemeindenImKreis(Connection conn, String kreisName){
		return ExecutionHelper.callFunction(conn, "GemeindenImKreisSehen",kreisName);
	}
	
	public static ResultSet anzeigenFluechtlingeVonHelfer(Connection conn, int hid){
		return ExecutionHelper.callFunction(conn, "HelferFluechtling",hid);
	}
	
	public static ResultSet anzeigenHelfer(Connection conn, int hid){
		return ExecutionHelper.callFunction(conn, "HelferPersoenlicheDaten",hid);
	}
	
	public static ResultSet anzeigenUnterkunftFuerHelfer(Connection conn, int uid){
		return ExecutionHelper.callFunction(conn, "HelferSiehtUnterkunft",uid);
	}
	
	public static ResultSet anzeigenVorsteherVonHelfer(Connection conn, int hid){
		return ExecutionHelper.callFunction(conn, "HelferVorsteher",hid);
	}
	
	public static ResultSet anzeigenKommentareUeberAngebot(Connection conn, int aid){
		return ExecutionHelper.callFunction(conn, "KommentareUeberAngebotSehen",aid);
	}
	
	public static ResultSet anzeigenKommentareUeberFluechtling(Connection conn, int aid){
		return ExecutionHelper.callFunction(conn, "KommentareUeberFluechtlingSehen",aid);
	}
	
	public static ResultSet anzeigenKommentareUeberUnterkunft(Connection conn, int uid){
		return ExecutionHelper.callFunction(conn, "KommentareUeberUnterkunftSehen",uid);
	}
	
	public static ResultSet anzeigenKreiseImBundesland(Connection conn, String bundeslandName){
		return ExecutionHelper.callFunction(conn, "KreisImBundeslandSehen",bundeslandName);
	}
	
	public static ResultSet suchePersonMitNamen(Connection conn, String vorname, String nachname){
		String[] input = new String[2];
		input[0] = "'"+ vorname + "'";
		input[1] = "'" + nachname + "'";
		return ExecutionHelper.callFunction(conn, "NachNamenSuchen",input);
	}
	
	public static ResultSet anzeigenOeffentlicheSpendenInGemeinde(Connection conn, int gid){
		return ExecutionHelper.callFunction(conn, "OeffentlichSpendenSehen",gid);
	}
	
	public static ResultSet anzeigenSachbearbeiter(Connection conn, int sid){
		return ExecutionHelper.callFunction(conn, "SachbearbeiterPersoenlicheDaten",sid);
	}
	
	public static ResultSet sachbearbeiterSuchtSeineFluechtlinge(Connection conn, int sid){
		return ExecutionHelper.callFunction(conn, "SachbearbeiterSiehtAlleSeineFluechtling",sid);
	}
	
	public static ResultSet sachbearbeiterSuchtSpezielleFluechtlinge(
			Connection conn, int fid) {
		return ExecutionHelper.callFunction(conn, "SachbearbeiterSiehtSpeziellenFluechtling",fid);
	}
	
	public static ResultSet anzeigenSpendenInGemeinde(Connection conn, int gid){
		return ExecutionHelper.callFunction(conn, "SpendenGemeinde",gid);
	}
	
	public static ResultSet anzeigenUnterkuenfteInGemeinde(Connection conn, int gid){
		return ExecutionHelper.callFunction(conn, "UnterkuenfteInGemeindeSehen",gid);
	}
	
	
	
	
	
	
	
	public static ResultSet kreiseImBundesland(Connection conn, String bundeslandName){
		String[] input = new String[1];
		input[0] = "'"+ bundeslandName + "'";
		return ExecutionHelper.callFunction(conn, "KreiseImBundeslandSehen",input);
	}
	
	public static ResultSet gemeindenImKreis(Connection conn, String kreisName){
		String[] input = new String[1];
		input[0] = "'"+ kreisName + "'";
		return ExecutionHelper.callFunction(conn, "GemeindenImKreisSehen",input);
	}
	
	public static ResultSet unterkuenfteInGemeinde(Connection conn, String gemeindeId){
		String[] input = new String[1];
		input[0] = "'"+ gemeindeId + "'";
		return ExecutionHelper.callFunction(conn, "UnterkuenfteInGemeindeSehen",input);
	}
	
	public static ResultSet fluechtlingeInGemeinde(Connection conn, String gemeindeId){
		String[] input = new String[1];
		input[0] = "'"+ gemeindeId + "'";
		return ExecutionHelper.callFunction(conn, "FluechtlingeInGemeinde",input);
	}
	
	public static ResultSet fluechtlingeInKreis(Connection conn, String kreis){
		String[] input = new String[1];
		input[0] = "'"+ kreis + "'";
		return ExecutionHelper.callFunction(conn, "FluechtlingeInKreis",input);
	}
	
	public static ResultSet fluechtlingeInBundesland(Connection conn, String bundesland){
		String[] input = new String[1];
		input[0] = "'"+ bundesland + "'";
		return ExecutionHelper.callFunction(conn, "FluechtlingeInBundesland",input);
	}
	
	
	
	
	
	
	
	public static void main(String... args){
		System.out.println(alleBundeslaenderSehen(DatabaseConnector.connectToDatabase("DB_PR2015_02_01", "Test123!")));
	}

}
