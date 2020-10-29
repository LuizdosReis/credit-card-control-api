package br.com.creditcardcontrol.expenses.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class InstallmentUpdateRequest {

    private Long id;
    private ZonedDateTime date;
    private BigDecimal value;
}
