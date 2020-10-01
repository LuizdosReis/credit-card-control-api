package br.com.creditcardcontrol.expenses.service;

import br.com.creditcardcontrol.chart.dto.Data;
import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.YearMonth;
import java.util.Set;

public interface ExpensesService {

    ExpenseResponse save(ExpenseRequest dto);
    ExpenseResponse update(Long id, ExpenseRequest dto);
    Page<ExpenseResponse> getAll(YearMonth yearMonth, Pageable page);
    Set<Data> getExpenseData(YearMonth yearMonth);
    ExpenseResponse getBy(Long id);
    void delete(Long id);
}
