package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public Etudiant addEtudiant(Etudiant etudiant);
    public Etudiant updateEtudiant(Etudiant etudiant);
    public List<Etudiant> retrieveAllEtudiant();
    public Etudiant retrieveEtudiantById(long idE);
    public void deleteEtudiant(long idE);

}

