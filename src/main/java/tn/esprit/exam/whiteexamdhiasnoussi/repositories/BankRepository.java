package tn.esprit.exam.whiteexamdhiasnoussi.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Bank;

public interface BankRepository extends CrudRepository<Bank, Long> {

    Bank getBankByAgence(String agence);
}
