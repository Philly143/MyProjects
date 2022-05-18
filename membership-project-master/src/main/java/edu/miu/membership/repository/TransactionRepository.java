package edu.miu.membership.repository;

import edu.miu.membership.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/17/22
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
