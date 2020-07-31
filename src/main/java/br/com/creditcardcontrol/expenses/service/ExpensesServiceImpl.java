package br.com.creditcardcontrol.expenses.service;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import br.com.creditcardcontrol.expenses.model.Expense;
import br.com.creditcardcontrol.expenses.repository.ExpenseRepository;
import br.com.creditcardcontrol.user.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ExpensesServiceImpl implements ExpensesService {

    UserService userService;
    ExpenseRepository repository;

    @Override
    public ExpenseResponse save(ExpenseRequest dto) {
        Expense expense = Expense.builder()
                .date(dto.getDate())
                .value(dto.getValue())
                .user(userService.getCurrentUser())
                .build();

        Expense expenseSaved = repository.save(expense);

        return ExpenseResponse.builder()
                .id(expenseSaved.getId())
                .date(expenseSaved.getDate())
                .value(expenseSaved.getValue())
                .build();
    }
}
