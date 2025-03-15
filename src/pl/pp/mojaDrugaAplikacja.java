

public class mojaDrugaAplikacja {
    public static void main(String[] args) {
        // 1. Deklaracja i przypisanie wartości zmiennej x
        int x = 10;

        // 2. Obliczenie dwukrotności x
        int doubleX = 2 * x;

        // 3. Obliczenie kwadratu x
        int squareX = x * x;

        // 4. Wyświetlenie wyników na konsoli z odpowiednim opisem
        System.out.println("Wartość x = " + x);
        System.out.println("Dwukrotność x = " + doubleX);
        System.out.println("Kwadrat x = " + squareX);
    }
}


  //Zad 2:

package pl.pp;
import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        // 1. Utworzenie obiektu Scanner do pobierania danych z klawiatury
        Scanner scanner = new Scanner(System.in);

        // 2. Wyświetlenie komunikatu i pobranie wieku w latach
        System.out.print("Podaj swój wiek w latach: ");
        int age = scanner.nextInt();

        // 3. Przeliczenie wieku na sekundy
        // 1 rok = 365 dni
        // 1 dzień = 24 godziny, 1 godzina = 3600 sekund
        long seconds = (long) age * 365 * 24 * 3600;

        // 4. Wyświetlenie wyniku
        System.out.println("Twój wiek w sekundach to: " + seconds);

        scanner.close();
    }
}