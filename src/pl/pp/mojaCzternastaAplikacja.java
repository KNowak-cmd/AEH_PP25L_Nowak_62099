public class mojaCzternastaAplikacja {

    public static void main(String[] args) {

        // Silniki
        TypPaliwa diesel  = new Diesel();
        TypPaliwa benzyna = new Benzyna();
        TypPaliwa prund   = new Elektryk();

        // Przykładowe pojazdy
        Pojazd golf = new Osobowe("PO 12345", "VWXYZ123456789", "czerwony",
                55_000, 6.0, 40, 150_000, benzyna, 5);

        Pojazd daf  = new Ciezarowka("PY 98765", "DAF123X456789", "biały",
                220_000, 25.0, 300, 500_000, diesel, 18_000);

        Pojazd harley = new Motocykl("WX 34567", "HD987654321", "czarny",
                75_000, 4.5, 15, 23_000, benzyna, false);

        Pojazd koparka = new SprzetBudowlany("KOP 11223", "CAT123KOP5678", "żółty",
                480_000, 18.0, 200, 8_000, diesel, 3_500);

        // Test działania
        System.out.println(golf);
        golf.prowadz(120);
        golf.zatankuj(20);
        System.out.println(golf);

        System.out.println("\n" + daf);
        daf.prowadz(250);
        System.out.println(daf);

        System.out.println("\n" + harley);
        harley.prowadz(60);
        System.out.println(harley);

        System.out.println("\n" + koparka);
        ((SprzetBudowlany) koparka).dodajGodziny(5);
        koparka.prowadz(10);  // sprzęt też może się przemieszczać
        System.out.println(koparka);
    }
}

/* ==== INTERFEJS I IMPLEMENTACJE SILNIKÓW ==== */
interface TypPaliwa {
    String getTypPaliwa();
}

class Diesel implements TypPaliwa {
    @Override public String getTypPaliwa() { return "diesel"; }
}

class Benzyna implements TypPaliwa {
    @Override public String getTypPaliwa() { return "benzyna"; }
}

class Elektryk implements TypPaliwa {
    @Override public String getTypPaliwa() { return "elektryczny"; }
}

/* ==== KLASA ABSTRAKCYJNA POJAZD ==== */
abstract class Pojazd {
    protected String nrRejestracyjny;
    protected String numerVin;
    protected String kolor;
    protected double cena;         // PLN
    protected double spalanie;     // l/100 km lub kWh/100 km
    protected double poziomPaliwa; // litry / kWh
    protected double przebieg;     // km

    protected TypPaliwa typPaliwa;

    public Pojazd(String nrRejestracyjny, String numerVin, String kolor,
                  double cena, double spalanie, double poziomPaliwa,
                  double przebieg, TypPaliwa typPaliwa) {

        this.nrRejestracyjny = nrRejestracyjny;
        this.numerVin        = numerVin;
        this.kolor           = kolor;
        this.cena            = cena;
        this.spalanie        = spalanie;
        this.poziomPaliwa    = poziomPaliwa;
        this.przebieg        = przebieg;
        this.typPaliwa       = typPaliwa;
    }

    /** Symuluje przejazd o podaną liczbę kilometrów */
    public void prowadz(double km) {
        double zuzyte = (spalanie / 100.0) * km;
        if (zuzyte > poziomPaliwa) {
            System.out.println("Za mało paliwa na tę trasę!");
            return;
        }
        poziomPaliwa -= zuzyte;
        przebieg     += km;
        System.out.printf("Przejechano %.1f km; zużyto %.2f jednostek paliwa.%n", km, zuzyte);
    }

    /** Tankowanie o określoną ilość paliwa */
    public void zatankuj(double ilosc) {
        poziomPaliwa += ilosc;
        System.out.printf("Zatankowano %.2f jednostek. Obecny poziom: %.2f%n", ilosc, poziomPaliwa);
    }

    public String getTypPaliwa() { return typPaliwa.getTypPaliwa(); }

    @Override
    public String toString() {
        return String.format("%s [%s] VIN:%s | przebieg: %.0f km | paliwo: %s",
                getClass().getSimpleName(), nrRejestracyjny, numerVin, przebieg, getTypPaliwa());
    }
}

/* ==== PODKLASY POJAZDÓW ==== */
class Osobowe extends Pojazd {
    private int liczbaDrzwi;

    public Osobowe(String nrRejestracyjny, String numerVin, String kolor,
                   double cena, double spalanie, double poziomPaliwa,
                   double przebieg, TypPaliwa typPaliwa, int liczbaDrzwi) {

        super(nrRejestracyjny, numerVin, kolor, cena, spalanie,
                poziomPaliwa, przebieg, typPaliwa);
        this.liczbaDrzwi = liczbaDrzwi;
    }

    @Override public String toString() {
        return super.toString() + " | drzwi: " + liczbaDrzwi;
    }
}

class Ciezarowka extends Pojazd {
    private double ladownosc; // kg

    public Ciezarowka(String nrRejestracyjny, String numerVin, String kolor,
                      double cena, double spalanie, double poziomPaliwa,
                      double przebieg, TypPaliwa typPaliwa, double ladownosc) {

        super(nrRejestracyjny, numerVin, kolor, cena, spalanie,
                poziomPaliwa, przebieg, typPaliwa);
        this.ladownosc = ladownosc;
    }

    @Override public String toString() {
        return super.toString() + String.format(" | ładowność: %.0f kg", ladownosc);
    }
}

class Motocykl extends Pojazd {
    private boolean posiadaDostawke;

    public Motocykl(String nrRejestracyjny, String numerVin, String kolor,
                    double cena, double spalanie, double poziomPaliwa,
                    double przebieg, TypPaliwa typPaliwa, boolean posiadaDostawke) {

        super(nrRejestracyjny, numerVin, kolor, cena, spalanie,
                poziomPaliwa, przebieg, typPaliwa);
        this.posiadaDostawke = posiadaDostawke;
    }

    @Override public String toString() {
        return super.toString() + " | dostawka: " + (posiadaDostawke ? "tak" : "nie");
    }
}

class SprzetBudowlany extends Pojazd {
    private double przepracowaneGodziny;

    public SprzetBudowlany(String nrRejestracyjny, String numerVin, String kolor,
                           double cena, double spalanie, double poziomPaliwa,
                           double przebieg, TypPaliwa typPaliwa,
                           double przepracowaneGodziny) {

        super(nrRejestracyjny, numerVin, kolor, cena, spalanie,
                poziomPaliwa, przebieg, typPaliwa);
        this.przepracowaneGodziny = przepracowaneGodziny;
    }

    public void dodajGodziny(double godziny) {
        przepracowaneGodziny += godziny;
    }

    @Override public String toString() {
        return super.toString() +
                String.format(" | godziny pracy: %.1f h", przepracowaneGodziny);
    }
}