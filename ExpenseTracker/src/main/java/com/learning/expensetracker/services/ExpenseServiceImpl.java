package com.learning.expensetracker.services;

import com.learning.expensetracker.model.Expense;
import com.learning.expensetracker.utils.ExpenseDataLoader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    @Override
    public List<Expense> getExpenseByDay(String date) {
        return ExpenseDataLoader.getExpenses().stream()
                .filter(expense -> expense.getDate().equalsIgnoreCase(date)).toList();
    }

    @Override
    public List<Expense> getExpenseByCategoryAndMonth(String category, String month) {
        return ExpenseDataLoader.getExpenses().stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category)
                &&
                expense.getDate().startsWith(month)).toList();
    }

    @Override
    public List<String> getAllExpenseCategories() {
        return   ExpenseDataLoader.getExpenses()
                .stream()
                .map(Expense::getCategory)
                .distinct()
                .toList();
    }

    @Override
    public Optional<Expense> getExpenseById(Long id) {
        return ExpenseDataLoader.getExpenses().stream().filter(
                expense -> expense.getId().equals(id)).findFirst();
    }


}
