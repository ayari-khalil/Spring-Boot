package tn.esprit.springproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.repositories.BlocRepository;
import tn.esprit.springproject.repositories.FoyerRepository;

import java.util.List;

@Service
@Slf4j
public class BlocServiceImpl implements IBlocService{

    @Autowired
    private BlocRepository blocRepository;

    @Autowired
    private FoyerRepository foyerRepository;

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> retrieveAllBloc() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBlocById(long idE) {
        return blocRepository.findById(idE).orElse(null);
    }

    @Override
    public void deleteBloc(long idE) {

        blocRepository.deleteById(idE);
    }

    @Override
    public Bloc affecterBlocAFoyer(long idB, long idF) {
        Bloc bloc=blocRepository.findById(idB).orElse(null);
        Foyer foyer=foyerRepository.findById(idF).orElse(null);
        bloc.setFoyer(foyer);

        return blocRepository.save(bloc);
    }

    @Override
    public Bloc getBlocByCapacite(Long capaciteB) {
        return blocRepository.getBlocByCapacite(capaciteB);
    }
}
