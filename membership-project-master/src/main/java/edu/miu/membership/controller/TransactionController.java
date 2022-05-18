package edu.miu.membership.controller;


import edu.miu.membership.domain.Location;
import edu.miu.membership.domain.Transaction;
import edu.miu.membership.exception.custom.EntityNotFoundException;
import edu.miu.membership.service.LocationService;
import edu.miu.membership.service.TransactionService;
import edu.miu.membership.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miu/transactions")
public class TransactionController {

    private TransactionServiceImpl transactionServiceImpl;

    @Autowired
    TransactionController(TransactionServiceImpl transactionServiceImpl){
        this.transactionServiceImpl = transactionServiceImpl;
    }

    @GetMapping()
    public List<Transaction> findAll(){
        return transactionServiceImpl.findAll();
    }

    @PostMapping()
    public Transaction save(@RequestBody Transaction transaction){
        return transactionServiceImpl.save(transaction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable Long id){
        Transaction transaction = transactionServiceImpl.getById(id).orElseThrow(()-> new EntityNotFoundException(String.format("Id  %s doesnt  exist ",id)));
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        transactionServiceImpl.deleteById(id);
        return new ResponseEntity<>("Transaction deleted ", HttpStatus.OK);
    }
}
