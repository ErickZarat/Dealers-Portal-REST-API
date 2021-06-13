package me.erickzarat.portal.products;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Iterable<Product> findAllByDealer_Code(Integer dealerCode);
}
