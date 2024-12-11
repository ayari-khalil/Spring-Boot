package tn.esprit.springproject.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.services.FoyerServiceImp;
import tn.esprit.springproject.services.IFoyerService;

import java.util.List;

@AllArgsConstructor
@RestController

public class FoyerRestController {
    private IFoyerService iFoyerService;


    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f){
    return iFoyerService.addFoyer(f);
    }

    @PutMapping("/updateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {

        return iFoyerService.updateFoyer(foyer);
    }

    @GetMapping("/retrieveAllFoyer")
    public List<Foyer> retrieveAllFoyer() {
        return iFoyerService.retrieveAllFoyer();

    }

    @GetMapping("/retrieveFoyerById/{idF}")
    public Foyer retrieveFoyerById(@PathVariable long idF) {
        return iFoyerService.retrieveFoyerById(idF);

    }

    @DeleteMapping("/deleteFoyer/{idF}")
    public void deleteFoyer(@PathVariable long idF) {
        iFoyerService.deleteFoyer(idF);


    }

    @PostMapping("/addFoyerAndAffectToUniversity/{idU}")
    public Foyer addFoyerAndAffectToUniversity(@RequestBody Foyer foyer,@PathVariable Long idU) {
        return iFoyerService.addFoyerAndAffectToUniversity(foyer,idU);

    }

    @GetMapping("/getFoyerByNom/{nomF}")
    public Foyer getFoyerByNom(@PathVariable String nomF){
        return iFoyerService.getFoyerByNom(nomF);
    }
    }
