import java.util.*;

public class mojaPietnastaAplikacja {

    public static void main(String[] args) {

        // Tworzymy bibliotekę
        Library biblioteka = new Library("Biblioteka PW – Filia Lab15");

        // Dodajemy kilka pozycji
        biblioteka.addItem(new Book("978-83-01-12345-6", "Pan Lodowego Ogrodu", "Jarosław Grzędowicz", 2005, 712, "fantasy"));
        biblioteka.addItem(new Book("978-83-08-08915-4", "Lem. Życie nie z tej ziemi", "Wojciech Orliński", 2017, 496, "biografia"));
        biblioteka.addItem(new Magazine("ISSN 2392-1632-04", "Pixel", "zespół redakcyjny", 2024, 4));
        biblioteka.addItem(new Dvd("5903570160231", "Interstellar", "Christopher Nolan", 2014, 169));

        // Użytkownicy
        User anna   = new User(1, "Anna Nowak");
        User bartek = new User(2, "Bartek Kowalski");

        // Wypożyczenia
        biblioteka.borrowItem("978-83-01-12345-6", anna);      // książka
        biblioteka.borrowItem("ISSN 2392-1632-04", bartek);    // magazyn
        biblioteka.borrowItem("978-83-01-12345-6", bartek);    // próba wypożyczenia już wypożyczonej pozycji

        // Stan systemu
        System.out.println("\n--- LISTA WSZYSTKICH POZYCJI ---");
        biblioteka.printAllItems();

        System.out.println("\n--- CO MA ANNA? ---");
        anna.printBorrowed();

        System.out.println("\n--- Zwracamy książkę ---");
        biblioteka.returnItem("978-83-01-12345-6", anna);

        System.out.println("\n--- Stan po zwrocie ---");
        biblioteka.printAllItems();
    }
}

/* ====== INTERFEJS WYPOŻYCZALNY ====== */
interface Borrowable {
    boolean isBorrowed();
    void    borrowItem(User user);
    void    returnItem(User user);
}

/* ====== KLASY POMOCNICZE ====== */
class User {
    private final int id;
    private final String name;
    private final List<Item> borrowed = new ArrayList<>();

    public User(int id, String name) { this.id = id; this.name = name; }

    void add(Item item)   { borrowed.add(item); }
    void remove(Item item){ borrowed.remove(item); }

    public void printBorrowed() {
        borrowed.forEach(it -> System.out.println("• " + it));
        if (borrowed.isEmpty()) System.out.println("(brak)");
    }

    @Override public String toString() { return name + " [#" + id + "]"; }
}

/* ====== KLASA ABSTRAKCYJNA ITEM ====== */
abstract class Item implements Borrowable {
    protected final String id;           // ISBN / ISSN / EAN
    protected final String title;
    protected final String author;
    protected final int    year;
    private boolean borrowed = false;
    private User   borrower  = null;

    public Item(String id, String title, String author, int year) {
        this.id     = id;
        this.title  = title;
        this.author = author;
        this.year   = year;
    }

    @Override public boolean isBorrowed() { return borrowed; }

    @Override public void borrowItem(User user) {
        if (borrowed) {
            System.out.println("Pozycja \"" + title + "\" jest już wypożyczona przez " + borrower);
            return;
        }
        borrowed = true;
        borrower = user;
        user.add(this);
        System.out.println(user + " wypożyczył(a) \"" + title + "\"");
    }

    @Override public void returnItem(User user) {
        if (!borrowed || borrower != user) {
            System.out.println("Niepoprawny zwrot pozycji \"" + title + "\"");
            return;
        }
        borrowed = false;
        borrower = null;
        user.remove(this);
        System.out.println(user + " zwrócił(a) \"" + title + "\"");
    }

    @Override public String toString() {
        return String.format("%s \"%s\" (%d) [%s]", getClass().getSimpleName(), title, year,
                borrowed ? ("wypożyczone przez " + borrower) : "dostępne");
    }
}

/* ====== KONKRETNE TYPY POZYCJI ====== */
class Book extends Item {
    private final int pages;
    private final String genre;

    public Book(String id, String title, String author, int year,
                int pages, String genre) {
        super(id, title, author, year);
        this.pages = pages;
        this.genre = genre;
    }
    @Override public String toString() {
        return super.toString() + String.format(" | %d str. | gatunek: %s", pages, genre);
    }
}

class Magazine extends Item {
    private final int issueNo;
    public Magazine(String id, String title, String author, int year, int issueNo) {
        super(id, title, author, year);
        this.issueNo = issueNo;
    }
    @Override public String toString() {
        return super.toString() + " | numer: " + issueNo;
    }
}

class Dvd extends Item {
    private final int duration; // min
    public Dvd(String id, String title, String author, int year, int duration) {
        super(id, title, author, year);
        this.duration = duration;
    }
    @Override public String toString() {
        return super.toString() + " | " + duration + " min";
    }
}

/* ====== KLASA ZARZĄDZAJĄCA BIBLIOTEKĄ ====== */
class Library {
    private final String name;
    private final Map<String, Item> items = new HashMap<>();

    public Library(String name) { this.name = name; }

    public void addItem(Item item) {
        items.put(item.id, item);
        System.out.println("Dodano: " + item);
    }

    public void borrowItem(String id, User user) {
        Item it = items.get(id);
        if (it == null) {
            System.out.println("Brak pozycji o ID " + id);
            return;
        }
        it.borrowItem(user);
    }

    public void returnItem(String id, User user) {
        Item it = items.get(id);
        if (it == null) { System.out.println("Brak pozycji o ID " + id); return; }
        it.returnItem(user);
    }

    public void printAllItems() { items.values().forEach(System.out::println); }

    @Override public String toString() { return name; }
}