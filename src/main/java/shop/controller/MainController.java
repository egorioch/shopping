package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.repo.ProductRepo;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private final ProductRepo productRepo;

    public MainController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    public String getMainPage() {
        HashMap<String, Object> frontendData = new HashMap<>();
        frontendData.put("products", productRepo.findAll());
        frontendData.put("isDevMode", true);

        return "products";
    }
}
