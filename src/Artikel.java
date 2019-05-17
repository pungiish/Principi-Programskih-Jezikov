import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Artikel implements Searchable {
    static final int sadje = 200;
    static final int zelenjava = 201;
    static final int mlecniIzdelki = 202;
    static final int kumarice = 1000;
    static final int mleko = 1001;

    private Map<Integer, String> oddelki = new HashMap<>();
    private Map<Integer, String> idji = new HashMap<>();
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
        oddelki.put(sadje,"sadje");
        oddelki.put(zelenjava,"zelenjava");
        oddelki.put(mlecniIzdelki,"mlecni izdelki");
        idji.put(kumarice, "kumarice");
        idji.put(mleko, "mleko");
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
        /*String cena1 = String.valueOf(cena);
        String prviDel = EAN.substring(0,7);
        String check = EAN.substring(12);
        int cena2 = cena.intValue();
        if (cena2 <10)
        {
            cena1 = "0000" + cena1;
        }
        else if (cena2 <100)
        {
            cena1 = "000" + cena1;
        }
        else if (cena2 <1000)
        {
            cena1 = "00" + cena1;
        }
        else if (cena2 <10000)
        {
            cena1 = "0" + cena1;
        }
        for(int i = 0; i<10; i++)
        {
            if (checkDigit(String.valueOf(i)))
            {
                check = String.valueOf(i);
                break;
            }
        }
        StringBuilder novEan = new StringBuilder(prviDel+cena1+check);
        this.EAN = novEan.toString();
        System.out.println(this.EAN);*/
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
        //String EAN = this.getEAN();
        String prviDel = EAN.substring(0,7);
        //System.out.println(prviDel);
        String check = EAN.substring(11);
        //System.out.println(check);
        String kolicina1 = String.valueOf((int)kolicina);
        System.out.println(kolicina1);
        if ((int)kolicina < 10)
        {
            kolicina1 = "0000" + kolicina1;
            System.out.println(kolicina1);
        }
        else if ((int)kolicina < 100)
        {
            kolicina1 = "000" + kolicina1;
            System.out.println(kolicina1);

        }
        else if ((int)kolicina <1000)
        {
            kolicina1 = "00" + kolicina1;
            System.out.println(kolicina1);

        }
        else if ((int)kolicina <10000)
        {
            kolicina1 = "0" + kolicina1;
            System.out.println(kolicina1);
        }
        for(int i = 0; i<10; i++)
        {
            if (checkDigit(String.valueOf(i)))
            {
                check = String.valueOf(i);
                break;
            }
        }
        StringBuilder novEan = new StringBuilder(prviDel+kolicina1+check);
        this.EAN = novEan.toString();
        System.out.println(this.EAN);
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

    public static <K, V> String getKey(Map<K, V> map, K key) {
        for (K key1 : map.keySet()) {
            System.out.println((key));
            if(map.containsKey(key))
            {
                return String.valueOf(map.get(key));
            }
        }
        return String.valueOf(key);
    }
    public void razberiEan()
    {
        String oddelek = this.EAN.substring(0,3);
        oddelek = getKey(oddelki,Integer.valueOf(oddelek));
        String id = this.EAN.substring(3,7);
        id = getKey(idji,Integer.valueOf(id));
        String kolcen = this.EAN.substring(7,12);
        String check = this.EAN.substring(12);
        System.out.println("Oddelek: " + oddelek + " Id: " + id + " kolicina: " + kolcen + " Check: " + check);
    }

    @Override
    public String toString() {
        return "Id: " + id + ", EAN: " + EAN + ", ime: " + ime + ", cena: " + cena + ", kolicina: " + kolicina + " teza: " + this.getEAN().substring(7,12).replaceFirst("^0+(?!$)", "") +
        " rok uporabnosti: " + rok.toString() + " davcna stopnja: " + davcnaStopnja;
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
