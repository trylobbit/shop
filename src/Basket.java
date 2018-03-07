import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kasia on 06.03.18.
 */
public class Basket implements Printable {

    private Map<Product, Integer> basketProducts = new HashMap<>();

    public void addToBasket(Product product, int amountOfProducts) {
        if(amountOfProducts <= 0){
            throw new IllegalArgumentException("amountOfProducts must be grater than 0");}
        if (basketProducts.containsKey(product)) {
            int actualNumber = basketProducts.get(product) + amountOfProducts;
            basketProducts.replace(product, actualNumber);
        }else {
            basketProducts.put(product, amountOfProducts);
        }
    }

    public void clearBasket() {
        basketProducts.clear();
    }

    public Map<Product, Integer> getBasketProducts() {
        return basketProducts;
    }

    public BigDecimal toAddUpPrice(){
         BigDecimal orderPrice = BigDecimal.ZERO;

        for(Map.Entry<Product, Integer> entry : basketProducts.entrySet()){
            Integer entryValue =entry.getValue();
            BigDecimal entryValueBd = new BigDecimal(entryValue);
            BigDecimal entryPrice = entry.getKey().getPrice();

            orderPrice = orderPrice.add(entryPrice.multiply(entryValueBd));
        }
        return orderPrice;
    }
    public void printSummaryPrice(){
       BigDecimal orderPrice = toAddUpPrice();
        System.out.println(orderPrice);
    }
    @Override
    public void printAllProducts() {
        for (Map.Entry<Product, Integer> entry : basketProducts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
