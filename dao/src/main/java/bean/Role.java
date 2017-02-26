package bean;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity - Role
 */
@Data
@Entity
@Table(name = "role")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "users")
@EqualsAndHashCode(exclude = "users")
@Immutable
public class Role implements Bean {
    private static final long serialVersionUID = 1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }
}
