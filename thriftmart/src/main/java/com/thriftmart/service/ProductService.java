package com.thriftmart.service;

import com.thriftmart.model.Product;
import com.thriftmart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product save(Product p) { return repo.save(p); }

    public List<Product> getAllProducts() { return repo.findAll(); }

    public Optional<Product> findById(Long id) { return repo.findById(id); }

    public void delete(Long id) { repo.deleteById(id); }
}
