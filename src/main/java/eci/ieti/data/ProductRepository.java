package eci.ieti.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import eci.ieti.data.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	Page<Product> findByDescriptionContaining(String description, Pageable pageable);
        
        
}
