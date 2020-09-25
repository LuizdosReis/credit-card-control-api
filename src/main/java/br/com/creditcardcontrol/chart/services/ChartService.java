package br.com.creditcardcontrol.chart.services;

import br.com.creditcardcontrol.chart.dto.Serie;

import java.time.YearMonth;

public interface ChartService {
    Serie getSerie(YearMonth yearMonth);
}
