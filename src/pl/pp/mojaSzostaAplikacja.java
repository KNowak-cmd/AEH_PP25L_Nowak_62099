package pl.pp;

public class mojaSzostaAplikacja {
    public static void main(String[] args) {

        // zakomentowany kod:
        /*
        System.out.println("Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji");
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Twoj wynik #1 to " + finalScore);
        }

        */

        // Nowy kod - obliczanie silni

        // Przykładowa liczba N, dla której chcemy obliczyć silnię
        int N = 50;
        System.out.println("Obliczamy silnię liczby " + N);

        // Obliczanie silni metodą iteracyjną oraz pomiar czasu wykonania
        long startIter = System.nanoTime();
        long factorialIter = factorialIterative(N);
        long endIter = System.nanoTime();
        long timeIter = endIter - startIter;

        System.out.println("Iteracyjnie: " + N + "! = " + factorialIter);
        System.out.println("Czas wykonania metody iteracyjnej: " + timeIter + " ns");

        // Obliczanie silni metodą rekurencyjną oraz pomiar czasu wykonania
        long startRec = System.nanoTime();
        long factorialRec = factorialRecursive(N);
        long endRec = System.nanoTime();
        long timeRec = endRec - startRec;

        System.out.println("Rekurencyjnie: " + N + "! = " + factorialRec);
        System.out.println("Czas wykonania metody rekurencyjnej: " + timeRec + " ns");
    }

    // Metoda obliczająca silnię iteracyjnie
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Metoda obliczająca silnię rekurencyjnie
    public static long factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorialRecursive(n - 1);
        }
    }
}
