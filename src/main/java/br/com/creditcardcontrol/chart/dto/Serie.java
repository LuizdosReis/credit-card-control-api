package br.com.creditcardcontrol.chart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Serie {

    private List<Data> expenses;
    private List<Data> expenseGoals;
}
