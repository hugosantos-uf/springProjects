package com.learning.expensetracker.controller;

import com.learning.expensetracker.model.Expense;
import com.learning.expensetracker.utils.ExpenseDataLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController {

    @GetMapping("/expenses/categories")
    public ResponseEntity<List<String>> getAllExpenseCategories(){
       List<String> categories = ExpenseDataLoader.getExpenses()
               .stream()
               .map(Expense::getCategory)
               .distinct()
               .toList();

       if(categories.isEmpty()){
           return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
       }
       return ResponseEntity.ok(categories);
    }
}


