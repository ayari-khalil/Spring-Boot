package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Universite;

import java.util.List;

public interface IUniversiteService {

    public Universite addUniversite(Universite universite);
    public Universite updateUniversite(Universite universite);
    public List<Universite> retrieveAllUniversite();
    public Universite retrieveUniversiteById(long idE);
    public void deleteUniversite(long idE);

    public Universite AffecterFoyer(long idF,long idU);
    public Universite DesffecterFoyer(long idU);



}
