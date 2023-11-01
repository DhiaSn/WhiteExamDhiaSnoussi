package tn.esprit.exam.whiteexamdhiasnoussi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Compte;
import tn.esprit.exam.whiteexamdhiasnoussi.services.ICompteService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Compte")
public class CompteController {

    ICompteService _compteServ;
    @GetMapping("/")
    @ResponseBody
    public List<Compte> getComptes() {
        return _compteServ.retrieveAllComptes();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Compte getCompteById(@PathVariable long id) {
        return _compteServ.retrieveCompte(id);
    }

    @PostMapping("/")
    @ResponseBody
    public Compte postCompte(@RequestBody Compte c) {
        if(c == null)
            return null;
        return _compteServ.addCompte(c);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Compte putCompte(@PathVariable long id, @RequestBody Compte c) {
        if(c == null || id != c.getIdCompte())
            return  null;
        return _compteServ.updateCompte(c);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteCompte(@PathVariable long id) {
        _compteServ.removeCompte(id);
    }

    @PostMapping("/ByBank/{agenceBank}")
    @ResponseBody
    public Compte ajouterCompteEtAffecterAgence(@RequestBody Compte compte,@PathVariable String agenceBank){
        return _compteServ.ajouterCompteEtAffecterAgence(compte, agenceBank);
    }
}
