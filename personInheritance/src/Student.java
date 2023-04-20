
public class Student extends Person {
	private String matrikelnummer;
	
	public Student(String name, String vorname, String matrikelnummer) {
		super(name, vorname);
		this.matrikelnummer = matrikelnummer;
	}
	
	public String getMatrikelnummer() {
		return matrikelnummer;
	}
	
	@Override
	public String generateId() {
		return getName() + "-" + getVorname() + "-" + getMatrikelnummer();
	}
	
	public void aktualisieren(String name, String vorname, String matrikelNummer) {
		aktualisieren(name, vorname);
		this.matrikelnummer = matrikelNummer;
	}

	@Override
	public String toString() {
		return "Student(" + super.toString() + ")";
	}
}
