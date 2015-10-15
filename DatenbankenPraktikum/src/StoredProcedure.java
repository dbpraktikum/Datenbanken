import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class StoredProcedure {
	/*
	 * Methode zum anlgen von Fl�chtlingen. Parameter gebDatum, einzugsdatum
	 * und date m�ssen in der Form YYYY-DD-MM sein. TODO
	 */
	  public static void anlegenFluechtling(Connection conn, String email,
	            String vorname, String nachname, String tel, String handy,
	            String geschlecht, String passExistiert, String gebDatum,
	              int unterkunft, String einzugsdatum,
	            String wunschland, String originalNachname, String originalVorname,
	            String aufenthalt, String gebdatValidiert, String antragstatus,
	             int sid, String thema, String date, String sprache,
	            String sprachniveau, String schreibniveau, String leseniveau,
	            String bezeichnung, String art, String lat, String lonG, String latr,
	            String longr, String staat, String stadt, String staatreg, String stadtreg) {
	        CallableStatement cstmt = ExecutionHelper.prepareCall(conn,
	                "GesFluechtlingAnlegen",33);
	 
	        try {
	            cstmt.setString("eMail", email);
	            cstmt.setString("vorname", vorname);
	            cstmt.setString("nachname", nachname);
	            cstmt.setString("tel", tel);
	            cstmt.setString("handy", handy);
	            cstmt.setString("geschlecht", geschlecht);
	            cstmt.setString("pass", passExistiert);
	           
	            cstmt.setString("geburtsdatum", gebDatum);
	            cstmt.setInt("unterkunft", unterkunft);
	            cstmt.setString("einzugsdatum", einzugsdatum);
	            cstmt.setString("wunschland", wunschland);
	            cstmt.setString("originalNn", originalNachname);
	            cstmt.setString("originalVn", originalVorname);
	            cstmt.setString("aufenthalt", aufenthalt);
	            cstmt.setString("gebdatumV", gebdatValidiert);
	            cstmt.setString("antragsstatus", antragstatus);
	            cstmt.setInt("sid", sid);
	            cstmt.setString("thema", thema);
	            cstmt.setString("date", date);
	            cstmt.setString("sprache", sprache);
	            cstmt.setString("sprachniveau", sprachniveau);
	            cstmt.setString("schreibniveau", schreibniveau);
	            cstmt.setString("leseniveau", leseniveau);
	            cstmt.setString("bezeichnung", bezeichnung);
	            cstmt.setString("art", art);
	            cstmt.setString("lat", lat);
	            cstmt.setString("long", lonG);
	            cstmt.setString("latr", latr);
	            cstmt.setString("longr", longr);
	            cstmt.setString("Staat", staat);
	            cstmt.setString("Stadt", stadt);
	            cstmt.setString("Staatreg", staatreg);
	            cstmt.setString("Stadtreg", stadtreg);
	 
	            cstmt.execute();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 
	    }
	/*
	 * Methode zum einfuegen von... Parameter aZeit muss in der Form HH:MM:SS.X
	 * sein.
	 */
	public static void anlegenAndere(Connection conn, int aid, String aTel,
			String aName, int amaxTn, String aZeit, String aOrt, int aGem,
			String wotag, String beschreibung) {
		// TODO
		String[] input = new String[9];
		input[0] = "" + aid;
		input[1] = "'" + aTel + "'";
		input[2] = "'" + aName + "'";
		input[3] = "" + amaxTn;
		input[4] = "'" + aZeit + "'";
		input[5] = "'" + aOrt + "'";
		input[6] = "" + aGem;
		input[7] = "'" + wotag + "'";
		input[8] = "'" + beschreibung + "'";

		CallableStatement cstmt = ExecutionHelper.prepareCall(conn,
				"GesAndereAnlegen",0);
	}

	/*
	 * Methode zum Anlegen von Helfern.
	 */
	   public static void anlegenHelfer(Connection conn, String email,
	            String vorname, String nachname, String tel, String handy,
	            int gemeinde, String strasse, int plz,
	            String hausnummer, String stadt) {
	 
	        CallableStatement cstmt = ExecutionHelper.prepareCall(conn,
	                "GesHelferAnlegen",10);
	 
	        try {
	            cstmt.setString("eMail", email);
	            cstmt.setString("vorname", vorname);
	            cstmt.setString("nachname", nachname);
	            cstmt.setString("tel", tel);
	            cstmt.setString("handy", handy);
	            cstmt.setInt("gemeinde", gemeinde);
	          
	            cstmt.setString("Strasse", strasse);
	            cstmt.setInt("PLZ", plz);
	            cstmt.setString("Hausnummer", hausnummer);
	            cstmt.setString("Stadt", stadt);
	 
	            cstmt.execute();
	 
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	 

	/*
	 * Methode zum Anlegen von Sacharbeitern.
	 */
	public static void anlegenSacharbeiter(Connection conn, String eMail,
			String vorname, String nachname, String tel, String handy,
			int gemeinde, String aktiv, String strasse, int plz,
			String hausnummer, String stadt, String ebene, String kreis, String bundesland) {

		CallableStatement cstmt = ExecutionHelper.prepareCall(conn,
				"GesSachbearbeiter",14);

		if(gemeinde == 0) {gemeinde = (Integer) null;}
		if(kreis == "") {kreis = null;}
		if(bundesland == "") {bundesland = null;}
		try {
			
			cstmt.setString("eMail", eMail);
			cstmt.setString("Vorname", vorname);
			cstmt.setString("Nachname", nachname);
			cstmt.setString("Tel", tel);
			cstmt.setString("Handy", handy);
			cstmt.setInt("GId", gemeinde);
			cstmt.setString("kreis_name", kreis);
			cstmt.setString("Name", bundesland);
			cstmt.setString("aktiv", aktiv);
			cstmt.setString("Strasse", strasse);
			cstmt.setInt("PLZ", plz);
			cstmt.setString("Hausnummer", hausnummer);
			cstmt.setString("Stadt", stadt);
			cstmt.setString("Ebene", ebene);

			cstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Methode zum Anlegen von Spenden.
	 */
	  public static void anlegenSpenden(Connection conn, String name, int anzahl,
	            int gid, String eMail, String vorname, String nachname, String tel,
	            String handy) {
	 
	        CallableStatement cstmt = ExecutionHelper.prepareCall(conn,
	                "GesSpendenAnlegen",8);
	 
	        try {
	            cstmt.setString("Name", name);
	            cstmt.setInt("Anzahl", anzahl);
	            cstmt.setInt("GId", gid);
	            cstmt.setString("eMail", eMail);
	            cstmt.setString("Vorname", vorname);
	            cstmt.setString("Nachname", nachname);
	            cstmt.setString("Tel", tel);
	            cstmt.setString("Handy", handy);
	 
	            cstmt.execute();
	 
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 
	    }

	/*
	 * Methode zum einf�gen von Sprachkursen Parameter aZeit muss in der Form
	 * HH:MM:SS.X sein.
	 */
	public static void anlegenSprachkurs(Connection conn, String aTel,
			String aName, int amaxTn, Time aZeit, String aOrt, int aGem,
			String wotag, String sprachniveau, String schreibnivau,
			String lesenivau, String beschreibung) {

		CallableStatement cstmt = ExecutionHelper.prepareCall(conn,
				"GesSprachkursAnlegen",11);

		try {
			cstmt.setString("aTel", aTel);
			cstmt.setString("aName", aName);
			cstmt.setInt("amaxTn", amaxTn);
			cstmt.setTime("aZeit", aZeit);
			cstmt.setString("aOrt", aOrt);
			cstmt.setInt("aGem", aGem);
			cstmt.setString("wotag", wotag);
			cstmt.setString("sprachniveau", sprachniveau);
			cstmt.setString("schreibnivau", schreibnivau);
			cstmt.setString("lesenivau", lesenivau);
			cstmt.setString("beschreibung", beschreibung);

			cstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateFluechtling(Connection conn,int PId ,String email,
            String vorname, String nachname, String tel, String handy,
            String geschlecht, String passExistiert, String gebDatum, 
              int unterkunft, String einzugsdatum,
            String wunschland, String originalNachname, String originalVorname,
            String aufenthalt, String gebdatValidiert, String antragstatus ) {
		CallableStatement cstmt = ExecutionHelper.prepareCall(conn,
				"GesFluechtlingUpdaten",17);

		try {
			cstmt.setInt("PId", PId);
			cstmt.setString("eMail", email);
			cstmt.setString("Vorname",vorname );
			cstmt.setString("Nachname", nachname);
			cstmt.setString("Tel", tel);
			cstmt.setString("Handy", handy);
			cstmt.setString("Geschlecht", geschlecht);
			cstmt.setString("Pass", passExistiert);
			cstmt.setString("Geburtsdatum", gebDatum);
			cstmt.setInt("Unterkunft", unterkunft);
			cstmt.setString("Einzugsdatum", einzugsdatum );
			cstmt.setString("Wunschland", wunschland);
		
			cstmt.setString("OriginalNachname",originalNachname);
			cstmt.setString("OriginalVorname", originalVorname );
			cstmt.setString("Aufenthaltsland", aufenthalt);
			cstmt.setString("GeburtsdatumV",gebdatValidiert );
			cstmt.setString("Antragsstatus", antragstatus);
			 

			cstmt.execute();

	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
