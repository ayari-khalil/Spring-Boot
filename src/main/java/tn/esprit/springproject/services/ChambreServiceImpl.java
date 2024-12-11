package tn.esprit.springproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Chambre;
import tn.esprit.springproject.entities.TypeChambre;
import tn.esprit.springproject.repositories.BlocRepository;
import tn.esprit.springproject.repositories.ChambreRepository;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ChambreServiceImpl implements IChambreService{
    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private BlocRepository blocRepository;


    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> retrieveAllChambre() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambreById(long idC) {
        return chambreRepository.findById(idC).orElse(null);
    }

    @Override
    public void deleteChambre(long idC) {
        chambreRepository.deleteById(idC);

    }

    @Override
    public Bloc affecterChambreABloc(List<Long> numC, long idB) {
        List<Chambre> chambres=chambreRepository.findAllById(numC);
        Bloc bloc=blocRepository.findById(idB).orElse(null);
        for(Chambre chambre:chambres){
            chambre.setBloc(bloc);
        }
        chambreRepository.saveAll(chambres);


        return bloc;
    }

    @Override
    public List<Chambre> getChambreByBloc_IdBAndTypeC(Long idB, TypeChambre typeChambre) {
        return chambreRepository.getChambreByBloc_IdBAndTypeC(idB,typeChambre);
    }
}
