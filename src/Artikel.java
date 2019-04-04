import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
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

  /*  public static int[] genDigit(String checkDigit) {
        int[] check = new int[] {3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3};
        int sum = 0;
        int[] digits = new int[checkDigit.length()];
        for (int i = 0; i < checkDigit.length(); i++)
        {
            digits[i] = checkDigit.charAt(i) - '0';
        }
        int size = digits.length-1;
        for (int i = check.length-1; i>(check.length-1) - digits.length; i--){
            digits[size] = digits[size]*check[i];
            size--;

        }
        for (int dig :
                digits) {
            System.out.println(dig);
            sum+=dig;
        }
        System.out.println(sum);
        int higherTen = (int) (Math.ceil(sum/10.0) * 10);
        System.out.println(higherTen);
        digits[digits.length] = higherTen - sum;
        return digits;
    }
*/
    public static boolean checkDigit(String checkDigit) {
        int[] check = new int[] {3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3};
        int sum = 0;
        int[] digits = new int[checkDigit.length()];
        for (int i = 0; i < checkDigit.length(); i++)
        {
            digits[i] = Character.getNumericValue(checkDigit.charAt(i));
        }
        int lastDigit = digits[digits.length-1];
        digits = Arrays.copyOf(digits,digits.length-1);
        int size = digits.length-1;
        for (int i = check.length-1; i>(check.length-1) - digits.length; i--){
            digits[size] = digits[size]*check[i];
            size--;
        }
        for (int dig :
                digits) {
            //System.out.println(dig);
            sum+=dig;
        }
        //System.out.println(sum);
        int higherTen = (int) (Math.ceil(sum/10.0) * 10);
        //System.out.println(higherTen);
        return (lastDigit == higherTen-sum);
    }


    @Override
    public String toString() {
        return "Id: " + id + ", EAN: " + EAN + ", ime: " + ime + ", cena: " + cena + ", kolicina: " + kolicina + " rok uporabnosti: " + rok.toString() + " davcna stopnja: " + davcnaStopnja;
    }

    @Override
    public boolean search(String s) {
        return(this.ime.contains(s) ||
                String.valueOf(this.cena).contains(s) ||
                String.valueOf(this.kolicina).contains(s) ||
                this.EAN.contains(s) ||
                this.rok.toString().contains(s));
    }
}
