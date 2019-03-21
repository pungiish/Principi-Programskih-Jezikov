import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

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
		if (this.prodajalka.compareTo((s)) == 0 ||
		this.datum.toString().compareTo(s) == 0 ||
		this.podjetje.getIme().compareTo(s) == 0 ||
		String.valueOf(this.id).compareTo(s) == 0 ||
		String.valueOf(podjetje.isJeZavezanec()).compareTo(s) == 0)
			return true;
		for (Artikel a : artikli.getArtikels()) {
			if (a.getEAN().compareTo(s) == 0 ||
			a.getIme().compareTo(s) == 0)
				return true;
		}
		return false;
	}
}
