package ausweisParsingLoesung;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Es gibt 3 mögliche lösungen
		splitWithLoop();
		splitWithArray();
		substring();
	}
	
	// Mit Splitting bearbeiten, ohne die teilstringe in ein anderes array zu speichern
	public static void splitWithLoop() {
		Scanner scanner = new Scanner(System.in);
		String line1 = scanner.nextLine();
		String line2 = scanner.nextLine();
		String line3 = scanner.nextLine();

		String ausweisnummer = "";
		String geburtsdatum = "";
		String gültigkeitsdatum = "";
		String versionsnummer = "";
		String prüfziffer = "";
		String familienName = "";
		String vorname = "";

		String[] line1parts = line1.split("<");
		String[] line2parts = line2.split("<");
		String[] line3parts = line3.split("<");

		for (String part : line1parts) {
			// In der ersten zeile gibt es nur 2 nicht leere strings. der IDD string kann ignoriert werden
			if (!part.isEmpty() && part != "IDD") {
				ausweisnummer = part;
			}
		}
			
		int position = 0;
		for (String part : line2parts) {
			if (!part.isEmpty()) {
				if (position == 0) {
					// Der erste nicht leere string ist das geburtsdatum
					String jahr = part.substring(0, 2);
					String monat = part.substring(2, 4);
					String tag = part.substring(4, 6);
					geburtsdatum = tag + "." + monat + "." + jahr;
				} else if (position == 1) {
					// Der zweite das gültigkeitsdatum
					String jahr = part.substring(0, 2);
					String monat = part.substring(2, 4);
					String tag = part.substring(4, 6);
					gültigkeitsdatum = tag + "." + monat + "." + jahr;
				} else {
					// Die letzten beiden kann man im selben fall behandeln
					if (part.length() == 1) {
						// Falls der string nur einen char hat, ist es die prüfziffer
						prüfziffer = part;
					} else {
						// Ansonsten die versionsnummer
						versionsnummer = part;
					}
				}
				position++;
			}
		}
		
		position = 0;
		for (String part : line3parts) {
			if (!part.isEmpty()) {
				if (position == 0) {
					// Der erste nicht leere string ist der familien name
					familienName = part;
				} else {
					// Der zweite der vorname
					vorname = part;
				} 				
				position++;
			}
		}
		
		System.out.println("Ausweisnummer: " + ausweisnummer);
		System.out.println("Geburtsdatum: " + geburtsdatum);
		System.out.println("Gültigkeitsdatum: " + gültigkeitsdatum);
		System.out.println("Versionsnummer: " + versionsnummer);
		System.out.println("Prüfziffer: " + prüfziffer);
		System.out.println("Familienname: " + familienName);
		System.out.println("Vorname: " + vorname);
	}

	// Mit Splitting bearbeiten, indem man die teilstringe in ein anderes array speichert
	public static void splitWithArray() {
		Scanner scanner = new Scanner(System.in);
		String line1 = scanner.nextLine();
		String line2 = scanner.nextLine();
		String line3 = scanner.nextLine();

		String ausweisnummer = "";
		String geburtsdatum = "";
		String gültigkeitsdatum = "";
		String versionsnummer = "";
		String prüfziffer = "";
		String familienName = "";
		String vorname = "";

		String[] line1parts = line1.split("<");
		String[] line2parts = line2.split("<");
		String[] line3parts = line3.split("<");

		String[] filteredLine1Parts = new String[2];
		int line1PartsLength = 0; // filteredLine1Parts.length() gibt immer 2 zurück, auch wenn das array leer ist
		for (String part : line1parts) {
			if (!part.isEmpty()) {
				filteredLine1Parts[line1PartsLength] = part;
				line1PartsLength++;
			}
		}
		ausweisnummer = filteredLine1Parts[1];
			
		String[] filteredLine2Parts = new String[4];
		int line2PartsLength = 0;
		for (String part : line2parts) {
			if (!part.isEmpty()) {
				filteredLine2Parts[line2PartsLength] = part;
				line2PartsLength++;
			}
		}
		geburtsdatum = filteredLine2Parts[0];
		geburtsdatum = geburtsdatum.substring(0, 2) + "." + geburtsdatum.substring(2, 4) + "." + geburtsdatum.substring(4, 6);
		gültigkeitsdatum = filteredLine2Parts[1];
		gültigkeitsdatum = gültigkeitsdatum.substring(0, 2) + "." + gültigkeitsdatum.substring(2, 4) + "." + gültigkeitsdatum.substring(4, 6);
		if (line2PartsLength == 4) {
			versionsnummer = filteredLine2Parts[2];
		}
		prüfziffer = filteredLine2Parts[line2PartsLength - 1];
		
		String[] filteredLine3Parts = new String[2];
		int line3PartsLength = 0;
		for (String part : line3parts) {
			if (!part.isEmpty()) {
				filteredLine3Parts[line3PartsLength] = part;
				line3PartsLength++;
			}
		}
		familienName = filteredLine3Parts[0];
		vorname = filteredLine3Parts[1];
		
		System.out.println("Ausweisnummer: " + ausweisnummer);
		System.out.println("Geburtsdatum: " + geburtsdatum);
		System.out.println("Gültigkeitsdatum: " + gültigkeitsdatum);
		System.out.println("Versionsnummer: " + versionsnummer);
		System.out.println("Prüfziffer: " + prüfziffer);
		System.out.println("Familienname: " + familienName);
		System.out.println("Vorname: " + vorname);
	}

	// Mit indexof und substring
	public static void substring() {
		Scanner scanner = new Scanner(System.in);
		String line1 = scanner.nextLine();
		String line2 = scanner.nextLine();
		String line3 = scanner.nextLine();

		String ausweisnummer = "";
		String geburtsdatum = "";
		String gültigkeitsdatum = "";
		String versionsnummer = "";
		String prüfziffer = "";
		String familienName = "";
		String vorname = "";

		// Ignoriere den IDD teil
		line1 = line1.substring(line1.indexOf("<"));
		// Ignoriere die pfeile
		while (line1.startsWith("<")) {
			line1 = line1.substring(1);
		}
		// Finde den index des ersten pfeils nach der nummer und extrahiere die nummer
		ausweisnummer = line1.substring(0, line1.indexOf("<"));
		
		// Extrahiere das geburtsdatum
		geburtsdatum = line2.substring(0, line2.indexOf("<"));
		geburtsdatum = geburtsdatum.substring(0, 2) + "." + geburtsdatum.substring(2, 4) + "." + geburtsdatum.substring(4, 6);
		// ignoriere das geburtsdatum
		line2 = line2.substring(line2.indexOf("<"));
		// Ignoriere die pfeile
		while (line2.startsWith("<")) {
			line2 = line2.substring(1);
		}
		// Extrahiere das gültigkeitsdatum
		gültigkeitsdatum = line2.substring(0, line2.indexOf("<"));
		gültigkeitsdatum = gültigkeitsdatum.substring(0, 2) + "." + gültigkeitsdatum.substring(2, 4) + "." + gültigkeitsdatum.substring(4, 6);
		// ignoriere das gültigkeitsdatum
		line2 = line2.substring(line2.indexOf("<"));
		// Ignoriere die pfeile
		while (line2.startsWith("<")) {
			line2 = line2.substring(1);
		}
		// Falls der verbleibende string nur eine stelle hat gibt es nur die Prüfziffer, wenn mehr gibt es die versionsnumme
		if (line2.length() > 1) {
			// Extrahiere die versionsnummer
			versionsnummer = line2.substring(0, line2.indexOf("<"));
			// Ignoriere die versionsnummer
			line2 = line2.substring(line2.indexOf("<"));
			// Ignoriere die pfeile
			while (line2.startsWith("<")) {
				line2 = line2.substring(1);
			}
			// der rest ist die prüfziffer
		}
		prüfziffer = line2;
		
		// Extrahiere den Familien namen
		familienName = line3.substring(0, line3.indexOf("<"));
		// ignoriere den Familiennamen
		line3 = line3.substring(line3.indexOf("<"));
		// Ignoriere die pfeile
		while (line3.startsWith("<")) {
			line3 = line3.substring(1);
		}
		// Extrahiere den Vornamen
		vorname = line3.substring(0, line3.indexOf("<"));

		System.out.println("Ausweisnummer: " + ausweisnummer);
		System.out.println("Geburtsdatum: " + geburtsdatum);
		System.out.println("Gültigkeitsdatum: " + gültigkeitsdatum);
		System.out.println("Versionsnummer: " + versionsnummer);
		System.out.println("Prüfziffer: " + prüfziffer);
		System.out.println("Familienname: " + familienName);
		System.out.println("Vorname: " + vorname);
	}
}
