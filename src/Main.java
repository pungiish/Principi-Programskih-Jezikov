import java.math.BigDecimal;
import java.util.Date;
import java.util.Vector;

public class Main {

   static String Prodajalka = "Janja";
    public static void main(String[] args) {
        Vector<Racun> seznamRacunov;
        Artikel kumarice = new Artikel(2, BigDecimal.valueOf(1),"kumarice", "123456789102", new Date(2019,3,16),0.22);
        Artikel mleko = new Artikel(1, BigDecimal.valueOf(2),"mleko", "123456789103", new Date(2019,3,16),0.22);
        Artikel kumarice2 = new Artikel(1, BigDecimal.valueOf(1),"kumarice", "123456789102", new Date(2019,3,16),0.22);

        Artikli seznamArtiklov = new Artikli();
        seznamArtiklov.Dodaj(kumarice);
        seznamArtiklov.Dodaj(mleko);
        seznamArtiklov.Dodaj(kumarice2);
        Racun racun = new Racun(Prodajalka);
        racun.DodajVse(seznamArtiklov);
        System.out.println(racun.toString());
        racun.OdstraniEno(kumarice);
        System.out.println(racun.toString());
    }
}
