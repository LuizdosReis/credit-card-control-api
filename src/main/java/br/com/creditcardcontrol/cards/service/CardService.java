package br.com.creditcardcontrol.cards.service;

import br.com.creditcardcontrol.cards.dto.CardResponse;
import br.com.creditcardcontrol.cards.dto.CardSaveRequest;

import java.util.Set;

public interface CardService {

    CardResponse save(CardSaveRequest dto);

    Set<CardResponse> getAll();
}
