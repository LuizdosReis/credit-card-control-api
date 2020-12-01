package br.com.creditcardcontrol.expenses.model;



import br.com.creditcardcontrol.user.model.User;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity
@Immutable
@Table(name = "view_expenses_and_installments")
public class ExpenseInstalmentView {


    @Id
    private Long expenseId;

    private ZonedDateTime date;

    private BigDecimal value;

    @ManyToOne
    private User user;

}
