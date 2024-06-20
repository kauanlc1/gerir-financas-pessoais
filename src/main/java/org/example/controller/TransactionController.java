package org.example.controller;

import org.example.model.Transaction;
import org.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/rescue")
    public ResponseEntity<?> getAllTransaction() {
        List<Transaction> transactionsList = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactionsList);
    }

    @GetMapping("/rescue/{id}")
    public ResponseEntity<?> getOneTransaction(@PathVariable(value = "id") Long id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);
        if (transaction.isPresent()) {
            return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeTransactionById(@PathVariable(value = "id") Long id) {
        if (!transactionService.removeById(id)) {
            return new ResponseEntity<>("Ocorreu um erro ao solicitar a remoção da transação com o ID " + id + ".", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("Remoção de transação com o ID " + id + " concluída com sucesso.");
    }
}
