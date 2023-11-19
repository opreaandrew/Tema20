package ro.fasttrackit.Tema20.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.Tema20.model.Transaction;
import ro.fasttrackit.Tema20.model.TransactionType;
import ro.fasttrackit.Tema20.service.TransactionService;

import java.util.List;


@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;

    @GetMapping("{product}, {type}, {minAmount}, {maxAmount}")
    List<Transaction> getByFilter(@PathVariable String product
            , @PathVariable TransactionType type
            , @PathVariable Double minAmount
            , @PathVariable Double maxAmount) {
        return service.getFilteredTransactions(product, type, minAmount, maxAmount);
    }

    @GetMapping("{id}")
    Transaction getById(@PathVariable Integer id) {
        return service.getTransactionById(id);
    }

    @PostMapping("{add}")
    Transaction postTransaction(@PathVariable Transaction add) {
        return service.addTransaction(add);
    }

    @PutMapping("{id}, {transaction}")
    Transaction replaceTransaction(@PathVariable Integer id, @PathVariable Transaction transaction) {
        return service.replaceTransaction(id, transaction);
    }

    @DeleteMapping("{id}")
    Transaction deleteTransaction(@PathVariable Integer id) {
        return service.deleteTransaction(id);
    }
}
