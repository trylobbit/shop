import java.math.BigDecimal;

/**
 * Created by kasia on 06.03.18.
 */
public class ShopInitializer {

    public void initialize(){
        Product product10 = new Product(213123, new BigDecimal("189.80"), "wine");
        Product product1 = new Product(276123, new BigDecimal("59.10"), "glass");
        Product product2 = new Product(972923, new BigDecimal("99.50"), "glass");
        Product product3 = new Product(840021, new BigDecimal("39.80"), "wine");
        Product product4 = new Product(732435, new BigDecimal("19.90"), "wine");
        Product product5 = new Product(902303, new BigDecimal("49.80"), "wine");
        Product product6 = new Product(100932, new BigDecimal("189.80"), "wine");
        Product product7 = new Product(702324, new BigDecimal("67.90"), "glass");
        Product product8 = new Product(210023, new BigDecimal("30.80"), "wine");
        Product product9 = new Product(211103, new BigDecimal("259.80"), "champagne");
        Product product11 = new Product(276123, new BigDecimal("59.10"), "glass");

        Shop shop = new Shop();
        shop.addToAllProductsList(product1, 15);
        shop.addToAllProductsList(product2, 120);
        shop.addToAllProductsList(product3, 82);
        shop.addToAllProductsList(product4, 40);
        shop.addToAllProductsList(product5, 38);
        shop.addToAllProductsList(product6, 60);
        shop.addToAllProductsList(product7, 34);
        shop.addToAllProductsList(product8, 10);
        shop.addToAllProductsList(product9, 23);
        shop.addToAllProductsList(product10, 5);
        shop.addToAllProductsList(product11, 1);

        shop.getBasket().addToBasket(product1,4);
        System.out.println("sklep:");
        shop.printAllProducts();
        System.out.println("koszyk:");
        shop.getBasket().printAllProducts();
        System.out.println("ŁĄĆZNA SUMA:");
        shop.getBasket().toAddUpPrice();
        shop.getBasket().printSummaryPrice();
        System.out.println("usuwanie ze sklepu:");
        shop.buyProducts();
        shop.printAllProducts();
        System.out.println("oproznianie koszyka:");
        shop.getBasket().printAllProducts();
        System.out.println("usunieto:");
        shop.reduceAmountOfProduct(product1, 1);
        shop.printAllProducts();
        shop.increaseAmountOfProduct(product1, 4);
        shop.printAllProducts();


    }
}
