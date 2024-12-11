package tn.esprit.springproject.services;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Reservation;
import tn.esprit.springproject.repositories.ReservationRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ReservationServiceImpl implements IReservationService{
    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservationById(String idR) {
        return reservationRepository.findById(idR).orElse(null);
    }

    @Override
    public void deleteReservation(String idR) {
        reservationRepository.deleteById(idR);

    }
    @Override
    @Scheduled(fixedDelay = 500000) // 10000 millisecondes
    public List<Reservation> updateReservations() {
        LocalDate date;
        List<Reservation> listP = reservationRepository.findAll();
        for (Reservation c: listP) {
            LocalDate dateLimite = LocalDate.of(2024, 1, 1);
            List<Reservation> reservations = reservationRepository.findByDateDebutBefore(dateLimite);
            c.setEstValide(false);
            reservationRepository.save(c);

            log.info("Reservation :" + c);
        }
        return listP;
    }

    @Override
    public Long getReservationByDate(LocalDate dateDebut, LocalDate dateFin) {
        return reservationRepository.countByAnneUniversitaireBetween(dateDebut,dateFin);
    }
}
