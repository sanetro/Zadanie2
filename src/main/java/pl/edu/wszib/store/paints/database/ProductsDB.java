package pl.edu.wszib.store.paints.database;

import pl.edu.wszib.store.paints.model.Product;

import java.util.ArrayList;

public class ProductsDB {

    private ArrayList<Product> products = new ArrayList<Product>();
    private static final ProductsDB instance = new ProductsDB();

    public ProductsDB() {
        products.add(new Product(0, "DULUX", "farba biala", Product.Categories.FARBA, 84.23, 12, true));
        products.add(new Product(1, "DULUX", "farba czerwona", Product.Categories.FARBA, 23.15, 23, true));
        products.add(new Product(2, "JEDYNKA", "farba czerwona", Product.Categories.FARBA, 231.54, 4, true));
        products.add(new Product(3, "GLUEHOLD", "Klej do drewna", Product.Categories.KLEJ, 33.22, 21, false));
        products.add(new Product(4, "WOODMANS", "Pedzel Nadzwyczajny", Product.Categories.PEDZEL, 8.00, 97, true));
    }

    public boolean findById(int givenId) {
        for (Product product: this.getProducts()) {
            if (product.getId() == givenId) {
                return true;
            }
        }
        return false;
    }

    public Product getProduct(int givenId) {
        for (Product product: this.getProducts()) {
            if (product.getId() == givenId) {
                return product;
            }
        }
        return null;
    }

    public double buyProduct(int orderedId, int orderedQuantity) {
        int newValueQuantity = this.getProduct(orderedId).getQuantity() - orderedQuantity;
        this.getProduct(orderedId).setQuantity(newValueQuantity);
        return this.getProduct(orderedId).getPrice() * orderedQuantity;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public static ProductsDB getInstance() {
        return instance;
    }

}
