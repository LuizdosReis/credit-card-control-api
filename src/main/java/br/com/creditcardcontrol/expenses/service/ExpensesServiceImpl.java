package br.com.creditcardcontrol.expenses.service;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import br.com.creditcardcontrol.expenses.model.Expense;
import br.com.creditcardcontrol.expenses.repository.ExpenseRepository;
import br.com.creditcardcontrol.user.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
@Slf4j
public class ExpensesServiceImpl implements ExpensesService {

    UserService userService;
    ExpenseRepository repository;

    @Override
    @Transactional
    public ExpenseResponse save(ExpenseRequest dto) {
        Expense expense = Expense.builder()
                .date(dto.getDate())
                .value(dto.getValue())
                .user(userService.getCurrentUser())
                .build();

        Expense expenseSaved = repository.save(expense);

        return mapToExpenseResponse(expenseSaved);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ExpenseResponse> getAll(Pageable page) {
        return repository.findAllByUser(userService.getCurrentUser(), page)
                .map(this::mapToExpenseResponse);
    }

    private ExpenseResponse mapToExpenseResponse(Expense expense) {
        return ExpenseResponse.builder()
                .id(expense.getId())
                .date(expense.getDate())
                .value(expense.getValue())
                .build();
    }


}
