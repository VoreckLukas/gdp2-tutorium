import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class UTestStudent extends Helper {
	@Test
	public void test_structure_00() {
		try {
			Class<?> testClass = UTestPerson.class.getClassLoader().loadClass("Student");
			checkMethod(testClass, String.class, "getMatrikelnummer");
			checkMethod(testClass, String.class, "generateId");
			checkMethod(testClass, String.class, "toString");
			checkMethod(testClass, void.class, "aktualisieren", String.class, String.class, String.class);
			checkField(testClass, "matrikelnummer", String.class);
			checkConstructor(testClass, String.class, String.class, String.class);
		} catch (ClassNotFoundException e) {
			fail("Keine Klasse mit dem Namen Student");
		}
	}
	
	@Test
	public void test_instance_00() throws Exception {
		Class<?> testClass = UTestPerson.class.getClassLoader().loadClass("Student");
		String name = "Test";
		String vorname = "Student";
		String nr = "xy123";
		Object obj = createInstance(checkConstructor(testClass, String.class, String.class, String.class), name, vorname, nr);
		
		assertEquals("Attribut name müsste den Wert " + name + " haben", name, getValue(obj, "name", String.class));
		assertEquals("Attribut vorname müsste den Wert " + vorname + " haben", vorname, getValue(obj, "vorname", String.class));
		assertEquals("Attribut matrikelnummer müsste den Wert " + nr + " haben", nr, getValue(obj, "matrikelnummer", String.class));
	}
	
	@Test
	public void test_aktualisieren_00() throws Exception {
		Class<?> testClass = UTestPerson.class.getClassLoader().loadClass("Student");
		String name = "Test";
		String vorname = "Student";
		String nr = "xy123";
		Object obj = createInstance(checkConstructor(testClass, String.class, String.class, String.class), "", "", "");
		
		assertEquals("Attribut name müsste keinen Wert haben", "", getValue(obj, "name", String.class));
		assertEquals("Attribut vorname müsste keinen Wert haben", "", getValue(obj, "vorname", String.class));
		assertEquals("Attribut matrikelnummer müsste keinen Wert haben", "", getValue(obj, "matrikelnummer", String.class));
		
		checkMethod(testClass, void.class, "aktualisieren", String.class, String.class, String.class).invoke(obj, name, vorname, nr);
		
		assertEquals("Attribut name müsste den Wert " + name + " haben", name, getValue(obj, "name", String.class));
		assertEquals("Attribut vorname müsste den Wert " + vorname + " haben", vorname, getValue(obj, "vorname", String.class));
		assertEquals("Attribut matrikelnummer müsste den Wert " + nr + " haben", nr, getValue(obj, "matrikelnummer", String.class));
	}
	
	@Test
	public void test_generateId_00() throws Exception {
		Class<?> testClass = UTestPerson.class.getClassLoader().loadClass("Student");
		String name = "Test";
		String vorname = "Student";
		String nr = "xy123";
		Object obj = createInstance(checkConstructor(testClass, String.class, String.class, String.class), name, vorname, nr);
		
		assertEquals(name + "-" + vorname + "-" + nr, checkMethod(testClass, String.class, "generateId").invoke(obj));
	}
	
	@Test
	public void test_toString_00() throws Exception {
		Class<?> testClass = UTestPerson.class.getClassLoader().loadClass("Student");
		String name = "Test";
		String vorname = "Student";
		String nr = "xy123";
		Object obj = createInstance(checkConstructor(testClass, String.class, String.class, String.class), name, vorname, nr);
		
		assertEquals("Student(id=" + name + "-" + vorname + "-" + nr  + ")", checkMethod(testClass, String.class, "toString").invoke(obj));
	}

}