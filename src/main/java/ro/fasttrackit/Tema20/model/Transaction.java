package ro.fasttrackit.Tema20.model;

import lombok.Builder;
import lombok.With;

@Builder
@With
public record Transaction(
        long id,
        String product,
        TransactionType type,
        double amount
) {
}
