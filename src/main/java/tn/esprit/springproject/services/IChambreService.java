package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Chambre;
import tn.esprit.springproject.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    public Chambre addChambre(Chambre chambre);
    public Chambre updateChambre(Chambre chambre);
    public List<Chambre> retrieveAllChambre();
    public Chambre retrieveChambreById(long idC);
    public void deleteChambre(long idC);

    public Bloc affecterChambreABloc(List<Long> numC, long idC);
    public List<Chambre> getChambreByBloc_IdBAndTypeC(Long idB, TypeChambre typeChambre);


}
