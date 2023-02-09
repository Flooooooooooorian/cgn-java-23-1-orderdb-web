package de.neuefische.mucjava222orderdbweb.service;

import de.neuefische.mucjava222orderdbweb.model.Product;
import de.neuefische.mucjava222orderdbweb.repository.OrderRepository;
import de.neuefische.mucjava222orderdbweb.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShopServiceTest {

    @Test
    void listProducts() {
        //GIVEN
        OrderRepository orderRepository = mock(OrderRepository.class);
        ProductRepository productRepository = mock(ProductRepository.class);
        IdService idService = mock(IdService.class);

        ShopService shopService = new ShopService(orderRepository, productRepository, idService);

        when(productRepository.list()).thenReturn(List.of(new Product("Product1", "1")));

        //WHEN
        List<Product> actual = shopService.listProducts();

        //THEN
        Assertions.assertEquals(List.of(new Product("Product1", "1")), actual);
    }

    @Test
    void addProduct() {
        //GIVEN
        OrderRepository orderRepository = mock(OrderRepository.class);
        ProductRepository productRepository = mock(ProductRepository.class);
        IdService idService = mock(IdService.class);

        ShopService shopService = new ShopService(orderRepository, productRepository, idService);

        when(idService.generateId()).thenReturn("123");
        when(productRepository.add(new Product("Product2", "123")))
                .thenReturn(new Product("Product2", "123"));

        //WHEN
        Product actual = shopService.addProduct(new Product("Product2", "2"));

        //THEN
        verify(productRepository).add(new Product("Product2", "123"));
        verify(idService).generateId();
        Assertions.assertEquals(new Product("Product2", "123"), actual);
    }
}
