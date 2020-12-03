package br.com.creditcardcontrol.cards.service;

import br.com.creditcardcontrol.cards.dto.CardResponse;
import br.com.creditcardcontrol.cards.dto.CardSaveRequest;
import br.com.creditcardcontrol.cards.mapper.CardMapper;
import br.com.creditcardcontrol.cards.model.Card;
import br.com.creditcardcontrol.cards.repository.CardRepository;
import br.com.creditcardcontrol.user.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {

    private final UserService userService;
    private final CardRepository repository;
    private final CardMapper cardMapper;


    @Override
    public CardResponse save(CardSaveRequest dto) {
        Card card = cardMapper.toEntity(dto, userService.getCurrentUser());

        repository.save(card);

        return cardMapper.toDto(card);
    }

    @Override
    public Set<CardResponse> getAll() {
        return repository
                .findAll()
                .stream()
                .map(cardMapper::toDto)
                .collect(Collectors.toSet());
    }
}
