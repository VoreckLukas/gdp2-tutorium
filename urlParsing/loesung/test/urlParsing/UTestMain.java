package urlParsing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UTestMain extends Helper {
	private static final String DEF = "";

	@Test
	public void test_main_00() {
		test("https", "max", "muster", "www.example.com", "8080", "index.html", "p1=A&p2=B", "ressource");
	}
	
	@Test
	public void test_main_01() {
		test("https", DEF, DEF, "heise.de", DEF, DEF, DEF, DEF);
	}
	
	@Test
	public void test_main_02() {
		test("http", DEF, DEF, "gdp2.codestack.de", DEF, "chapter02.html", DEF, "/1/1");
	}
	
	@Test
	public void test_main_03() {
		test("file", DEF, DEF, DEF, DEF, "irgend/ein/pfad.txt", DEF, DEF);
	}
	
	@Test
	public void test_main_04() {
		test("https", DEF, DEF, "lmgtfy.com", DEF, DEF, "q=String+Java", DEF);
	}
	
	@Test
	public void test_main_05() {
		test("https", DEF, DEF, "media.giphy.com", DEF, "media/LmNwrBhejkK9EFP504/giphy.gif", DEF, DEF);
	}
	
	private void test(String schema, String nutzer, String kennwort, String host, String port, String pfad, String query, String fragment) {
		String b = build(schema, nutzer, kennwort, host, port, pfad, query, fragment);
		provideInput(b);
		Main.main(new String[0]);
		String output = getOutput();
		String expected = String.format(
				"URL(\n  schema = %s,\n  nutzer = %s,\n  kennwort = %s,\n  host = %s,\n  port = %s,\n  pfad = %s,\n  query = %s,\n  fragment = %s\n)\n",
				schema, nutzer, kennwort, host, port, pfad, query, fragment);
		assertEquals("URL wurde nicht korrekt verarbeitet", expected, output);
	}
	
	private void fail(String schema, String nutzer, String kennwort, String host, String port, String pfad, String query, String fragment) {
		String b = build(schema, nutzer, kennwort, host, port, pfad, query, fragment);
		provideInput(b);
		Main.main(new String[0]);
		String output = getOutput();
		assertEquals("Es sollte ein Fehler kommen", output.startsWith("Fehler"));
	}

	private String build(String schema, String nutzer, String kennwort, String host, String port,
			String pfad, String query, String fragment) {
		StringBuilder b = new StringBuilder();
		
		b.append(schema).append("://");
		if(!DEF.equals(nutzer) || !DEF.equals(kennwort)) {
			b.append(nutzer);
			if(!DEF.equals(kennwort)) {
				b.append(':').append(kennwort);
			}
			b.append('@');
		}
		b.append(host);
		if(!DEF.equals(port)) {
			b.append(':').append(port);
		}
		if(!DEF.equals(pfad)) {
			b.append('/').append(pfad);
		}
		if(!DEF.equals(query)) {
			b.append('?').append(query);
		}
		if(!DEF.equals(fragment)) {
			b.append('#').append(fragment);
		}
		return b.toString();
	}
}