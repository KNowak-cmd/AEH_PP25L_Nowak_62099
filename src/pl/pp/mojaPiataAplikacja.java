package pl.pp;

import java.util.Scanner;

public class mojaPiataAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pobieranie danych od użytkownika
        System.out.print("Podaj znak do wyświetlenia: ");
        char znak = scanner.next().charAt(0);

        System.out.print("Podaj liczbę kolumn (ile razy wydrukować znak w wierszu): ");
        int kolumny = scanner.nextInt();

        System.out.print("Podaj liczbę wierszy (ile wierszy wydrukować): ");
        int wiersze = scanner.nextInt();

        // Wywołanie metody
        printCharGrid(znak, kolumny, wiersze);
    }

    // Metoda drukująca znak w określonej liczbie kolumn i wierszy
    private static void printCharGrid(char znak, int kolumny, int wiersze) {
        for (int i = 0; i < wiersze; i++) {
            for (int j = 0; j < kolumny; j++) {
                System.out.print(znak);
            }
            System.out.println();
        }
    }
}
