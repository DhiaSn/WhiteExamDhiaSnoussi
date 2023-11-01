package tn.esprit.exam.whiteexamdhiasnoussi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Compte;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Enums.TypeCompte;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Enums.TypeTransaction;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Transaction;
import tn.esprit.exam.whiteexamdhiasnoussi.repositories.BankRepository;
import tn.esprit.exam.whiteexamdhiasnoussi.repositories.CompteRepository;
import tn.esprit.exam.whiteexamdhiasnoussi.repositories.TransactionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements ITransactionService{
    TransactionRepository _transactionRepo;
    CompteRepository _comptRepo;

    @Override
    public List<Transaction> retrieveAllTransactions() {
        return (List<Transaction>) _transactionRepo.findAll();
    }

    @Override
    public Transaction addTransaction(Transaction t, long expediteurId, long destinataireId) {

        if(t == null)
            return null;

        if(expediteurId != 0 && _comptRepo.existsById(expediteurId))
            t.setExpediteur(_comptRepo.findById(expediteurId).get());
        if(destinataireId != 0 && _comptRepo.existsById(destinataireId))
            t.setExpediteur(_comptRepo.findById(destinataireId).get());

        return _transactionRepo.save(t);
    }

    @Override
    public Transaction updateTransaction(Transaction c) {
        if(_transactionRepo.existsById(c.getIdTransaction()))
            return _transactionRepo.save(c);
        return null;
    }

    @Override
    public Transaction retrieveTransaction(Long id) {
        return _transactionRepo.findById(id).get();
    }

    @Override
    public void removeTransaction(Long id) {
        _transactionRepo.deleteById(id);
    }

    @Override
    public String ajouterVirement(Transaction transaction) {

        if(transaction == null)
            return  "sorry the transaction is null!";

        Compte exp = _comptRepo.findById(transaction.getExpediteur().getIdCompte()).get();

        if(transaction.getType() == TypeTransaction.Virement && exp.getType() == TypeCompte.Epargne)
        {
            return "On ne peut pas faire un virement à partir d’un compte épargne";

        }

        /*
        to:
        check sold
         */

        else if(transaction.getType() == TypeTransaction.Virement && exp.getType() == TypeCompte.Epargne)
        {
            return "On ne peut pas faire un virement : Solde insuffisant";
        }
        return null;
    }
}
