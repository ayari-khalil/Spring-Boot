package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.repositories.FoyerRepository;
import tn.esprit.springproject.repositories.UniversiteRepository;

import java.util.HashSet;
import java.util.List;
@AllArgsConstructor
@Service
@Slf4j
public class FoyerServiceImp implements IFoyerService{
    private FoyerRepository foyerRepository;
    private UniversiteRepository universiteRepository;
    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);

    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> retrieveAllFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyerById(long idF) {
        return foyerRepository.findById(idF).orElse(null);
    }

    @Override
    public void deleteFoyer(long idF) {
        foyerRepository.deleteById(idF);

    }

    @Override
    public Foyer addFoyerAndAffectToUniversity(Foyer foyer, Long idU) {
        Universite universite = universiteRepository.findById(idU).orElse(null);

        if (foyer.getBlocs() != null) {
            for (Bloc bloc : foyer.getBlocs()) {
                bloc.setFoyer(foyer);
                System.out.println(bloc);
            }
        } else {
            // Initialiser les blocs si nécessaire
            foyer.setBlocs(new HashSet<>());
        }

        Foyer savedFoyer = foyerRepository.save(foyer);
        foyer.setUniversite(universite);
        if (universite != null) {
            universite.setFoyer(savedFoyer);
            universiteRepository.save(universite);
        }

        return savedFoyer;
    }

    @Override
    public Foyer getFoyerByNom(String nomF) {
        return foyerRepository.findByNomF(nomF);
    }
}
