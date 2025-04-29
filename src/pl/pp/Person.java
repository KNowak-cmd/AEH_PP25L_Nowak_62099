package pl.pp;

// Klasa Person reprezentuje osobę z podstawowymi danymi oraz metodami manipulującymi jej wiekiem
public class Person {
    // Pola (atrybuty) obiektu - przechowują dane o osobie
    public String forename;    // imię osoby
    public String surname;     // nazwisko osoby
    public int age;            // wiek osoby
    public String address;     // adres zamieszkania
    public int birthYear;      // rok urodzenia

    // Konstruktor domyślny, który tworzy obiekt bez nadawania mu konkretnych danych
    public Person() {}

    // Konstruktor, który pozwala stworzyć osobę i od razu ustawić imię, nazwisko i wiek
    public Person(String initForename, String initSurname, int initAge) {
        forename = initForename;
        surname = initSurname;
        age = initAge;
    }

    // Metoda wyświetlająca wszystkie dostępne informacje o osobie
    public void hiToAll() {
        System.out.println("Nazywam się " + forename + " " + surname +
                ". Mam " + age + " lat." +
                (address != null ? " Mój adres to: " + address + "." : "") +         // sprawdza czy adres został ustawiony
                (birthYear > 0 ? " Urodziłem się w " + birthYear + "." : ""));      // sprawdza czy rok urodzenia został ustawiony
    }

    // Metoda zwiększająca wiek osoby o określoną liczbę lat (przekazaną jako argument)
    public int growOld(int years) {
        age += years;
        return age;
    }

    // Metoda zmniejszająca wiek osoby o 1, o ile wiek jest większy niż 0
    public int beYounger() {
        if (age > 0) {
            age--;
        }
        return age;
    }

    // Metoda zwracająca imię osoby (getter)
    public String getName() {
        return forename;
    }

    // Metoda ustawiająca imię osoby (setter)
    public void setName(String nameToSet) {
        forename = nameToSet;
    }
}
