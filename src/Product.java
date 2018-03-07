import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by kasia on 06.03.18.
 */
public class Product implements Comparable<Product> {
    private Integer id;
    private BigDecimal price;
    private String name;


    public Product(Integer id, BigDecimal price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Product p) {
        return id.compareTo(p.getId());
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 37 * result + id.hashCode();
        result = 37 * result + price.hashCode();
        result = 37 * result + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (this == obj){
            return true;
        }
        if (this.getClass() != obj.getClass()){
            return false;
        }
        Product objP = (Product) obj;
        return this.id.equals(objP.id) && this.name.equals(objP.name) && this.price.equals(objP.price);

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
