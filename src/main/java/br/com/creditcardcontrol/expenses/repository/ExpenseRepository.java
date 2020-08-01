package br.com.creditcardcontrol.expenses.repository;

import br.com.creditcardcontrol.expenses.model.Expense;
import br.com.creditcardcontrol.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    Page<Expense> findAllByUser(User currentUser, Pageable page);
}
