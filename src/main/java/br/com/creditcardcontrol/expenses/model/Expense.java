package br.com.creditcardcontrol.expenses.model;


import br.com.creditcardcontrol.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "expenses")
public class Expense {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private ZonedDateTime date;

    @NotNull
    @Digits(fraction=2, integer = 9)
    private BigDecimal value;

    @NotNull
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Installment> installments;

    public static ExpenseBuilder builder() {
        return new ExpenseBuilder() {

            @Override
            public Expense build() {
                Expense expense = super.build();

                if(expense.getInstallments() != null) {
                    expense.getInstallments().forEach(installment -> installment.setExpense(expense));
                }
                return expense;
            }
        };
    }
}
