package tn.esprit.springproject.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.EtudiantRepository;
import tn.esprit.springproject.services.IEtudiantService;

import java.util.List;

@RestController
public class EtudiantRestController {

    @Autowired
    private IEtudiantService iEtudiantService;

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return iEtudiantService.addEtudiant( etudiant);
    }

/*
    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return iEtudiantService.updateEtudiant(etudiant);
    }*/

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
    }

    @GetMapping("/retrieveAllEtudiant")
    public List<Etudiant> retrieveAllEtudiant() {
        return iEtudiantService.retrieveAllEtudiant();
    }


    @GetMapping("/retrieveEtudiantById/{idE}")

    public Etudiant retrieveEtudiantById(@PathVariable long idE) {
        return iEtudiantService.retrieveEtudiantById(idE);
    }

    @DeleteMapping("/deleteEtudiant/{idE}")
    public void deleteEtudiant(@PathVariable long idE) {
        iEtudiantService.deleteEtudiant(idE);
    }
}
