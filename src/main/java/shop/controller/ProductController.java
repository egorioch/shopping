package shop.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.model.Product;
import shop.repo.ProductRepo;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    final ProductRepo productRepo;

    @Autowired
    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    public List<Product> getProducts(Model model) {
        List<Product> products = productRepo.findAll();
        model.addAttribute("products", products);

        return products;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Product product) {
        return product;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        product.setCreationTime(LocalDateTime.now());

        Product newProduct = productRepo.save(product);
        System.out.println("create Product: " + newProduct);

        return newProduct;
    }

    @PutMapping("/{id}")
    public Product changeProduct(@PathVariable("id") Product oldProduct, @RequestBody Product changeProduct) {
        BeanUtils.copyProperties(changeProduct, oldProduct, "id");
        Product productFromDb = productRepo.save(oldProduct);
        System.out.println("Измененный объект: " + productFromDb.toString());
        return productFromDb;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Product product) {
        System.out.println("удаляемый объект" + product.toString());
        productRepo.delete(product);
    }

}
