package pl.pp;
import java.util.Scanner;

public class mojaTrzeciaAplikacja {
    public static void main(String[] args) {

       /* Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj proszę liczbę większą od 100:");

        //pętla WHILE (https://introcs.cs.princeton.edu/java/11cheatsheet/images/while.png)
        var number1 = scanner.nextDouble();
        while (number1 <= 100) {
            System.out.println("Liczba nie jest większa od 100, podaj jeszcze raz:");
            number1 = scanner.nextDouble();
        }
        System.out.println("Dziękuję! Podałeś liczbę: " + number1);

        //pętla DO..WHILE (https://introcs.cs.princeton.edu/java/11cheatsheet/images/do-while.png)
        double number2;
        do {
            System.out.println("Podaj proszę liczbę większą od 200:");
            number2 = scanner.nextDouble();
        } while (number2 <= 200);
        System.out.println("Dziękuję! Podałeś liczbę: " + number2);

        //pętla FOR (https://introcs.cs.princeton.edu/java/11cheatsheet/images/for.png)
        int wynik = 0;
        for (var i = 1; i <= 10; i++) {
            wynik = wynik + i;
            System.out.println("Przebieg numer " + i + " w pętli for, a zmienna wynik = " + wynik);
        }

        //instrukcje warunkowe IF..ELSE (https://introcs.cs.princeton.edu/java/11cheatsheet/images/if.png)
        System.out.println("Podaj proszę liczbę x: ");
        var x = scanner.nextDouble();
        System.out.println("Podaj proszę liczbę y: ");
        var y = scanner.nextDouble();

        if(x > y){
            System.out.println("x jest większe od y");
        } else if (x < y) {
            System.out.println("x jest mniejsze od y");
        } else {
            System.out.println("x jest równe y");
        }

        //zakończenie programu za pomocą wpisania odpowiedniego klawisza
        while(true)
        {
            System.out.println("Wpisz wartość -1 żeby wyjść z programu");
            var input = scanner.nextDouble();
            if(input == -1){
                System.out.println("Wyjście...");
                break;
            }
        }
        scanner.close(); */

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Podaj liczbę dni do przekonwertowania: ");
            int dni = scanner.nextInt();

            if (dni <= 0) {
                while (true) {
                    System.out.print("Podaj temperaturę w stopniach Fahrenheita: ");
                    double fhr = scanner.nextDouble();

                    if (fhr == -1) {
                        System.out.println("Kończę program.");
                        scanner.close();
                        return;
                    }

                    double cl = (fhr - 32) / 1.8;
                    double kelvin = cl + 273.15;

                    System.out.printf("Twoje temperatury to: %.2f°F czyli %.2f°C czyli %.2fK%n", fhr, cl, kelvin);
                    System.out.println("Napisz -1 jesli chcesz zakonczyc program.");
                }
            }

            int tygodnie = dni / 7;
            int reszta = dni % 7;
            System.out.println(dni + " dni to " + tygodnie + " tygodnie i " + reszta + " dni.");
            System.out.println("Chcesz ponownie coś przekonwertować?");
        }
    }
}