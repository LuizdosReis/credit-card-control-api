package br.com.creditcardcontrol.expenses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseUpdateRequest {

    private ZonedDateTime date;
    private BigDecimal value;
    private Set<InstallmentUpdateRequest> installments;
}
