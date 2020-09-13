package br.com.creditcardcontrol.expenses.service;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import br.com.creditcardcontrol.expenses.mapper.ExpenseMapper;
import br.com.creditcardcontrol.expenses.model.Expense;
import br.com.creditcardcontrol.expenses.repository.ExpenseRepository;
import br.com.creditcardcontrol.user.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.YearMonth;


@Service
@AllArgsConstructor
@Slf4j
public class ExpensesServiceImpl implements ExpensesService {

    private final UserService userService;
    private final ExpenseRepository repository;
    private final ExpenseMapper expenseMapper;

    @Override
    @Transactional
    public ExpenseResponse save(ExpenseRequest dto) {
        Expense expense = expenseMapper.mapToModel(dto, userService.getCurrentUser());

        Expense expenseSaved = repository.save(expense);

        return expenseMapper.mapToDto(expenseSaved);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ExpenseResponse> getAll(YearMonth yearMonth, Pageable page) {
        return repository.findAllByUser(userService.getCurrentUser(), yearMonth.getMonth().getValue(), yearMonth.getYear(), page)
                .map(expenseMapper::mapToDto);
    }

    @Override
    public ExpenseResponse getBy(Long id) {
        Expense expense = repository.findByIdAndUser(id, userService.getCurrentUser())
                .orElseThrow(() -> new RuntimeException("No expense found with ID - " + id));
        return expenseMapper.mapToDto(expense);
    }

    @Override
    @Transactional
    public ExpenseResponse update(Long id, ExpenseRequest dto) {
        Expense expense = repository.findByIdAndUser(id, userService.getCurrentUser())
                .orElseThrow(() -> new RuntimeException("No expense found with ID - " + id));

        expenseMapper.merge(expense, dto);

        return expenseMapper.mapToDto(expense);
    }

    @Override
    public void delete(Long id) {
        Expense expense = repository.findByIdAndUser(id, userService.getCurrentUser())
                .orElseThrow(() -> new RuntimeException("No expense found with ID - " + id));

        repository.delete(expense);
    }
}
