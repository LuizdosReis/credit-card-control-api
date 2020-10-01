package br.com.creditcardcontrol.chart.services;

import br.com.creditcardcontrol.chart.dto.Data;
import br.com.creditcardcontrol.chart.dto.Serie;
import br.com.creditcardcontrol.expenses.service.ExpensesService;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ChartServiceImpl implements ChartService {

    private final ExpensesService expensesService;


    @Override
    public Serie getSerie(YearMonth yearMonth) {
        Set<Data> expenseSerie = expensesService.getExpenseData(yearMonth);

        Serie serie = new Serie();
        serie.setExpenses(getExpenseMonth(expenseSerie, yearMonth));
        serie.setExpenseGoals(getExpenseGoals(yearMonth));

        return serie;
    }

    private List<Data> getExpenseMonth(Set<Data> expenseSerie, YearMonth yearMonth) {

        Set<Data> expenseBugetMonth = new HashSet<>();

        Integer lastDayInSerie = expenseSerie.stream()
                .map(Data::getDay)
                .max(Integer::compare)
                .orElse(1);

        int lengthOfMonth = getLengthOfMonth(yearMonth, lastDayInSerie);

        expenseBugetMonth.add(findBy(1, expenseSerie));

        for(int i = 2; i <= lengthOfMonth; i++) {
            Data previousData = findBy(i - 1, expenseBugetMonth);

            Data data = findBy(i, expenseSerie);

            expenseBugetMonth.add(new Data(i, previousData.getSum().add(data.getSum())));
        }

        return expenseBugetMonth.stream().sorted(Comparator.comparingInt(Data::getDay)).collect(Collectors.toList());
    }

    private Data findBy(int day, Set<Data> expenseSerie){
        return expenseSerie.stream()
                .filter(expenseData -> expenseData.getDay().equals(day)).findFirst()
                .orElse(new Data(day, BigDecimal.ZERO));
    }

    private int getLengthOfMonth(YearMonth yearMonth, Integer lastDayInSerie) {
        YearMonth now = YearMonth.now();

        if(now.compareTo(yearMonth) == 0) {
            return LocalDate.now().getDayOfMonth();
        }

        if(now.isBefore(yearMonth)) {
            return lastDayInSerie;
        }

        return yearMonth.lengthOfMonth();
    }

    private List<Data> getExpenseGoals(YearMonth yearMonth) {
        Set<Data> expenseGoal = Sets.newHashSet();

        int lengthOfMonth = yearMonth.lengthOfMonth();

        BigDecimal monthlyGoal = new BigDecimal("2392.6");

        BigDecimal dailyGoal = monthlyGoal.divide(new BigDecimal(lengthOfMonth), 2, RoundingMode.HALF_UP);

        for(int i = 1; i <= lengthOfMonth; i++) {
            Data previousData = findBy(i - 1, expenseGoal);

            expenseGoal.add(new Data(i, previousData.getSum().add(dailyGoal)));
        }

        return expenseGoal.stream().sorted(Comparator.comparingInt(Data::getDay)).collect(Collectors.toList());
    }




}
