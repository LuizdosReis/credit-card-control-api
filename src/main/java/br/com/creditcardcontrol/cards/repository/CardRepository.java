package br.com.creditcardcontrol.cards.repository;

import br.com.creditcardcontrol.cards.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
}
