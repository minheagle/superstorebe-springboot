package com.project.store.superstore.controllers;

import com.project.store.superstore.models.Product;
import com.project.store.superstore.models.ResponseObject;
import com.project.store.superstore.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("")
    public ResponseEntity<ResponseObject> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iProductService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(iProductService.getProductById(id));
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct){
        return ResponseEntity.status(HttpStatus.OK).body(iProductService.createProduct(newProduct));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateProduct(@RequestBody Product updateProduct, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(iProductService.updateProduct(updateProduct, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(iProductService.deleteProduct(id));
    }
}
