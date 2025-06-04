import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

public class mojaTrzynastaAplikacja {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File inputFile;

        // Wczytywanie poprawnej ścieżki do pliku wejściowego
        while (true) {
            System.out.print("Podaj ścieżkę do pliku wejściowego: ");
            String inputPath = scanner.nextLine();
            inputFile = new File(inputPath);

            if (inputFile.exists() && inputFile.isFile()) {
                break;
            } else {
                System.out.println("Plik nie istnieje. Spróbuj ponownie.");
            }
        }

        // Zmienna na liczbę słów i mapa do zliczania wystąpień
        int totalWords = 0;
        HashMap<String, Integer> wordCount = new HashMap<>();

        // Wczytanie i przetworzenie pliku
        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNext()) {
                String word = fileScanner.next().toLowerCase();
                word = word.replaceAll("[^a-zA-Z0-9ąćęłńóśźżĄĆĘŁŃÓŚŹŻ]", "");

                if (!word.isEmpty()) {
                    totalWords++;
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku: " + e.getMessage());
            return;
        }

        // Wyświetlenie wyników w konsoli
        System.out.println("\nLiczba wszystkich słów: " + totalWords);
        System.out.println("Wystąpienia słów:");
        for (String word : wordCount.keySet()) {
            System.out.println(word + ": " + wordCount.get(word));
        }

        // Zapytanie o ścieżkę pliku wyjściowego
        System.out.print("\nPodaj ścieżkę do pliku wyjściowego: ");
        String outputPath = scanner.nextLine();
        File outputFile = new File(outputPath);

        // Zapis wyników do pliku
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("Nazwa pliku: " + inputFile.getName() + "\n");
            writer.write("Liczba słów: " + totalWords + "\n");
            writer.write("Wystąpienia słów:\n");

            for (String word : wordCount.keySet()) {
                writer.write(word + ": " + wordCount.get(word) + "\n");
            }

            System.out.println("Wyniki zapisano do pliku: " + outputPath);
        } catch (IOException e) {
            System.out.println("Błąd zapisu: " + e.getMessage());
        }
    }
}