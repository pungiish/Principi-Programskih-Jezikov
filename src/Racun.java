import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Racun {
	private static final AtomicInteger inc = new AtomicInteger();
	private int id;
	private String prodajalka;
	private LocalDateTime datum;
	private Artikli artikli;

	public Racun(String prodajalka) {
		this.id = inc.getAndIncrement();
		this.prodajalka = prodajalka;
		this.datum = LocalDateTime.now();
		this.artikli = new Artikli();
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
			return racun = artikli.toString() + "Skupna cena: " + this.artikli.SkupnaCena() + '\n' + this.prodajalka + '\n' + this.datum;
		}
}
