package com.learning.expensetracker;

import com.learning.expensetracker.model.Expense;
import com.learning.expensetracker.utils.ExpenseDataLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ExpenseTrackerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

	@Override
	public void run (String... args){
		List<Expense> expenseList = ExpenseDataLoader.getExpenses();
		expenseList.forEach(System.out::println);
	}
}
