import java.math.BigDecimal;
import java.util.Vector;

public class Artikli implements JsonSupport {
	private Vector<Artikel> artikels;

	public Vector<Artikel> getArtikels() {
		return artikels;
	}

	public void setArtikels(Vector<Artikel> artikels) {
		this.artikels = artikels;
	}

	private BigDecimal cena;

	public Artikli() {
		this.artikels = new Vector<Artikel>();
		this.cena = new BigDecimal("0");
	}

	public void Dodaj(Artikel artikel){
		//compareTo za stringe
		for (Artikel a: artikels) {
			if (a.getEAN().substring(0,4).compareTo(artikel.getEAN().substring(0,4)) == 0) {
				a.setCena(a.getCena().add(artikel.getCena()));
				a.setKolicina(a.getKolicina() + artikel.getKolicina());
				return;
			}
		}
		artikels.add(artikel);
	}

	public String Odstrani(Artikel artikel){
		this.artikels.remove(artikel);
		return "Odstranjen artikel: " + artikel;
	}

	public void OdstraniVse() {
		this.artikels.clear();
	}

	public void EditKolicina(Artikel artikel, float kol){
		if(this.artikels.contains(artikel)) {
			int idx = this.artikels.indexOf(artikel);
			if(kol == 0)
				this.Odstrani(artikel);
			else
				this.artikels.elementAt(idx).setKolicina(kol);
		}
		else {
			System.out.println("Tega artikla ni na seznamu!");
			return;
		}
	}

	public BigDecimal SkupnaCena() {
		BigDecimal cena = new BigDecimal(0);
		for ( Artikel a: artikels) {
			cena = cena.add(a.getCena());
		}
		return cena;
	}

	@Override
	public String toString() {
		String artikli = "";
		for (Artikel a: artikels) {
			artikli += "Kolicina: " + a.getKolicina() + " Izdelek: " + a.getIme() + " Cena: " + a.getCena() + '\n';
		}
		return artikli;
	}
}
