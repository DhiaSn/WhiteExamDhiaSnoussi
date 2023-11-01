package tn.esprit.exam.whiteexamdhiasnoussi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Bank;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Compte;
import tn.esprit.exam.whiteexamdhiasnoussi.repositories.BankRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class BankServiceImpl implements IBankService{
    BankRepository _bankRepo;
    @Override
    public List<Bank> retrieveAllBanks() {
        return (List<Bank>) _bankRepo.findAll();
    }

    @Override
    public Bank addBank(Bank c) {
        return _bankRepo.save(c);
    }

    @Override
    public Bank updateBank(Bank c) {
        if(_bankRepo.existsById(c.getIdBank()))
            return _bankRepo.save(c);
        return null;
    }

    @Override
    public Bank retrieveBank(Long id) {
        return _bankRepo.findById(id).get();
    }

    @Override
    public void removeBank(Long id) {
        _bankRepo.deleteById(id);
    }
}
