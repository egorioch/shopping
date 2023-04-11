package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
