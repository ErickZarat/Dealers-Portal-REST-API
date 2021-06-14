package me.erickzarat.portal.products;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
@Api(value = "Products", description = "REST API for Products", tags = { "Products" })
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public @ResponseBody Iterable<Product> getAllProducts(@RequestParam(value = "dealerCode", required = false) Integer dealerCode) {
        return productRepository.findAllByDealer_Code(dealerCode);
    }

    @GetMapping("/{code}")
    public @ResponseBody Product getProduct(@PathVariable("code") Integer code) {
        Optional<Product> response =  productRepository.findById(code);
        return response.orElse(null);
    }

    @PostMapping
    public @ResponseBody Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/{code}")
    public @ResponseBody Product updateProduct(@RequestBody Product product){
        if (productRepository.existsById(product.code)){
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{code}")
    public @ResponseBody Boolean deleteProduct(@PathVariable("code") Integer code){
        if (productRepository.existsById(code)){
            productRepository.deleteById(code);
            return true;
        } else {
            return false;
        }
    }
}
