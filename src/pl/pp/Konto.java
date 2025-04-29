package pl.pp;

public class Konto {
    // Prywatne pola
    private String accountNumber;
    private double balance;
    private String ownerName;
    private String email;
    private String phoneNumber;

    // Utworzenie konta z początkowymi danymi
    public Konto(String accountNumber, double balance, String ownerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerName = ownerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Odczyt prywatnych danych
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getOwnerName() { return ownerName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    // zmiana danych przez set
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // Metoda do wpłaty pieniędzy
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // dodajemy kwotę do salda
            System.out.printf("Wpłata PLN %.1f została wykonana. Nowe saldo PLN %.1f\n", amount, balance);
        } else {
            System.out.println("Kwota wpłaty musi być większa niż 0.");
        }
    }

    // Metoda do wypłaty pieniędzy
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount; // odejmujemy kwotę od salda
            System.out.printf("Pobrano PLN %.1f z konta, Pozostałe saldo = PLN %.1f\n", amount, balance);
        } else {
            System.out.printf("Brak środków. Masz PLN %.1f na koncie.\n", balance);
        }
    }
}