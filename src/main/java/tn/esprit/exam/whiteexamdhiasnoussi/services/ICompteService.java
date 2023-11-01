package tn.esprit.exam.whiteexamdhiasnoussi.services;

import tn.esprit.exam.whiteexamdhiasnoussi.entities.Compte;

import java.util.List;

public interface ICompteService {
    List<Compte> retrieveAllComptes();

    Compte addCompte(Compte c);

    Compte updateCompte(Compte c);

    Compte retrieveCompte(Long c);

    void removeCompte(Long id);

    public Compte ajouterCompteEtAffecterAgence(Compte compte, String agenceBank);

}
