package br.com.creditcardcontrol.expenses.repository;

import br.com.creditcardcontrol.expenses.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
