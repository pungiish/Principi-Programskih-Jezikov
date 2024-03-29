import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Vector;
import si.um.feri.database.DBHelper;


public class Main {
	static String Prodajalka = "Janja";
	public static void main(String[] args) throws IOException {
		Podjetje podjetje1 = new Podjetje("Henkel", "58665765", "626175200", true);
		Podjetje podjetje2 = new Podjetje("Henkel1", "111111765", "111115200", true);
		Podjetje podjetje3 = new Podjetje("Henkel2", "22222265", "2222200", true);

		Vector<Racun> seznamRacunov;
		Artikel kumarice = new Artikel(2, BigDecimal.valueOf(1),"kumarice", "2011000001000", new Date(2019,3,16),0.22);
		Artikel mleko = new Artikel(1, BigDecimal.valueOf(2),"mleko", "2021001012000", new Date(2019,3,16),0.22);
		Artikel kumarice2 = new Artikel(1, BigDecimal.valueOf(1),"kumarice", "2001000072000", new Date(2019,3,16),0.22);
		Artikli seznamArtiklov = new Artikli();
		seznamArtiklov.Dodaj(kumarice);
		seznamArtiklov.Dodaj(mleko);
		seznamArtiklov.Dodaj(kumarice2);
		Racun racun = new Racun(Prodajalka);
		racun.DodajVse(seznamArtiklov);
		//Racun racun2 = new Racun(Prodajalka, podjetje2);
		//racun2.DodajVse(seznamArtiklov);
		//Racun racun3 = new Racun(Prodajalka, podjetje3);
		//racun3.DodajVse(seznamArtiklov);
		//System.out.println(racun2.toString());
		//System.out.println(racun3.toString());
		//System.out.println("\n" + kumarice.search("123456789102"));
		//System.out.println("\n" + racun.search("true"));

		//System.out.println(Artikel.checkDigit("98056678755655"));
		//HelperClass.writeToFile("Test4", seznamArtiklov.toJson());
		//String test1 = HelperClass.readFromFile("Test4");
		//Artikli nov = new Artikli();
		//System.out.println(test1);
		//nov.fromJson(test1);
		//System.out.println(nov.toString());
		kumarice.razberiEan();
		mleko.razberiEan();
		kumarice2.razberiEan();
		System.out.println(racun.toString());
		kumarice.setKolicina(502);
		kumarice.razberiEan();
		DBHelper conn = new DBHelper();
		conn.Povezi("SELECT IME FROM ARTICLE");
	}
}
