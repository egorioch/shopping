package shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
