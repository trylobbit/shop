import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by kasia on 06.03.18.
 */
public class ShopTest {

    @Test
    public void whenAddingProductsToBasket_basketContainsAddedProduct() {
        Product product10 = new Product(213123, new BigDecimal("189.80"), "wine");
        Product product1 = new Product(276123, new BigDecimal("59.10"), "glass");
        Product product2 = new Product(972923, new BigDecimal("99.50"), "glass");

        Shop shop = new Shop();
        shop.addToAllProductsList(product1, 15);
        shop.addToAllProductsList(product2, 120);
        shop.addToAllProductsList(product10, 82);

        shop.getBasket().addToBasket(product1, 6);
        shop.getBasket().addToBasket(product2, 4);
        shop.getBasket().addToBasket(product10, 2);

        Basket basket = shop.getBasket();
        Integer quantityOfProduct1 = basket.getBasketProducts().get(product1);
        Integer quantityOfProduct2 = basket.getBasketProducts().get(product2);
        Integer quantityOfProduct10 = basket.getBasketProducts().get(product10);
        Assert.assertEquals(new Integer(6), quantityOfProduct1);
        Assert.assertEquals(new Integer(4), quantityOfProduct2);
        Assert.assertEquals(new Integer(2), quantityOfProduct10);

    }

    @Test
    public void whenProductsBought_expectEmptyBasketAndShopUpdated() {
        Product product10 = new Product(213123, new BigDecimal("189.80"), "wine");
        Product product1 = new Product(276123, new BigDecimal("59.10"), "glass");
        Product product2 = new Product(972923, new BigDecimal("99.50"), "glass");

        Shop shop = new Shop();
        shop.addToAllProductsList(product1, 15);
        shop.addToAllProductsList(product2, 120);
        shop.addToAllProductsList(product10, 82);

        shop.getBasket().addToBasket(product1, 6);
        shop.getBasket().addToBasket(product2, 4);
        shop.getBasket().addToBasket(product10, 2);

        Basket basket = shop.getBasket();
        shop.buyProducts();
        Assert.assertTrue(basket.getBasketProducts().isEmpty());
        Map<Product, Integer> allProducts = shop.getAllProducts();
        Assert.assertEquals(new Integer(9), allProducts.get(product1));
        Assert.assertEquals(new Integer(116), allProducts.get(product2));
        Assert.assertEquals(new Integer(80), allProducts.get(product10));
    }

    @Test (expected = IllegalArgumentException.class)
    public void TryToAddToShopProductWithAmount0_shopListDoesNotIncludeProduct(){
        Product product11 = new Product(276123, new BigDecimal("59.10"), "glass");
        Shop shop = new Shop();
        shop.addToAllProductsList(product11, 0);
    }

    @Test
    public void whenProductExistInShop_increaseAmountOfProduct() {
        Product product1 = new Product(276123, new BigDecimal("59.10"), "glass");
        Product product11 = new Product(276123, new BigDecimal("59.10"), "glass");

        Shop shop = new Shop();
        shop.addToAllProductsList(product1, 5);
        shop.addToAllProductsList(product11, 5);

        Assert.assertEquals(new Integer(10), shop.getAllProducts().get(product1));

    }

    @Test
    public void whenRemoveProductOfShop_expectProductDoesntExistInShop() {
        Product product1 = new Product(276123, new BigDecimal("59.10"), "glass");

        Shop shop = new Shop();
        shop.addToAllProductsList(product1, 5);

        shop.removeProductOfList(product1);

        Assert.assertFalse(shop.getAllProducts().containsKey(product1));

    }

    @Test
    public void increaseAmountOfProductAbout3_add3ToActualAmount() {
        Product product1 = new Product(276123, new BigDecimal("59.10"), "glass");

        Shop shop = new Shop();
        shop.addToAllProductsList(product1, 5);

        shop.increaseAmountOfProduct(product1, 3);
        Assert.assertEquals(new Integer(8), shop.getAllProducts().get(product1));

    }

    @Test
    public void reduceAmountOfProductAbout3_decrease3FromActualAmount() {
        Product product1 = new Product(276123, new BigDecimal("59.10"), "glass");

        Shop shop = new Shop();
        shop.addToAllProductsList(product1, 5);

        shop.reduceAmountOfProduct(product1, 3);

        Assert.assertEquals(new Integer(2), shop.getAllProducts().get(product1));

    }
    @Test
    public void reduceAmountOfProductAbout0_doesntChangeActualAmount() {
        Product product2 = new Product(972923, new BigDecimal("99.50"), "glass");

        Shop shop = new Shop();
        shop.addToAllProductsList(product2, 5);

        shop.reduceAmountOfProduct(product2, 0);

        Assert.assertEquals(new Integer(5), shop.getAllProducts().get(product2));

    }
    @Test
    public void reduceAmountOfProductBelow0_doesntChangeActualAmount() {
        Product product10 = new Product(213123, new BigDecimal("189.80"), "wine");

        Shop shop = new Shop();
        shop.addToAllProductsList(product10, 8);

        shop.reduceAmountOfProduct(product10, 0);

        Assert.assertEquals(new Integer(8), shop.getAllProducts().get(product10));

    }


    @Test
    public void updateProductState2_AmountOfProductIs2() {
        Product product1 = new Product(276123, new BigDecimal("59.10"), "glass");

        Shop shop = new Shop();
        shop.addToAllProductsList(product1, 5);

        shop.updateProductState(product1, 2);

        Assert.assertEquals(new Integer(2), shop.getAllProducts().get(product1));


    }
}
