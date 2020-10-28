package br.com.creditcardcontrol.expenses.repository;

import br.com.creditcardcontrol.expenses.model.ExpenseInstalmentView;
import br.com.creditcardcontrol.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseInstalmentViewRepository extends JpaRepository<ExpenseInstalmentView,Long> {

    @Query("select e from ExpenseInstalmentView e where e.user = ?1 and month(e.date) = ?2 and year(e.date) = ?3")
    Page<ExpenseInstalmentView> findAllByUser(User currentUser, int month, int year, Pageable page);
}
