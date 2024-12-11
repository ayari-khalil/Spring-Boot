package tn.esprit.springproject.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Etudiant;

import java.util.List;

public interface IBlocService {
    public Bloc addBloc(Bloc bloc);
    public Bloc updateBloc(Bloc bloc);
    public List<Bloc> retrieveAllBloc();
    public Bloc retrieveBlocById(long idE);
    public void deleteBloc(long idE);
    public Bloc affecterBlocAFoyer(long idB,long idF);
    public Bloc getBlocByCapacite(Long capaciteB);

}
