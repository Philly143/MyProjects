package edu.miu.membership.service;

import edu.miu.membership.domain.Location;
import edu.miu.membership.domain.Transaction;

import java.util.List;
import java.util.Optional;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */


public interface TransactionService {

    List<Transaction> findAll();

    Transaction save(Transaction transaction);

    Optional<Transaction> getById(Long id);

    void deleteById(Long id);
}
