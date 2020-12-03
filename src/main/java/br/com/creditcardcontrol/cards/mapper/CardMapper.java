package br.com.creditcardcontrol.cards.mapper;

import br.com.creditcardcontrol.cards.dto.CardResponse;
import br.com.creditcardcontrol.cards.dto.CardSaveRequest;
import br.com.creditcardcontrol.cards.model.Card;
import br.com.creditcardcontrol.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    Card toEntity(CardSaveRequest dto, User user);

    CardResponse toDto(Card card);
}
