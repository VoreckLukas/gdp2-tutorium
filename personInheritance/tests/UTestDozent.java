import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class UTestDozent extends Helper {
	@Test
	public void test_structure_00() {
		try {
			Class<?> testClass = UTestPerson.class.getClassLoader().loadClass("Dozent");
			checkMethod(testClass, int.class, "getPersonalNummer");
			checkMethod(testClass, String.class, "getTelefon");
			checkMethod(testClass, String.class, "generateId");
			checkMethod(testClass, String.class, "toString");
			checkMethod(testClass, void.class, "aktualisieren", String.class, String.class, String.class);
			checkField(testClass, "telefon", String.class);
			checkField(testClass, "personalNummer", int.class);
			checkConstructor(testClass, String.class, String.class, int.class, String.class);
		} catch (ClassNotFoundException e) {
			fail("Keine Klasse mit dem Namen Dozent");
		}
	}
	
	@Test
	public void test_instance_00() throws Exception {
		Class<?> testClass = UTestPerson.class.getClassLoader().loadClass("Dozent");
		String name = "Test";
		String vorname = "Dozent";
		int nr = 123;
		String telefon = "+49 (0) 123 456789";
		Object obj = createInstance(checkConstructor(testClass, String.class, String.class, int.class, String.class), name, vorname, nr, telefon);

		assertEquals("Attribut name müsste den Wert " + name + " haben", name, getValue(obj, "name", String.class));
		assertEquals("Attribut vorname müsste den Wert " + vorname + " haben", vorname, getValue(obj, "vorname", String.class));
		assertEquals("Attribut personalNummer müsste den Wert " + nr + " haben", nr, getValue(obj, "personalNummer", int.class).intValue());
		assertEquals("Attribut telefon müsste den Wert " + telefon + " haben", telefon, getValue(obj, "telefon", String.class));
	}
	
	@Test
	public void test_aktualisieren_00() throws Exception {
		Class<?> testClass = UTestPerson.class.getClassLoader().loadClass("Dozent");
		String name = "Test";
		String vorname = "Dozent";
		int nr = 123;
		String telefon = "+49 (0) 123 456789";
		Object obj = createInstance(checkConstructor(testClass, String.class, String.class, int.class, String.class), "", "", nr, "");
		
		assertEquals("Attribut name müsste keinen Wert haben", "", getValue(obj, "name", String.class));
		assertEquals("Attribut vorname müsste keinen Wert haben", "", getValue(obj, "vorname", String.class));
		assertEquals("Attribut personalNummer müsste den Wert " + nr + " haben", nr, getValue(obj, "personalNummer", int.class).intValue());
		assertEquals("Attribut telefon müsste keinen Wert haben", "", getValue(obj, "telefon", String.class));
		
		checkMethod(testClass, void.class, "aktualisieren", String.class, String.class, String.class).invoke(obj, name, vorname, telefon);
		
		assertEquals("Attribut name müsste den Wert " + name + " haben", name, getValue(obj, "name", String.class));
		assertEquals("Attribut vorname müsste den Wert " + vorname + " haben", vorname, getValue(obj, "vorname", String.class));
		assertEquals("Attribut personalNummer müsste den Wert " + nr + " haben", nr, getValue(obj, "personalNummer", int.class).intValue());
		assertEquals("Attribut telefon müsste den Wert " + telefon + " haben", telefon, getValue(obj, "telefon", String.class));
	}
	
	@Test
	public void test_generateId_00() throws Exception {
		Class<?> testClass = UTestPerson.class.getClassLoader().loadClass("Dozent");
		String name = "Test";
		String vorname = "Dozent";
		int nr = 123;
		String telefon = "+49 (0) 123 456789";
		Object obj = createInstance(checkConstructor(testClass, String.class, String.class, int.class, String.class), name, vorname, nr, telefon);
		
		assertEquals("toString-Ausgabe stimmt nicht", name + "-" + vorname + "-" + nr, checkMethod(testClass, String.class, "generateId").invoke(obj));
	}
	
	@Test
	public void test_toString_00() throws Exception {
		Class<?> testClass = UTestPerson.class.getClassLoader().loadClass("Dozent");
		String name = "Test";
		String vorname = "Dozent";
		int nr = 123;
		String telefon = "+49 (0) 123 456789";
		Object obj = createInstance(checkConstructor(testClass, String.class, String.class, int.class, String.class), name, vorname, nr, telefon);
		
		assertEquals("toString-Ausgabe stimmt nicht", "Dozent(id=" + name + "-" + vorname + "-" + nr + ", telefon=" + telefon + ")", checkMethod(testClass, String.class, "toString").invoke(obj));
	}
}