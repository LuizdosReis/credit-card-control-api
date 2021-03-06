package br.com.creditcardcontrol.expenses.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponse {

    private Long id;
    private ZonedDateTime date;
    private BigDecimal value;
    private Set<InstallmentResponse> installments;
}
