package com.studys.restapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestPostApiController {

    private static final String FILE_PATH = "products.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/product")
    public ResponseEntity<String> createProduct(@RequestBody Product product) throws IOException {
        List<Product> products = readProductsFromFile();
        products.add(product);
        writeProductsToFile(products);
        return new ResponseEntity<>("Product Created" + product.getName(), HttpStatus.CREATED);
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
