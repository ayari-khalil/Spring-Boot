package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReservationService {
    public Reservation addReservation(Reservation reservation);
    public Reservation updateReservation(Reservation reservation);

    public List<Reservation> updateReservations();

    public List<Reservation> retrieveAllReservation();
    public Reservation retrieveReservationById(String idR);
    public void deleteReservation(String idR);


    Long getReservationByDate(LocalDate dateDebut, LocalDate dateFin);
}
