package bean;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity - User
 */
@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "orders")
@ToString(exclude = "orders")
public class User implements Bean {
    public static final String LOGIN_REGEX = "[a-zA-Zа-яА-Я0-9_.-]+";
    public static final String PASSWORD_REGEX = "[a-zA-Zа-яА-Я0-9_.-]{6,}";
    public static final String EMAIL_REGEX = "[a-zA-Z0-9_.-]+[@][a-zA-Z_.-]+[.][a-zA-Z]+";

    private static final long serialVersionUID = 1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String phone;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_ROLE")
    private Role role;
    @OneToMany(mappedBy = "user")
    Set<Order> orders = new HashSet<>();

    @Column
    protected String salt; //Соль для хэширования пароля

    public User(String login, String password, String email, String phone, String salt) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.salt = salt;
    }
}
