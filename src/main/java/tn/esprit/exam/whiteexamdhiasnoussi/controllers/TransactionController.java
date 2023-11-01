package tn.esprit.exam.whiteexamdhiasnoussi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Transaction;
import tn.esprit.exam.whiteexamdhiasnoussi.services.ITransactionService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Transaction")
public class TransactionController {

    ITransactionService _transactionServ;
    @GetMapping("/")
    @ResponseBody
    public List<Transaction> getTransactions() {
        return _transactionServ.retrieveAllTransactions();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Transaction getTransactionById(@PathVariable long id) {
        return _transactionServ.retrieveTransaction(id);
    }

    @PostMapping("/{expediteurId}/{destinataireId}")
    @ResponseBody
    public Transaction postTransaction(@RequestBody Transaction c,@PathVariable long expediteurId,@PathVariable long destinataireId ) {
        if(c == null)
            return null;
        return _transactionServ.addTransaction(c,expediteurId,destinataireId);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Transaction putTransaction(@PathVariable long id, @RequestBody Transaction c) {
        if(c == null || id != c.getIdTransaction())
            return  null;
        return _transactionServ.updateTransaction(c);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteTransaction(@PathVariable long id) {
        _transactionServ.removeTransaction(id);
    }

    @PostMapping("/Virement")
    @ResponseBody
    public String ajouterVirement(@PathVariable Transaction transaction){
        return  _transactionServ.ajouterVirement(transaction);
    }
}
