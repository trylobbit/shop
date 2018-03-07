import java.util.HashMap;
import java.util.Map;

/**
 * Created by kasia on 06.03.18.
 */
public class Shop implements Printable {

    public Map<Product, Integer> getAllProducts() {
        return allProducts;
    }

    private Map<Product, Integer> allProducts = new HashMap<>();

    private Basket basket = new Basket();

    @Override
    public void printAllProducts() {
        for (Map.Entry<Product, Integer> entry : allProducts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void addToAllProductsList(Product product, int amountOfProducts) {
        if (amountOfProducts <= 0) {
            throw new IllegalArgumentException("Number should be greater than zero");
        }
        if (allProducts.containsKey(product)) {
            increaseAmountOfProduct(product, amountOfProducts);
        } else {
            allProducts.put(product, amountOfProducts);
        }
    }

    public void addToBasket(Product product, int amountOfProducts) {
        if(allProducts.containsKey(product)){
            Integer availableProducts = allProducts.get(product);
            if (amountOfProducts > availableProducts) {
                basket.addToBasket(product, availableProducts);
            } else {
                basket.addToBasket(product, amountOfProducts);
            }
        }

    }

    public void reduceAmountOfProduct(Product product, int amountOfProducts) {
        decreaseQuantityOfProducts(product, amountOfProducts);
    }

    public void removeProductOfList(Product product) {
        allProducts.remove(product);
    }


    public void buyProducts() {
        Map<Product, Integer> basketProducts = basket.getBasketProducts();
        for (Map.Entry<Product, Integer> entry : basketProducts.entrySet()) {
            decreaseQuantityOfProducts(entry.getKey(), entry.getValue());
        }
        basket.clearBasket();
    }

    private void decreaseQuantityOfProducts(Product product, int amount) {
        if (amount > allProducts.get(product)) {
            throw new IllegalArgumentException("This value of product amount is not available");
        }
        if (amount == allProducts.get(product)) {
            removeProductOfList(product);
        }
        Integer updateNumber = allProducts.get(product) - amount;
        updateProductState(product, updateNumber);

    }

    public void increaseAmountOfProduct(Product product, int amount) {
        Integer numberOfProduct = allProducts.get(product);
        Integer updateNumber = numberOfProduct + amount;
        updateProductState(product, updateNumber);
    }

    public void updateProductState(Product product, Integer updateNumber) {
        allProducts.replace(product, updateNumber);
    }

    public Basket getBasket() {
        return basket;
    }

}