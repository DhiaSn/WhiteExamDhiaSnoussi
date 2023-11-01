package tn.esprit.exam.whiteexamdhiasnoussi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.whiteexamdhiasnoussi.entities.Bank;
import tn.esprit.exam.whiteexamdhiasnoussi.services.IBankService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Bank")
public class BankController {
    IBankService _bankServ;
    @GetMapping("/")
    @ResponseBody
    public List<Bank> getBanks() {
        return _bankServ.retrieveAllBanks();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Bank getBankById(@PathVariable long id) {
        return _bankServ.retrieveBank(id);
    }

    @PostMapping("/")
    @ResponseBody
    public Bank postBank(@RequestBody Bank c) {
        if(c == null)
            return null;
        return _bankServ.addBank(c);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Bank putBank(@PathVariable long id, @RequestBody Bank c) {
        if(c == null || id != c.getIdBank())
            return  null;
        return _bankServ.updateBank(c);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteBank(@PathVariable long id) {
        _bankServ.removeBank(id);
    }
}
