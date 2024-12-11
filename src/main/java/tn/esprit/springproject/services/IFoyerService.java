package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    public Foyer addFoyer(Foyer foyer);
    public Foyer updateFoyer(Foyer foyer);
    public List<Foyer> retrieveAllFoyer();
    public Foyer retrieveFoyerById(long idF);
    public void deleteFoyer(long idF);
    public Foyer addFoyerAndAffectToUniversity(Foyer foyer,Long idU);
    public Foyer getFoyerByNom(String nomF);

}
