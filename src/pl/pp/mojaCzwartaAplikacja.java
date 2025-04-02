package pl.pp;
import java.util.Scanner;

public class mojaCzwartaAplikacja {
           public static void main(String[] args) {

               Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter lower and upper integer limits: ");
            int lower = scanner.nextInt();
            int upper = scanner.nextInt();

            if (upper <= lower) {
                System.out.println("Done");
                break;
            }

            int sum = 0;
            for (int i = lower; i <= upper; i++) {
                sum += i * i;
            }

            System.out.println("The sums of the squares from " + (lower * lower) + " to " + (upper * upper) + " is " + sum);
        }

        scanner.close();
    }
}


//zadanie 2 - Kalkulator

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Wybierz operację:\n1. Dodawanie\n2. Odejmowanie\n3. Mnożenie\n4. Dzielenie\n5. Wyjście");
            System.out.print("Twój wybór: ");
            int wybor = getInt(scanner);
            if (wybor == 5) break;
            if (wybor < 1 || wybor > 4) {
                System.out.println("Błąd: Wybierz opcję od 1 do 5.");
                continue;
            }
            double liczba1 = getDouble(scanner, "Podaj pierwszą liczbę: ");
            double liczba2 = getDouble(scanner, "Podaj drugą liczbę: ");
            System.out.println("Wynik: " + oblicz(wybor, liczba1, liczba2));
        }
        scanner.close();
    }

    private static int getInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Błąd: Wprowadź liczbę od 1 do 5.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double getDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Błąd: Wprowadź poprawną liczbę.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    private static double oblicz(int wybor, double a, double b) {
        return switch (wybor) {
            case 1 -> a + b;
            case 2 -> a - b;
            case 3 -> a * b;
            case 4 -> b == 0 ? Double.NaN : a / b;
            default -> throw new IllegalStateException("Nieznana operacja");
        };
    }
}



