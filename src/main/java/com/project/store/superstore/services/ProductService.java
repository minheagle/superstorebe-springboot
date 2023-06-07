package com.project.store.superstore.services;

import com.project.store.superstore.dto.ProductDTO;
import com.project.store.superstore.models.Product;
import com.project.store.superstore.models.ResponseObject;
import com.project.store.superstore.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements  IProductService{
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public ResponseObject getAllProduct() {
        return new ResponseObject("Ok", "Get All Product Success", repository.findAll());
    }

    @Override
    public ResponseObject getProductById(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()){
            return new ResponseObject("Ok", "Get Product Id : "+ id + " Success", product);
        }else{
            return new ResponseObject("Fail", "Get Product Id : "+ id + " Success", "" );
        }
    }

    @Override
    public ResponseObject createProduct(Product newProduct) {
        List<Product> foundProducts = repository.findByProductName(newProduct.getProductName());
        if (foundProducts.size() > 0){
            return new ResponseObject("Fail", "Cannot Create Product", "");
        }else{
            Product product = mapper.map(newProduct, Product.class);
            return new ResponseObject("Ok", "Create Product Success", repository.save(product));
        }
    }

    @Override
    public ResponseObject updateProduct(Product updateProduct, Long id) {
        boolean check = true;

        if(!repository.existsById(id)){
            check = false;
        }
        List<Product> foundProducts = repository.findByProductName(updateProduct.getProductName().trim());
        if (foundProducts.size() > 0){
            check = false;
        }

        if (check){
            Optional<Product> product = repository.findById(id).map(product1 -> {
                product1.setProductName(updateProduct.getProductName());
                product1.setImageUrl(updateProduct.getImageUrl());
                product1.setProductPrice(updateProduct.getProductPrice());
                product1.setProductSold(updateProduct.getProductSold());
                return repository.save(product1);
            });
            return new ResponseObject("Ok", "Update Product Success", product);
        }else{
            return new ResponseObject("Fail", "Update Product Fail", "");
        }
    }

    @Override
    public ResponseObject deleteProduct(Long id) {
        boolean exist = repository.existsById(id);
        if(exist){
            repository.deleteById(id);
            return new ResponseObject("Ok", "Delete Success", "");

        }else{
            return new ResponseObject("Fail", "Cannot find product id : " + id , "");
        }
    }
}
