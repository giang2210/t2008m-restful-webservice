package com.example.t2008m_restful_webservice.service;

import com.example.t2008m_restful_webservice.entity.Product;
import com.example.t2008m_restful_webservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return  productRepository.findAll();
    }
    public Optional<Product> findById(Integer id){
        return  productRepository.findById(id);
    }
    public Product save(Product product) {
        return  productRepository.save(product);
    }
    public List<Product> saveAll(List<Product> products){return  productRepository.saveAll(products);
    }
    public void  deleteById(Integer id){
        productRepository.deleteById(id);
    }
}
