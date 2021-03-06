package br.com.creditcardcontrol.expenses.repository;

import br.com.creditcardcontrol.expenses.model.Expense;
import br.com.creditcardcontrol.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    @Query("select e from Expense e where e.user = ?1 and month(e.date) = ?2 and year(e.date) = ?3")
    Page<Expense> findAllByUser(User currentUser, int month, int year, Pageable page);

    Optional<Expense> findByIdAndUser(Long id, User currentUser);
}
