package br.com.creditcardcontrol.expenses.service;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.YearMonth;

public interface ExpensesService {

    ExpenseResponse save(ExpenseRequest dto);
    ExpenseResponse update(Long id, ExpenseRequest dto);
    Page<ExpenseResponse> getAll(YearMonth yearMonth, Pageable page);
    ExpenseResponse getBy(Long id);
    void delete(Long id);
}
