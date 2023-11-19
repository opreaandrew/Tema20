package ro.fasttrackit.Tema20.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.Tema20.model.Transaction;
import ro.fasttrackit.Tema20.model.TransactionType;
import ro.fasttrackit.Tema20.service.TransactionService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;

    @GetMapping             //OK
    List<Transaction> getAll(){
        return service.getAllTransactions();
    }

    @GetMapping("/filter")  //Crapat
    List<Transaction> getByFilter(
            @RequestParam(name = "product", required = false) String product,
            @RequestParam(name = "type", required = false) TransactionType type,
            @RequestParam(name = "minAmount", required = false) Double minAmount,
            @RequestParam(name = "maxAmount", required = false) Double maxAmount) {
        return service.getFilteredTransactions(product, type, minAmount, maxAmount);
    }

    @GetMapping("/{id}")    //OK
    Transaction getById(@PathVariable Integer id) {
        return service.getTransactionById(id);
    }

    @PostMapping            //OK
    Transaction postTransaction(@RequestBody Transaction add) {
        return service.addTransaction(add);
    }

    @PutMapping("{id}")     //OK
    Transaction replaceTransaction(@PathVariable Integer id, @RequestBody Transaction transaction) {
        return service.replaceTransaction(id, transaction);
    }

    @DeleteMapping("{id}")  //OK
    Transaction deleteTransaction(@PathVariable Integer id) {
        return service.deleteTransaction(id);
    }

    @GetMapping("/reports/type")
    Map<TransactionType, List<Transaction>> filterByType(){
        return service.filterByType();
    }

    @GetMapping("/reports/product")
    Map<String, List<Transaction>> filterByProduct(){
        return service.filterByProduct();
    }
}
