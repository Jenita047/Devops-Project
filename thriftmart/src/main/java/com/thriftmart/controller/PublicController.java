package com.thriftmart.controller;

import com.thriftmart.model.Product;
import com.thriftmart.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublicController {

    private final ProductService productService;

    public PublicController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/", "/index"})
    public String index() {
        return "login"; // default entry page
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list"; // maps to product-list.html
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/order-details")
    public String orderDetails() {
        return "order-details";
    }

    // For placing order (dummy action for UI)
    @PostMapping("/order")
    public String placeOrder(@RequestParam String customerName,
                             @RequestParam Long productId,
                             @RequestParam int quantity,
                             Model model) {
        Product p = productService.findById(productId).orElse(null);
        model.addAttribute("product", p);
        model.addAttribute("quantity", quantity);
        model.addAttribute("message", "Order placed successfully!");
        return "order-details";
    }
}
