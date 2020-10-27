package br.com.creditcardcontrol.expenses.mapper;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import br.com.creditcardcontrol.expenses.model.Expense;
import br.com.creditcardcontrol.user.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = InstallmentMapper.class)
public abstract class ExpenseMapper {

    public abstract ExpenseResponse mapToDto(Expense expense);

    public abstract void merge(@MappingTarget Expense expense, ExpenseRequest source);

    @AfterMapping
    void fillInstalments(@MappingTarget Expense expense, ExpenseRequest source) {
        expense.getInstallments().forEach(installment -> installment.setExpense(expense));
    }

    @Mapping(target = "id", ignore = true)
    public abstract Expense toEntity(ExpenseRequest dto, User user);

}
