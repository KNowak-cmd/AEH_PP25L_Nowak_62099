package pl.pp;

public class mojaSiodmaAplikacja {
    public static void main(String[] args) {
        // Tworzymy obiekt klasy Person bez podawania danych
        Person person1 = new Person();
        person1.hiToAll(); // wyświetlenie danych (puste imię, nazwisko, wiek = 0)

        // Ręczne ustawienie danych dla obiektu person1
        person1.forename = "Mateusz";
        person1.surname = "Karmazyn";
        person1.age = 24;
        person1.address = "ul. Długa 5, Kraków";
        person1.birthYear = 2001;
        person1.hiToAll(); // teraz powinny być widoczne pełne dane

        // Utworzenie drugiego obiektu person2
        Person person2 = new Person("Dariusz", "Walendziak", 42);
        person2.address = "ul. Krótka 12, Warszawa"; // dodanie adresu
        person2.birthYear = 1983;                    // dodanie roku urodzenia
        person2.hiToAll(); // wyświetlenie danych osoby

        // Zwiększamy wiek person1 o 2 lata, a person2 o 5 lat
        person1.growOld(2);
        person2.growOld(5);

        // Zmniejszamy wiek: person1 o 1 rok, person2 o 2 lata
        person1.beYounger();
        person2.beYounger();
        person2.beYounger();

        // Wyświetlenie aktualnych danych po zmianach wieku
        person1.hiToAll();
        person2.hiToAll();

        // Przykład użycia getterów i setterów do odczytu i zmiany imienia
        System.out.println(person1.getName());   // odczytaj imię
        person1.setName("Lolo");                // ustaw nowe imię
        System.out.println(person1.getName());   // ponowny odczyt po zmianie
        person1.hiToAll();                       // wyświetlenie pełnych danych
    }
}
