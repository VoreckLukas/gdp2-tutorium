
public class Dozent extends Person {
	private String telefon;
	private int personalNummer;
	

	public Dozent(String name, String vorname, int personalNummer, String telefon) {
		super(name, vorname);
		this.telefon = telefon;
		this.personalNummer = personalNummer;
	}
	
	public int getPersonalNummer() {
		return personalNummer;
	}
	 
	public String getTelefon() {
		return telefon;
	}
	
	@Override
	public String generateId() {
		return getName() + "-" + getVorname() + "-" + getPersonalNummer();
	}

	public void aktualisieren(String name, String vorname, String telefon) {
		aktualisieren(name, vorname);
		this.telefon = telefon;
	}
	
	@Override
	public String toString() {
		return "Dozent(" + super.toString() + ", telefon=" + getTelefon() + ")";
	}
}
