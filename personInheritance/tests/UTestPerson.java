import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;

import org.junit.Test;

public class UTestPerson extends Helper {
	@Test
	public void test_structure_00() {
		try {
			Class<?> testClass = UTestPerson.class.getClassLoader().loadClass("Person");
			assertTrue("Person sollte abstrakt sein", Modifier.isAbstract(testClass.getModifiers()));
			checkMethod(testClass, String.class, "getName");
			checkMethod(testClass, String.class, "getVorname");
			checkMethod(testClass, String.class, "toString");
			checkMethod(true, testClass, String.class, "generateId");
			checkMethod(testClass, void.class, "aktualisieren", String.class, String.class);
			checkField(testClass, "name", String.class);
			checkField(testClass, "vorname", String.class);
			checkConstructor(testClass, String.class, String.class);
		} catch (ClassNotFoundException e) {
			fail("Keine Klasse mit dem Namen Person");
		}
	}
}