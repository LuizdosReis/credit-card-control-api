package br.com.creditcardcontrol.expenses.service;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExpensesService {

    ExpenseResponse save(ExpenseRequest dto);
    Page<ExpenseResponse> getAll(Pageable page);
}
