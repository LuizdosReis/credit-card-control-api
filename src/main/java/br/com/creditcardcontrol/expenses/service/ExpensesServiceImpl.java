package br.com.creditcardcontrol.expenses.service;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
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
    public void save(ExpenseRequest dto) {
        Expense expense = Expense.builder()
                .date(dto.getDate())
                .value(dto.getValue())
                .user(userService.getCurrentUser())
                .build();

        repository.save(expense);
    }
}
