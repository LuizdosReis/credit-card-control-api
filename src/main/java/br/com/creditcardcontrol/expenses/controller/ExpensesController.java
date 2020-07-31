package br.com.creditcardcontrol.expenses.controller;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.service.ExpensesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ExpensesController.BASE_URL)
@AllArgsConstructor
@Slf4j
public class ExpensesController {

    public static final String BASE_URL = "/expenses";
    private final ExpensesService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ExpenseRequest dto) {
        this.service.save(dto);
    }
}
