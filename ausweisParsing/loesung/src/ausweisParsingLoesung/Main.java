package ausweisParsingLoesung;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line1 = scanner.nextLine();
		String line2 = scanner.nextLine();
		String line3 = scanner.nextLine();

		String[] line1parts = line1.split("<");
		String[] line2parts = line2.split("<");
		String[] line3parts = line3.split("<");

		String ausweisnummer = "";
		String geburtsdatum = "";
		String gültigkeitsdatum = "";
		String versionsnummer = "";
		String prüfziffer = "";
		String familienName = "";
		String vorname = "";

		for (String part : line1parts) {
			if (!part.isEmpty() && part != "IDD") {
				ausweisnummer = part;
			}
		}
			
		int position = 0;
		for (String part : line2parts) {
			if (!part.isEmpty()) {
				if (position == 0) {
					String jahr = part.substring(0, 2);
					String monat = part.substring(2, 4);
					String tag = part.substring(4, 6);
					geburtsdatum = tag + "." + monat + "." + jahr;
				} else if (position == 1) {
					String jahr = part.substring(0, 2);
					String monat = part.substring(2, 4);
					String tag = part.substring(4, 6);
					gültigkeitsdatum = tag + "." + monat + "." + jahr;
				} else {
					if (part.length() == 1) {
						prüfziffer = part;
					} else {
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
					familienName = part;
				} else {
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
}
