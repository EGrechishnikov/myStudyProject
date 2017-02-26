package bean;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Entity - Order
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude = "amount")
@ToString
@Table(name = "order_list")
public class Order implements Bean {
    private static final long serialVersionUID = 1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_User")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_Goods")
    private Goods goods;

    @Column
    private int amount;

    @Column
    private String isPayed;

    public Order(int amount, String isPayed) {
        this.amount = amount;
        this.isPayed = isPayed;
    }
}
