package tn.esprit.springproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.repositories.FoyerRepository;
import tn.esprit.springproject.repositories.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{

    private final UniversiteRepository universiteRepository;

    private final FoyerRepository foyerRepository;
    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> retrieveAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retrieveUniversiteById(long idE) {
        return universiteRepository.findById(idE).orElse(null);
    }

    @Override
    public void deleteUniversite(long idE) {
            universiteRepository.deleteById(idE);
        }

    @Override
    public Universite AffecterFoyer(long idF, long idU) {
        Foyer foyer=foyerRepository.findById(idF).orElse(null);
        Universite universite= universiteRepository.findById(idU).orElse(null);
            universite.setFoyer(foyer);

        return universiteRepository.save(universite);

    }
    @Override
    public Universite DesffecterFoyer(long idU) {
        Universite universite= universiteRepository.findById(idU).orElse(null);
        universite.setFoyer(null);

        return universiteRepository.save(universite);
    }

}
