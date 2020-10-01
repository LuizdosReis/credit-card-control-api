package br.com.creditcardcontrol.chart.controller;


import br.com.creditcardcontrol.chart.dto.Serie;
import br.com.creditcardcontrol.chart.services.ChartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;

@RestController
@RequestMapping(path = ChartController.BASE_URL)
@AllArgsConstructor
@Slf4j
public class ChartController {
    public static final String BASE_URL = "/charts";
    private final ChartService service;

    @GetMapping("/line")
    public ResponseEntity<Serie> getAll(YearMonth yearMonth) {
        return ResponseEntity.ok(this.service.getSerie(yearMonth));
    }
}
