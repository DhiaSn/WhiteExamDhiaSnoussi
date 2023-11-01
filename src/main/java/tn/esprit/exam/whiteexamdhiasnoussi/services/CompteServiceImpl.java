package tn.esprit.exam.whiteexamdhiasnoussi.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Bank;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Compte;
import tn.esprit.exam.whiteexamdhiasnoussi.repositories.BankRepository;
import tn.esprit.exam.whiteexamdhiasnoussi.repositories.CompteRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class CompteServiceImpl implements ICompteService{
    CompteRepository _compteRepo;
    BankRepository _bankRepo;

    @Override
    public List<Compte> retrieveAllComptes() {
        return (List<Compte>) _compteRepo.findAll();
    }

    @Override
    public Compte addCompte(Compte c) {
        return _compteRepo.save(c);
    }

    @Override
    public Compte updateCompte(Compte c) {
        if(_compteRepo.existsById(c.getIdCompte()))
            return _compteRepo.save(c);
        return null;
    }

    @Override
    public Compte retrieveCompte(Long id) {
        return _compteRepo.findById(id).get();
    }

    @Override
    public void removeCompte(Long id) {
        _compteRepo.deleteById(id);
    }

    @Override
    public Compte ajouterCompteEtAffecterAgence(Compte compte, String agenceBank) {

        Bank bank = _bankRepo.getBankByAgence(agenceBank);

        log.info("==> bankId: " + bank.getIdBank());

        if(bank == null)
            return  null;

        if(compte == null)
            return  null;

        Compte createdCompte = _compteRepo.save(compte);

        Set<Compte> comptes = new HashSet<Compte>();
        comptes.add(createdCompte);

        bank.setComptes(comptes);

        _bankRepo.save(bank);

        return createdCompte;

    }
}
