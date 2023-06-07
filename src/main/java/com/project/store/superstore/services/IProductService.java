package com.project.store.superstore.services;

import com.project.store.superstore.models.Product;
import com.project.store.superstore.models.ResponseObject;

public interface IProductService {
    public ResponseObject getAllProduct();
    public ResponseObject getProductById(Long id);
    public ResponseObject createProduct(Product newProduct);
    public ResponseObject updateProduct(Product updateProduct, Long id);
    public ResponseObject deleteProduct(Long id);
}
