package es.chatgpt.code.productcatalog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.chatgpt.code.productcatalog.models.Product;

@Controller
public class ProductController {

    private final List<Product> products = new ArrayList<>();
    private long nextId = 1;

    public ProductController() {
        // Productos de ejemplo
        products.add(new Product(nextId++, "Laptop", "Gaming laptop with RTX 4060", 1299.99));
        products.add(new Product(nextId++, "Mouse", "Wireless mouse", 29.99));
    }

    @GetMapping("/")
    public String showAllProducts(Model model) {
        model.addAttribute("products", products);
        return "products/main";
    }

    @GetMapping("/products/new")
    public String showNewProductForm() {
        return "products/new";
    }

    @PostMapping("/products")
    public String saveProduct(Model model, @ModelAttribute Product product) {
        product.setId(nextId++);
        products.add(product);
        model.addAttribute("product", product);
        return "products/product_saved";
    }

    // Muestra un mensaje por su ID
    @GetMapping("/products/{id}")
    public String showProduct(Model model, @PathVariable long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                model.addAttribute("product", product);
                return "products/show";
            }

        }
        return "redirect:/";
    }

    @GetMapping("/products/{id}/delete")
    public String deleteProducts(Model model, @PathVariable long id) {
        products.removeIf(p -> p.getId() == id);
        model.addAttribute("id", id);
        return "products/deleted";
    }


}
