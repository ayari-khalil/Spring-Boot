package tn.esprit.springproject.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Chambre;
import tn.esprit.springproject.entities.TypeChambre;
import tn.esprit.springproject.services.IChambreService;

import java.util.List;

@RestController
public class ChambreRestController {
    @Autowired
    private IChambreService iChambreService;

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return iChambreService.addChambre( chambre);
    }


/*
    @PutMapping("/updateChambre")
    public Chambre updateChambre(@RequestBody Chambre Chambre) {
        return iChambreService.updateChambre(Chambre);
    }*/

    @PutMapping("/updateChambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        Chambre et = iChambreService.retrieveChambreById(chambre.getIdC());


        if (chambre.getBloc() != null) {
            et.setBloc(chambre.getBloc());
        }
        if (chambre.getNumC() != null) {
            et.setNumC(chambre.getNumC());
        }
        if (chambre.getReservations() != null) {
            et.setReservations(chambre.getReservations());
        }
        if (chambre.getTypeC() != null) {
            et.setTypeC(chambre.getTypeC());
        }


        return iChambreService.updateChambre(et);
    }

    @GetMapping("/retrieveAllChambre")
    public List<Chambre> retrieveAllChambre() {
        return iChambreService.retrieveAllChambre();
    }


    @GetMapping("/retrieveChambreById/{idC}")

    public Chambre retrieveChambreById(@PathVariable long idC) {
        return iChambreService.retrieveChambreById(idC);
    }

    @DeleteMapping("/deleteChambre/{idC}")
    public void deleteChambre(@PathVariable long idC) {
        iChambreService.deleteChambre(idC);
    }

    @PostMapping("/affecterBloc/{idB}")
    public Bloc affecterChambreABloc(@RequestBody List<Long> numC, @PathVariable long idB)
    {
        return iChambreService.affecterChambreABloc(numC,idB);
    }

    @GetMapping("/getChambreByIDBlockType/{idB}/{typeChambre}")
    public List<Chambre> getChambreByIDBlockType(@PathVariable Long idB,@PathVariable TypeChambre typeChambre) {

        return iChambreService.getChambreByBloc_IdBAndTypeC(idB,typeChambre);
    }
    }
