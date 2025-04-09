package es.chatgpt.code.product_image_api.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.URI;
import java.net.MalformedURLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import es.chatgpt.code.product_image_api.models.Product;
import es.chatgpt.code.product_image_api.services.ImageService;
import es.chatgpt.code.product_image_api.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final String PRODUCTS_FOLDER = "products";

    @Autowired
    private ProductService products;

    @Autowired
    private ImageService imgService;

    @GetMapping("/")
    public Collection<Product> getAll() {
        return products.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable long id) {
        Product product = products.findById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        products.save(product);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(location).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable long id, @RequestBody Product updated) {
        Product existing = products.findById(id);
        if (existing != null) {
            updated.setId(id);
            products.save(updated);
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable long id) throws IOException {
        Product product = products.findById(id);
        if (product != null) {
            products.deleteById(id);
            if (product.getImage() != null) {
                imgService.deleteImage(PRODUCTS_FOLDER, id);
            }
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
            throws IOException {
        Product product = products.findById(id);
        if (product != null) {
            URI location = fromCurrentRequest().build().toUri();
            product.setImage(location.toString());
            products.save(product);
            imgService.saveImage(PRODUCTS_FOLDER, id, imageFile);
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws MalformedURLException {
        return imgService.createResponseFromImage(PRODUCTS_FOLDER, id);
    }

    @DeleteMapping("/{id}/image")
    public ResponseEntity<Object> deleteImage(@PathVariable long id) throws IOException {
        Product product = products.findById(id);
        if (product != null) {
            product.setImage(null);
            products.save(product);
            imgService.deleteImage(PRODUCTS_FOLDER, id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}