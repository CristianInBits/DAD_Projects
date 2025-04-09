package es.chatgpt.code.product_image_api.services;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import es.chatgpt.code.product_image_api.models.Product;

@Service
public class ProductService {

    private ConcurrentMap<Long, Product> products = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    public ProductService() {
        save(new Product("Smartphone", "Latest 5G smartphone with OLED display"));
        save(new Product("Laptop", "Lightweight laptop with 16GB RAM and 1TB SSD"));
    }

    public Collection<Product> findAll() {
        return products.values();
    }

    public Product findById(long id) {
        return products.get(id);
    }

    public void save(Product product) {
        if (product.getId() == null || product.getId() == 0) {
            long id = nextId.getAndIncrement();
            product.setId(id);
        }
        products.put(product.getId(), product);
    }

    public void deleteById(long id) {
        products.remove(id);
    }
}
