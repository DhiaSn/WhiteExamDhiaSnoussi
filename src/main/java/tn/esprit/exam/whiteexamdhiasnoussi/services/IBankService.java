package tn.esprit.exam.whiteexamdhiasnoussi.services;

import tn.esprit.exam.whiteexamdhiasnoussi.entities.Bank;

import java.util.List;

public interface IBankService {
    List<Bank> retrieveAllBanks();

    Bank addBank(Bank c);

    Bank updateBank(Bank c);

    Bank retrieveBank(Long c);

    void removeBank(Long id);
}
