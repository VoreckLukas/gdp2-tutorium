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

		
		System.out.printf(
				"URL(\n  schema = %s,\n  nutzer = %s,\n  kennwort = %s,\n  host = %s,\n  "+
				"port = %s,\n  pfad = %s,\n  query = %s,\n  fragment = %s\n)\n",
				schema, nutzer, kennwort, host, port, pfad, query, fragment);
	}
}