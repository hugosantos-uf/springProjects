package com.studys.restapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class ProductsController {

    private static final String FILE_PATH = "products.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/product")
    public ResponseEntity<String> createProduct(@RequestBody Product product) throws IOException {
        List<Product> products = readProductsFromFile();
        products.add(product);
        writeProductsToFile(products);
        return new ResponseEntity<>("Product Created" + product.getName(), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() throws IOException {
        List<Product> products = readProductsFromFile();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws IOException {
        List<Product> products = readProductsFromFile();
        for(Product product: products){
            if (product.getId().equals(id)){
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id, @RequestBody Product updatedProduct) throws IOException {
        List<Product> products = readProductsFromFile();
        for(Product product: products){
            if (product.getId().equals(id)){
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                writeProductsToFile(products);
                return new ResponseEntity<>("Produto Alterado", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) throws IOException {
        List<Product> products = readProductsFromFile();
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            Product product = iterator.next();
            if (product.getId().equals(id)){
                iterator.remove();
                writeProductsToFile(products);
                return new ResponseEntity<>("Produto Removido", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
    }

    public void writeProductsToFile(List<Product> products) throws IOException {
        objectMapper.writeValue(new File(FILE_PATH), products);
    }

    private List<Product> readProductsFromFile() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()){
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, new TypeReference<List<Product>>() {
        });
    }


}
