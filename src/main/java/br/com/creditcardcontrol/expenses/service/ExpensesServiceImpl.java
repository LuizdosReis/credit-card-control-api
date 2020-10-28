package br.com.creditcardcontrol.expenses.service;

import br.com.creditcardcontrol.chart.dto.Data;
import br.com.creditcardcontrol.expenses.dto.ExpenseInstallmentResponse;
import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import br.com.creditcardcontrol.expenses.mapper.ExpenseInstallmentMapper;
import br.com.creditcardcontrol.expenses.mapper.ExpenseMapper;
import br.com.creditcardcontrol.expenses.model.Expense;
import br.com.creditcardcontrol.expenses.model.Installment;
import br.com.creditcardcontrol.expenses.repository.ExpenseInstalmentViewRepository;
import br.com.creditcardcontrol.expenses.repository.ExpenseRepository;
import br.com.creditcardcontrol.user.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Set;


@Service
@AllArgsConstructor
@Slf4j
public class ExpensesServiceImpl implements ExpensesService {

    private final UserService userService;
    private final ExpenseRepository repository;
    private final ExpenseInstalmentViewRepository expenseInstalmentViewRepository;
    private final ExpenseMapper expenseMapper;
    private final ExpenseInstallmentMapper expenseInstallmentMapper;

    @Override
    @Transactional
    public ExpenseResponse save(ExpenseRequest dto) {
        Expense expense = expenseMapper.toEntity(dto, userService.getCurrentUser());

        verifyInstallmentValue(expense);

        Expense savedExpense = repository.save(expense);

        return expenseMapper.mapToDto(savedExpense);
    }

    private void verifyInstallmentValue(Expense expense){
        if(expense.getInstallments().isEmpty()) return;

        BigDecimal installmentTotalValue = expense.getInstallments().stream()
                .map(Installment::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (installmentTotalValue.compareTo(expense.getValue()) != 0 ) {
            throw new RuntimeException("Installments total values is not equals expense total value");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ExpenseInstallmentResponse> getAll(YearMonth yearMonth, Pageable page) {
        return expenseInstalmentViewRepository
                .findAllByUser(userService.getCurrentUser(), yearMonth.getMonth().getValue(), yearMonth.getYear(), page)
                .map(expenseInstallmentMapper::toDto);
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

    @Override
    public Set<Data> getExpenseData(YearMonth yearMonth) {
        return repository.findExpenseDataByUserAndYearMonth(
                userService.getCurrentUser(), yearMonth.getMonth().getValue(), yearMonth.getYear());
    }


}
