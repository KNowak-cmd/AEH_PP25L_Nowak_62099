public class mojaDziewiataAplikacja {
    public static void main(String[] args) {
        // Tworzymy magazyn o numerze 1, pojemności 5000, właściciel Jan Kowalski
        Magazyn magazyn = new Magazyn(
                1,                  // numer magazynu
                5000,               // początkowa dostępna przestrzeń
                "Jan Kowalski",     // nazwa właściciela
                "jan.kowalski@magazyn.pl",
                "+48 600 700 800"
        );

        // Przykładowe operacje na magazynie
        magazyn.dodajTowar(3000);           // Dodajemy 3000
        magazyn.usunTowar(1000);            // Usuwamy 1000
        magazyn.dodajTowar(2500);           // Dodajemy 2500 (przekroczy pojemność)
        magazyn.sprawdzZajetosc();          // Wyświetlamy stan magazynu
        magazyn.aktualizujKontakt(
                "owner@magazyn.pl",
                "+48 123 456 789"
        );                                   // Aktualizujemy dane kontaktowe
        magazyn.dodajTowar(1000);           // Ponowna próba dodania 1000
    }
}