package br.com.creditcardcontrol.expenses.mapper;

import br.com.creditcardcontrol.expenses.dto.ExpenseInstallmentResponse;
import br.com.creditcardcontrol.expenses.model.ExpenseInstalmentView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseInstallmentMapper {

    ExpenseInstallmentResponse toDto(ExpenseInstalmentView expenseInstalmentView);
}
