package pl.pp;

public class mojaOsmaAplikacja {
    public static void main(String[] args) {
        // Tworzenie konta bankowego z saldem 1000 PLN
        Konto konto = new Konto("1234567890", 1000.0, "Jan Kowalski", "jan.kowalski@example.com", "+48 123-456-789");

        // Przykładowe operacje na koncie
        konto.withdraw(900.0);  // wypłata
        konto.deposit(250.0);   // wpłata
        konto.withdraw(50.0);   // kolejna wypłata
        konto.withdraw(500.0);  // próba wypłaty więcej niż dostępne środki

        System.out.println(); // pusty wiersz dla przejrzystości
    }
}