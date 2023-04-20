
public abstract class Person {
	private String name;
	private String vorname;
	
	public Person(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public abstract String generateId();
	
	public void aktualisieren(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
	}
	
	@Override
	public String toString() {
		return "id=" + generateId();
	}
}
