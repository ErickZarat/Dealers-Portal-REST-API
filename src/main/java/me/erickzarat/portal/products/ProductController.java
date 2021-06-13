package me.erickzarat.portal.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/dealer/{dealerCode}/products")
    public @ResponseBody Iterable<Product> getAllProducts(@PathVariable("dealerCode") Integer dealerCode) {
        return productRepository.findAllByDealer_Code(dealerCode);
    }

    @GetMapping("/products/{code}")
    public @ResponseBody Product getProduct(@PathVariable("code") Integer code) {
        Optional<Product> response =  productRepository.findById(code);
        return response.orElse(null);
    }

    @PostMapping("/dealer/{dealerCode}/products/")
    public @ResponseBody Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/products/{code}")
    public @ResponseBody Product updateProduct(@RequestBody Product product){
        if (productRepository.existsById(product.code)){
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    @DeleteMapping("/products/{code}")
    public @ResponseBody Boolean deleteProduct(@PathVariable("code") Integer code){
        if (productRepository.existsById(code)){
            productRepository.deleteById(code);
            return true;
        } else {
            return false;
        }
    }
}
