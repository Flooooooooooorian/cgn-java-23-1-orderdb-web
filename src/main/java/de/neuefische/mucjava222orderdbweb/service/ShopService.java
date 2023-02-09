package de.neuefische.mucjava222orderdbweb.service;

import de.neuefische.mucjava222orderdbweb.model.Product;
import de.neuefische.mucjava222orderdbweb.model.Order;
import de.neuefische.mucjava222orderdbweb.repository.OrderRepository;
import de.neuefische.mucjava222orderdbweb.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShopService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private IdService idService;

    public ShopService(OrderRepository orderRepository, ProductRepository productRepository, IdService idService) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.idService = idService;
    }

    public Product getProduct(String id) {
        return productRepository.get(id);
    }

    public List<Product> listProducts() {
        return productRepository.list();
    }

    public List<Order> listOrders() {
        return orderRepository.list();
    }

    public Order getOrder(String id) {
        return orderRepository.get(id);
    }

    public Order addOrder(String orderId, List<String> ids) {

        List<Product> products = new ArrayList<>();

        for (String id : ids) {
            Product product = productRepository.get(id);
            products.add(product);
        }

        Order newOrder = new Order(orderId, products);
        return orderRepository.add(newOrder);
    }

    public Product addProduct(Product product) {
        String id = idService.generateId();
        Product productWithId = new Product(product.name(), id);

        return productRepository.add(productWithId);
    }
}
