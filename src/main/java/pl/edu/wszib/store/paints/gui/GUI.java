package pl.edu.wszib.store.paints.gui;

import pl.edu.wszib.store.paints.database.ProductsDB;
import pl.edu.wszib.store.paints.model.*;
import java.util.Scanner;

public non-sealed class GUI extends InformationTexts {
    private final Scanner scanner = new Scanner(System.in);
    final ProductsDB productsDB = ProductsDB.getInstance();
    private static final GUI instance = new GUI();
    private GUI() {
    }

    public String showMenu() {
        this.loginMessage();
        return scanner.nextLine();
    }

    public String showAdminPanel() {
        this.adminMessage();
        return scanner.nextLine();
    }

    public String readUserLogin() {
        System.out.println("Nazwa usera:");
        return scanner.nextLine();
    }

    public String showUserPanel() {
        this.userMessage();
        return scanner.nextLine();
    }

    public int readId() {
        System.out.println("ID przedmiotu:");
        return scanner.nextInt();
    }

    public int readQuantity() {
        System.out.println("Liczba sztuk:");
        return scanner.nextInt();
    }

    public void listProduct() {
        this.headlineProductLayout();
        productsDB.getProducts().stream().map(
                product -> product.getId() + " " +
                        product.getCompany() + " " +
                        product.getName() + " " +
                        product.getPrice() + " " +
                        product.getQuantity() + " " +
                        (product.getAvailable() ? "Nie" : "Tak")  + " " +
                        product.getCategory().name()
        ).forEach(System.out::println);
    }

    public String readPlate() {
        System.out.println("Plate:");
        return this.scanner.nextLine();
    }

    public User readLoginAndPassword() {
        User user = new User();
        System.out.println("Login:");
        user.setLogin(this.scanner.nextLine());
        System.out.println("Haslo:");
        user.setPassword(this.scanner.nextLine());
        return user;
    }
    public static GUI getInstance() {
        return instance;
    }
}
