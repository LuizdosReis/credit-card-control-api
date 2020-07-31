package br.com.creditcardcontrol.expenses.service;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;

public interface ExpensesService {

    ExpenseResponse save(ExpenseRequest dto);
}
