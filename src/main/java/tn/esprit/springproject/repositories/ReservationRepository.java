package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {

    public Long countByAnneUniversitaireBetween(LocalDate dateDebut, LocalDate dateFin);

    List<Reservation> findByDateDebutBefore(LocalDate date);
}
