package de.neuefische.mucjava222orderdbweb.controller;

import de.neuefische.mucjava222orderdbweb.model.Product;
import de.neuefische.mucjava222orderdbweb.model.Order;
import de.neuefische.mucjava222orderdbweb.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shop")
public class ShopController {

    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("products")
    public List<Product> getAllProducts() {
        return shopService.listProducts();
    }

    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable String id) {
        return shopService.getProduct(id);
    }

    @GetMapping("orders")
    public List<Order> getAllOrders() {
        return shopService.listOrders();
    }

    @GetMapping("orders/{id}")
    public Order getOrder(@PathVariable String id) {
        return shopService.getOrder(id);
    }

    @PostMapping("products")
    public Product addProduct(@RequestBody Product product) {
        return shopService.addProduct(product);
    }

    @PostMapping("orders/{id}")
    public Order addOrder(@PathVariable String id, @RequestBody List<String> productIds) {
        return shopService.addOrder(id, productIds);
    }
}
