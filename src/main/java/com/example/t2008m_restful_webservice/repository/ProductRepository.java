package com.example.t2008m_restful_webservice.repository;
import com.example.t2008m_restful_webservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
        @Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
