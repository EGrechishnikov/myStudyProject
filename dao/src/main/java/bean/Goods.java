package bean;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity - Goods (Wallpaper)
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "catalog")
@Getter
@Setter
@EqualsAndHashCode(exclude = "orders")
@ToString(exclude = "orders")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Goods implements Bean {
    private static final long serialVersionUID = 1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String size;
    @Column
    private String collection;
    @Column
    private String country;
    @Column(name = "vendor_code")
    private String vendorCode;
    @Column
    private String img;         //link to image
    @Column
    private int price;
    @Column
    private int sale;           //%

    private int salePrice;      //final price

    @OneToMany(mappedBy = "goods")
    private Set<Order> orders = new HashSet<>();

    public Goods(String name, String description, String size, String collection, String country, String vendorCode, String img, int price, int sale) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.collection = collection;
        this.country = country;
        this.vendorCode = vendorCode;
        this.img = img;
        this.price = price;
        this.sale = sale;
        setSalePrice();
    }

    public void setSalePrice() {
        if (sale == 0) {
            salePrice = price;
        } else {
            salePrice = (int) (getPrice() - ((double) getPrice() / 100 * getSale()));
        }
    }

    public int getSalePrice() {
        setSalePrice();
        return salePrice;
    }
}
