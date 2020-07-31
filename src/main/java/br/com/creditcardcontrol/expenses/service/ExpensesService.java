package br.com.creditcardcontrol.expenses.service;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;

public interface ExpensesService {

    void save(ExpenseRequest dto);
}
