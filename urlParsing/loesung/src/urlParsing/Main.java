package urlParsing;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String schema = "",
				nutzer = "",
				kennwort = "",
				host = "",
				port = "",
				pfad = "",
				query = "",
				fragment = "";

		
		// Extrahiere Schema
		int schemaEnd = input.indexOf("://");
		if (schemaEnd == -1) {
			System.out.println("Fehler, kein Schema gefunden");
			return;
		}
		schema = input.substring(0, schemaEnd);
		input = input.substring(schemaEnd + 3); // entferne <schema>://

		// Verarbeite Nutzer und Kennwort gemeinsam
		int authEnd = input.indexOf("@");
		if (authEnd != -1) {
			String auth = input.substring(0, authEnd);
			String[] authParts = auth.split(":");
			if (authParts.length > 0) {
				nutzer = authParts[0];
			}
			if (auth.length() > 1) {
				kennwort = authParts[1];
			}
			input = input.substring(authEnd + 1); // entferne <user>:<pass>@
		}

		// Verarbeite Fragment, Query, Pfad und Host:Port gemeinsam 
		// in umgekehrter Reihenfolge
		if (input.length() > 0) {
			// Pruefe ob es ein Fragment gibt, und verarbeite
			int fragmentBegin = input.indexOf('#');
			if (fragmentBegin != -1) {
				fragment = input.substring(fragmentBegin + 1);
				input = input.substring(0, fragmentBegin);
			}
			// Pruefe ob es einen Query-Part gibt, und verarbeite
			int queryBegin = input.indexOf('?');
			if (queryBegin != -1) {
				query = input.substring(queryBegin + 1);
				input = input.substring(0, queryBegin);
			}
			// Pruefe ob es einen Pfad gibt, und verarbeite
			int pfadBegin = input.indexOf('/');
			if (pfadBegin != -1) {
				pfad = input.substring(pfadBegin + 1);
				input = input.substring(0, pfadBegin);
			}
			// Der Rest ist Host:Port, Fehler wenn dem nicht so!
			if (input.length() > 0) {
				String[] hostParts = input.split(":");
				if (hostParts.length > 0) {
					host = hostParts[0];
				}
				if (hostParts.length > 1) {
					port = hostParts[1];
				}
			}
		}
		
		System.out.printf(
				"URL(\n  schema = %s,\n  nutzer = %s,\n  kennwort = %s,\n  host = %s,\n  "+
				"port = %s,\n  pfad = %s,\n  query = %s,\n  fragment = %s\n)\n",
				schema, nutzer, kennwort, host, port, pfad, query, fragment);

	}
}