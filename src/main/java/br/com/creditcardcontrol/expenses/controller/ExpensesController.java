package br.com.creditcardcontrol.expenses.controller;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import br.com.creditcardcontrol.expenses.service.ExpensesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ExpensesController.BASE_URL)
@AllArgsConstructor
@Slf4j
public class ExpensesController {

    public static final String BASE_URL = "/expenses";
    private final ExpensesService service;


    @PostMapping
    public ResponseEntity<ExpenseResponse> create(@RequestBody ExpenseRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dto));
    }
}
