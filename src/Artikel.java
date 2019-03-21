import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Artikel implements Searchable {
    private static final AtomicInteger inc = new AtomicInteger();
    private int id;
    private String  EAN;
    private String ime;
    private BigDecimal cena;
    private double kolicina;
    private Date rok;
    private double davcnaStopnja;

    public Artikel(double kolicina, BigDecimal cena, String ime, String EAN, Date rok, double davcnaStopnja) {
        this.id = inc.getAndIncrement();
        this.EAN = EAN ;
        this.ime = ime;
        this.cena = cena.multiply(BigDecimal.valueOf(kolicina).multiply(BigDecimal.valueOf(davcnaStopnja)).add(cena));
        //this.cena = cena.setScale(2,M);
        this.kolicina = kolicina;
        this.rok = rok;
        this.davcnaStopnja = davcnaStopnja;
    }

    public int getId(){
        return this.id;
    }

    public double getDavcnaStopnja() {
        return davcnaStopnja;
    }

    public void setDavcnaStopnja(float davcnaStopnja) {
        this.davcnaStopnja = davcnaStopnja;
    }

    public Date getRok() {
        return rok;
    }

    public void setRok(Date rok) {
        this.rok = rok;
    }

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String EAN) {
        try {
            if (EAN.length() < 13 || EAN.length() > 13) {
                throw new ArrayIndexOutOfBoundsException();
            }
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("EAN koda je lahko dolga samo 13 znakov!\n" + e.getStackTrace() + '\n' + e);
        }
        this.EAN = EAN;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public String getIme() {
        return ime;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", EAN: " + EAN + ", ime: " + ime + ", cena: " + cena + ", kolicina: " + kolicina + " rok uporabnosti: " + rok.toString() + " davcna stopnja: " + davcnaStopnja;
    }

    @Override
    public boolean search(String s) {
        return(this.ime.compareTo(s) == 0 ||
                String.valueOf(this.cena).compareTo(s) == 0 ||
                String.valueOf(this.kolicina).compareTo(s) == 0 ||
                this.EAN.compareTo(s) == 0 ||
                this.rok.toString().compareTo(s) == 0);
    }
}
