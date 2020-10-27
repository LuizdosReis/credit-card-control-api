package br.com.creditcardcontrol.expenses.mapper;

import br.com.creditcardcontrol.expenses.dto.InstallmentRequest;
import br.com.creditcardcontrol.expenses.model.Installment;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface InstallmentMapper {

    Set<Installment> map(Set<InstallmentRequest> installmentRequests);
}
