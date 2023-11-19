package ro.fasttrackit.Tema20.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.Tema20.model.Transaction;
import ro.fasttrackit.Tema20.model.TransactionType;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private List<Transaction> transactions;
    private long currentId = 1L;

//    public List<Transaction> getAllTransactions() {
//        return transactions;
//    }

    public List<Transaction> getFilteredTransactions(String product, TransactionType type, Double minAmount, Double maxAmount) {
        return transactions.stream()
                .filter(filter -> filter.product().contains(product))
                .filter(filter -> filter.type() == type)
                .filter(filter -> filter.amount() >= minAmount)
                .filter(filter -> filter.amount() <= maxAmount)
                .toList();
    }

    public Transaction getTransactionById(long id) {
        return transactions.stream()
                .filter(filter -> filter.id() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No transaction with that ID"));
    }

    public Transaction addTransaction(Transaction trans) {
        Transaction newTransaction = trans.withId(currentId + 1);
        transactions.add(newTransaction);
        return newTransaction;
    }

    public Transaction replaceTransaction(int id, Transaction toAdd) {
        deleteTransaction(id);
        Transaction newTransaction = toAdd.withId(id);
        transactions.add(newTransaction);
        return newTransaction;
    }

    public Transaction deleteTransaction(int id) {
        Transaction oldTransaction = getTransactionById(id);
        transactions.remove(oldTransaction);
        return oldTransaction;
    }


}
