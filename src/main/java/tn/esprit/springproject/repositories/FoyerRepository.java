package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Foyer;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    Foyer findByNomF(String nomF);
}
