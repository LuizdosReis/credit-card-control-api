package br.com.creditcardcontrol.expenses.mapper;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import br.com.creditcardcontrol.expenses.model.Expense;
import br.com.creditcardcontrol.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    ExpenseResponse mapToDto(Expense expense);
    
    @Mapping(target = "id", ignore = true)
    Expense mapToModel(ExpenseRequest dto, User user);
}
