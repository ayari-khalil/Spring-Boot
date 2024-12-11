package tn.esprit.springproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.EtudiantRepository;

import java.util.List;

@Service
public class EtudiantServiceImpl implements IEtudiantService{

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> retrieveAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant retrieveEtudiantById(long idE) {
        return etudiantRepository.findById(idE).orElse(null);
    }

    @Override
    public void deleteEtudiant(long idE) {
        etudiantRepository.deleteById(idE);
    }
}
