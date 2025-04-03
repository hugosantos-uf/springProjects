package com.learning.expensetracker.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.expensetracker.model.Expense;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExpenseDataLoader {

    private static List<Expense> expenses = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/expenses.json");

        expenses = mapper.readValue(inputStream, new TypeReference<List<Expense>>() {
        });
    }

    public static List<Expense> getExpenses() {
        return expenses;
    }
}
