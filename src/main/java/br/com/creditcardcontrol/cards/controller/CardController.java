package br.com.creditcardcontrol.cards.controller;

import br.com.creditcardcontrol.cards.dto.CardResponse;
import br.com.creditcardcontrol.cards.dto.CardSaveRequest;
import br.com.creditcardcontrol.cards.service.CardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = CardController.BASE_URL)
@AllArgsConstructor
@Slf4j
public class CardController {

    static final String BASE_URL = "/cards";
    private final CardService service;

    @PostMapping
    public ResponseEntity<CardResponse> create(@RequestBody CardSaveRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dto));
    }

    @GetMapping
    public ResponseEntity<Set<CardResponse>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }
}
