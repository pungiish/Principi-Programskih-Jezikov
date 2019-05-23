public class Podjetje implements Searchable{
	private String ime;
	private String davcna;
	private String maticna;
	private String naslov;
	private boolean jeZavezanec;

	public Podjetje(String ime, String davcna, String maticna, boolean jeZavezanec) {
		this.ime = ime;
		this.davcna = davcna;
		this.maticna = maticna;
		this.jeZavezanec = jeZavezanec;
	}


	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getDavcna() {
		return davcna;
	}

	public void setDavcna(String davcna) {
		this.davcna = davcna;
	}

	public String getMaticna() {
		return maticna;
	}

	public void setMaticna(String maticna) {
		this.maticna = maticna;
	}

	public boolean isJeZavezanec() {
		return jeZavezanec;
	}

	public void setJeZavezanec(boolean jeZavezanec) {
		this.jeZavezanec = jeZavezanec;
	}

	@Override
	public  String toString(){
		String podjetje = "";
		return podjetje = "\n Ime Podjetja: " + this.ime + " Davcna: " + this.davcna + " Maticna: " + this.maticna
				+ " je Zavezanec: " + this.jeZavezanec;
	}

	@Override
	public boolean search(String s) {
		return (this.ime.contains(s) ||
				String.valueOf(this.jeZavezanec).contains(s) ||
				this.davcna.contains(s) ||
				this.maticna.contains(s)
				);
	}
}
