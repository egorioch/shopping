package shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@ToString(of = {"id", "role_label"})
@AllArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String role_label;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;

    public Role() { };
    public Role(String role_label) {
        this.role_label = role_label;
    }

    @Override
    public String getAuthority() {
        return role_label;
    }
}
