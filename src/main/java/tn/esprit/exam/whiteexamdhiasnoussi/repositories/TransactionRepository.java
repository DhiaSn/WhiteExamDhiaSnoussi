package tn.esprit.exam.whiteexamdhiasnoussi.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
