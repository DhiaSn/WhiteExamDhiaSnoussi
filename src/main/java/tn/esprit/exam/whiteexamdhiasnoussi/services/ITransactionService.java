package tn.esprit.exam.whiteexamdhiasnoussi.services;

import tn.esprit.exam.whiteexamdhiasnoussi.entities.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> retrieveAllTransactions();

    Transaction addTransaction(Transaction c, long expediteurId, long destinataireId);

    Transaction updateTransaction(Transaction c);

    Transaction retrieveTransaction(Long c);

    void removeTransaction(Long id);
    public String ajouterVirement(Transaction transaction);
}
