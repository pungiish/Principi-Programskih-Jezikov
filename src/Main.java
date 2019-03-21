import java.math.BigDecimal;
import java.util.Date;
import java.util.Vector;

public class Main {

   static String Prodajalka = "Janja";
    public static void main(String[] args) {
        Podjetje podjetje1 = new Podjetje("Henkel", "58665765", "626175200", true);
        Podjetje podjetje2 = new Podjetje("Henkel1", "111111765", "111115200", true);
        Podjetje podjetje3 = new Podjetje("Henkel2", "22222265", "2222200", true);

        Vector<Racun> seznamRacunov;
        Artikel kumarice = new Artikel(2, BigDecimal.valueOf(1),"kumarice", "123456789102", new Date(2019,3,16),0.22);
        Artikel mleko = new Artikel(1, BigDecimal.valueOf(2),"mleko", "888856789103", new Date(2019,3,16),0.22);
        Artikel kumarice2 = new Artikel(1, BigDecimal.valueOf(1),"kumarice", "123456789102", new Date(2019,3,16),0.22);
        Artikli seznamArtiklov = new Artikli();
        seznamArtiklov.Dodaj(kumarice);
        seznamArtiklov.Dodaj(mleko);
        seznamArtiklov.Dodaj(kumarice2);
        Racun racun = new Racun(Prodajalka, podjetje1);
        racun.DodajVse(seznamArtiklov);
        Racun racun2 = new Racun(Prodajalka, podjetje2);
        racun2.DodajVse(seznamArtiklov);
        Racun racun3 = new Racun(Prodajalka, podjetje3);
        racun3.DodajVse(seznamArtiklov);
        System.out.println(racun.toString());
        System.out.println(racun2.toString());
        System.out.println(racun3.toString());
        System.out.println("\n" + kumarice.search("123456789102"));
        System.out.println("\n" + racun.search("true"));

    }
}
