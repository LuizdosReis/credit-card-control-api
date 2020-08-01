package br.com.creditcardcontrol.expenses.mapper;

import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import br.com.creditcardcontrol.expenses.model.Expense;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    ExpenseResponse mapToDto(Expense expense);
}
