package br.com.creditcardcontrol.expenses.controller;

import br.com.creditcardcontrol.expenses.dto.ExpenseRequest;
import br.com.creditcardcontrol.expenses.dto.ExpenseResponse;
import br.com.creditcardcontrol.expenses.service.ExpensesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping(path = ExpensesController.BASE_URL)
@AllArgsConstructor
@Slf4j
public class ExpensesController {

    public static final String BASE_URL = "/expenses";
    private final ExpensesService service;


    @PostMapping
    public ResponseEntity<List<ExpenseResponse>> create(@RequestBody List<ExpenseRequest> dtoList) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dtoList));
    }

    @GetMapping
    public ResponseEntity<Page<ExpenseResponse>> getAll(YearMonth yearMonth, Pageable page) {
        return ResponseEntity.ok(this.service.getAll(yearMonth, page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponse> getBy(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getBy(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseResponse> updateBy(@PathVariable Long id, @RequestBody ExpenseRequest dto) {
        return ResponseEntity.ok(this.service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBy(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }
}
