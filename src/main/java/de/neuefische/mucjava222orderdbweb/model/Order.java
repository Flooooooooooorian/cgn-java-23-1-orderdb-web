package de.neuefische.mucjava222orderdbweb.model;


import java.util.List;

public record Order(
        String id,
        List<Product> products
) {

}
