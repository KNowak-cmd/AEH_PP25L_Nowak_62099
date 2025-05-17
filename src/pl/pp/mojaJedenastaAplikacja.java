package pl.pp;

import java.util.*;

// Klasa reprezentująca studenta
class Student {
    String indeks; // numer indeksu studenta
    String imie; // imię studenta
    String nazwisko; // nazwisko studenta
    List<Integer> oceny; // lista ocen studenta

    // Konstruktor ustawiający wszystkie dane studenta
    Student(String indeks, String imie, String nazwisko, List<Integer> oceny) {
        this.indeks = indeks;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.oceny = oceny;
    }

    // Metoda obliczająca średnią ocen studenta
    double obliczSrednia() {
        int suma = 0;
        for (int ocena : oceny) {
            suma += ocena;
        }
        return (double) suma / oceny.size();
    }
}

public class mojaJedenastaAplikacja {
    public static void main(String[] args) {
        // Tworzenie listy studentów z przykładowymi danymi
        List<Student> students = Arrays.asList(
                new Student("12345", "Jan", "Kowalski", Arrays.asList(4, 5, 3, 5)),
                new Student("67890", "Anna", "Nowak", Arrays.asList(5, 5, 4, 4)),
                new Student("54321", "Paweł", "Wiśniewski", Arrays.asList(2, 3, 2, 4)),
                new Student("09876", "Katarzyna", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        Student najlepszy = students.get(0); // Przyjmujemy, że pierwszy student ma najwyższą średnią na start
        double sumaSrednich = 0; // suma średnich wszystkich studentów

        // Pętla przeglądająca wszystkich studentów
        for (Student s : students) {
            double srednia = s.obliczSrednia(); // obliczenie średniej danego studenta
            sumaSrednich += srednia; // dodanie do sumy
            if (srednia > najlepszy.obliczSrednia()) {
                najlepszy = s; // aktualizacja najlepszego studenta
            }
        }

        // Wyświetlenie najlepszego studenta
        System.out.println("Student z najwyższą średnią: " + najlepszy.imie + " " + najlepszy.nazwisko + " (" + najlepszy.indeks + ") - Average: " + najlepszy.obliczSrednia());

        // Obliczenie i wyświetlenie średniej ocen wszystkich studentów
        double sredniaGrupy = sumaSrednich / students.size();
        System.out.println("Średnia ocen wszystkich studentów: " + sredniaGrupy);

        // Sortowanie listy studentów alfabetycznie, po nazwisku
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.nazwisko.compareTo(s2.nazwisko);
            }
        });

        // Wyświetlenie studentów posortowanych według nazwiska
        System.out.println("Studenci posortowani według nazwisk:");
        for (Student s : students) {
            System.out.println(s.imie + " " + s.nazwisko + " (" + s.indeks + ") - Average: " + s.obliczSrednia());
        }
    }
}