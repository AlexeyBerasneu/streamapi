package school.sorokin.javacore.data;

import school.sorokin.javacore.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductData {
    private final List<Product> products = new ArrayList<>();

    {
        //Books - category
        products.add(new Product(1L, "The Hobbit", "Books", BigDecimal.valueOf(300)));
        products.add(new Product(2L, "Harry Potter and the Sorcerer's Stone", "Books", BigDecimal.valueOf(15.50)));
        products.add(new Product(3L, "Clean Code", "Books", BigDecimal.valueOf(150)));
        products.add(new Product(4L, "Effective Java", "Books", BigDecimal.valueOf(45.00)));
        products.add(new Product(5L, "Java: The Complete Reference", "Books", BigDecimal.valueOf(49.95)));

        //Toys - category
        products.add(new Product(6L, "Lego Star Wars", "Toys", BigDecimal.valueOf(89.99)));
        products.add(new Product(7L, "Barbie Dreamhouse", "Toys", BigDecimal.valueOf(129.50)));
        products.add(new Product(8L, "Hot Wheels Car Set", "Toys", BigDecimal.valueOf(19.99)));
        products.add(new Product(9L, "Monopoly Board Game", "Toys", BigDecimal.valueOf(29.99)));
        products.add(new Product(10L, "Rubik's Cube", "Toys", BigDecimal.valueOf(9.99)));

        //Children's products - category
        products.add(new Product(11L, "Baby Stroller", "Children's products", BigDecimal.valueOf(249.99)));
        products.add(new Product(12L, "Baby Bottle", "Children's products", BigDecimal.valueOf(8.99)));
        products.add(new Product(13L, "Crib", "Children's products", BigDecimal.valueOf(199.00)));
        products.add(new Product(14L, "Children’s Backpack", "Children's products", BigDecimal.valueOf(35.00)));
        products.add(new Product(15L, "Toy Rattle", "Children's products", BigDecimal.valueOf(5.49)));
    }

    public List<Product> getProducts() {
        return products;
    }
}
