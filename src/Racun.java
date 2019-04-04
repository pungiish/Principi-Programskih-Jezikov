import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
//TODO Racun izpise izdajatelja (podjetje)
// - racun izpise ceno brez ddvja in z ddvjem

public class Racun implements Searchable {
	private static final AtomicInteger inc = new AtomicInteger();
	private int id;
	private String prodajalka;
	private LocalDateTime datum;
	private Artikli artikli;
	private Podjetje podjetje;

	public Racun(String prodajalka) {
		this.id = inc.getAndIncrement();
		this.prodajalka = prodajalka;
		this.datum = LocalDateTime.now();
		this.artikli = new Artikli();
	}
	public Racun(String prodajalka, Podjetje podjetje){
		this.id = inc.getAndIncrement();
		this.prodajalka = prodajalka;
		this.datum = LocalDateTime.now();
		this.artikli = new Artikli();
		this.podjetje = new Podjetje(podjetje.getIme(), podjetje.getDavcna(), podjetje.getMaticna(), podjetje.isJeZavezanec());
	}
	public void DodajEno(Artikel artikel) {
		this.artikli.Dodaj(artikel);
	}
	public void DodajVse(Artikli artikli){
		this.artikli = artikli;
	}
	public String OdstraniEno(Artikel artikel){
		return this.artikli.Odstrani(artikel);
	}
	public void OdstraniVse() {
		this.artikli.OdstraniVse();
	}

	@Override
	public String toString() {
		String racun = "";
		racun = artikli.toString() + "Skupna cena: " + this.artikli.SkupnaCena() + '\n' + this.prodajalka + '\n' + this.datum;
		if( podjetje != null){
			return racun += podjetje.toString();
		}

		return racun;
		}

	@Override
	public boolean search(String s) {
		if (this.prodajalka.contains((s))||
		this.datum.toString().contains(s)||
		this.podjetje.getIme().contains(s)||
		String.valueOf(this.id).contains(s)||
		String.valueOf(podjetje.isJeZavezanec()).contains(s))
			return true;
		for (Artikel a : artikli.getArtikels()) {
			if (a.getEAN().contains(s)||
			a.getIme().contains(s))
				return true;
		}
		return false;
	}
}
