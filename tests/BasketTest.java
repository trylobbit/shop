import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by kasia on 07.03.18.
 */
public class BasketTest {

    private Shop shop = new Shop();
    private Product product1 = new Product(276123, new BigDecimal("59.10"), "glass");
    private Product product2 = new Product(972923, new BigDecimal("99.50"), "glass");
    private Product product3 = new Product(840021, new BigDecimal("39.80"), "wine");

    @Before
    public void init(){
        shop.addToAllProductsList(product1, 15);
        shop.addToAllProductsList(product2, 120);
        shop.addToAllProductsList(product3, 82);
        shop.addToBasket(product1,2 );
        shop.addToBasket(product2, 1);
        shop.addToBasket(product3,1);
    }

    @Test
    public void toAddUpPrice_returnSummaryOfOrder(){
        Assert.assertEquals(new BigDecimal("257.50"), shop.getBasket().toAddUpPrice());
    }
    @Test
    public void afterClearBasket_basketIsEmpty(){
        shop.getBasket().clearBasket();
        Assert.assertTrue(shop.getBasket().getBasketProducts().isEmpty());
    }
    @Test
    public void whenAddingProductToBasket_expectProductInsideBasked(){

        Assert.assertTrue(shop.getBasket().getBasketProducts().containsKey(product1));
    }
    @Test
    public void whenAddingProductWhichExistInBasket_increaseAmountOfProduct(){
        Product product1 = new Product(276123, new BigDecimal("59.10"), "glass");

        Shop shop = new Shop();
        shop.addToAllProductsList(product1, 15);

        shop.addToBasket(product1,1 );
        shop.addToBasket(product1,4 );

        Assert.assertEquals(new Integer(5),shop.getBasket().getBasketProducts().get(product1));
    }
}
