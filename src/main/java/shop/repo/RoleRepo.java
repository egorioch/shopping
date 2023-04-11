package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
