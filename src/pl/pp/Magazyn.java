public class Magazyn {
    private int numerMagazynu;
    private int dostepnaPrzestrzen;
    private int zajetaPrzestrzen;
    private String nazwaWlasciciela;
    private String email;
    private String telefon;

    // Konstruktor
    public Magazyn(int numerMagazynu, int poczatkowaPrzestrzen, String nazwaWlasciciela, String email, String telefon) {
        this.numerMagazynu = numerMagazynu;
        this.dostepnaPrzestrzen = poczatkowaPrzestrzen;
        this.zajetaPrzestrzen = 0;
        this.nazwaWlasciciela = nazwaWlasciciela;
        this.email = email;
        this.telefon = telefon;
    }

    // Gettery i settery
    public int getNumerMagazynu() {
        return numerMagazynu;
    }

    public void setNumerMagazynu(int numerMagazynu) {
        this.numerMagazynu = numerMagazynu;
    }

    public int getDostepnaPrzestrzen() {
        return dostepnaPrzestrzen;
    }

    public void setDostepnaPrzestrzen(int dostepnaPrzestrzen) {
        this.dostepnaPrzestrzen = dostepnaPrzestrzen;
    }

    public String getNazwaWlasciciela() {
        return nazwaWlasciciela;
    }

    public void setNazwaWlasciciela(String nazwaWlasciciela) {
        this.nazwaWlasciciela = nazwaWlasciciela;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    // Metody operacyjne
    public void dodajTowar(int ilosc) {
        if (ilosc <= dostepnaPrzestrzen) {
            zajetaPrzestrzen += ilosc;
            dostepnaPrzestrzen -= ilosc;
            System.out.println("Dodano " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
        } else {
            System.out.println("Za mało miejsca w magazynie. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
        }
    }

    public void usunTowar(int ilosc) {
        if (ilosc <= zajetaPrzestrzen) {
            zajetaPrzestrzen -= ilosc;
            dostepnaPrzestrzen += ilosc;
            System.out.println("Usunięto " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
        } else {
            System.out.println("Nie można usunąć więcej towaru niż jest w magazynie. Zajęta przestrzeń: " + zajetaPrzestrzen + " jednostek.");
        }
    }

    public void sprawdzZajetosc() {
        System.out.println("Zajęta przestrzeń magazynowa: " + zajetaPrzestrzen + " jednostek.");
        System.out.println("Dostępna przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
    }

    public void aktualizujKontakt(String nowyEmail, String nowyTelefon) {
        this.email = nowyEmail;
        this.telefon = nowyTelefon;
        System.out.println("Zaktualizowano dane kontaktowe właściciela.");
        System.out.println("Nowy email: " + nowyEmail);
        System.out.println("Nowy numer telefonu: " + nowyTelefon);
    }

    // Przykładowe użycie
    public static void main(String[] args) {
        Magazyn magazyn = new Magazyn(1, 5000, "Jan Kowalski", "jan.kowalski@magazyn.pl", "+48 600 700 800");
        magazyn.dodajTowar(3000);
        magazyn.usunTowar(1000);
        magazyn.dodajTowar(2500);
        magazyn.sprawdzZajetosc();
        magazyn.aktualizujKontakt("owner@magazyn.pl", "+48 123 456 789");
        magazyn.dodajTowar(1000);
    }
}