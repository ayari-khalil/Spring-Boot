package tn.esprit.springproject.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.services.IUniversiteService;

import java.util.List;

@RestController
public class UniversiteRestController {

    @Autowired
    private IUniversiteService iUniversiteService;

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite universite) {

        return iUniversiteService.addUniversite( universite);
    }


    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return iUniversiteService.updateUniversite(universite);
    }
/*
    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant et = iEtudiantService.retrieveEtudiantById(etudiant.getIdE());


        if (etudiant.getNomEt() != null) {
            et.setNomEt(etudiant.getNomEt());
        }
        if (etudiant.getPrenomEt() != null) {
            et.setPrenomEt(etudiant.getPrenomEt());
        }
        if (etudiant.getCin() != null) {
            et.setCin(etudiant.getCin());
        }
        if (etudiant.getEcole() != null) {
            et.setEcole(etudiant.getEcole());
        }
        if (etudiant.getDateNaissance() != null) {
            et.setDateNaissance(etudiant.getDateNaissance());
        }

        return iEtudiantService.updateEtudiant(et);
    }*/

    @GetMapping("/retrieveAllUniversite")
    public List<Universite> retrieveAllUniversite() {
        return iUniversiteService.retrieveAllUniversite();
    }


    @GetMapping("/retrieveUniversiteById/{idE}")

    public Universite retrieveUniversiteById(@PathVariable long idE) {
        return iUniversiteService.retrieveUniversiteById(idE);
    }

    @DeleteMapping("/deleteUniversite/{idE}")
    public void deleteUniversite(@PathVariable long idE) {
        iUniversiteService.deleteUniversite(idE);
    }

    @PostMapping("/affecterFoyer/{idF}/{idU}")
    public Universite affecterFoyer(@PathVariable long idF,@PathVariable long idU){
        return iUniversiteService.AffecterFoyer(idF,idU);
    }

    @PostMapping("/desaffecterFoyer/{idU}")
    public Universite DesffecterFoyer(@PathVariable long idU) {
        return iUniversiteService.DesffecterFoyer(idU);
    }

    }


