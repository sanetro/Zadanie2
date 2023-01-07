package pl.edu.wszib.store.paints.gui;

public sealed class InformationTexts permits GUI {
    InformationTexts(){
    }

    public void loginMessage() {
        System.out.println("1. Zaloguj");
        System.out.println("2. Zarejestruj");
        System.out.println("3. Zakończ");
    }
    public void adminMessage() {
        System.out.println("\n=== Panel Adminowy ===");
        System.out.println("1. Lista produktow");
        System.out.println("2. Kup Produkt");
        System.out.println("3. Zwiększ liczbe sztuk produktu");
        System.out.println("4. Nadaj uprawnienia administratora userowi");
        System.out.println("5. Wyloguj");
    }
    public void userMessage() {
        System.out.println("\n=== Panel Userowy ===");
        System.out.println("1. Lista produktow");
        System.out.println("2. Kup Produkt");
        System.out.println("3. Wyloguj");
    }

    public void headlineProductLayout() {
        System.out.println("ID FIRMA NAZWA CENA ILOŚĆ MAGAZYN KATEGORIA");
        System.out.println("--------------------------------------------------");
    }

}
