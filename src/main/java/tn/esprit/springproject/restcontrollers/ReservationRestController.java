package tn.esprit.springproject.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Reservation;
import tn.esprit.springproject.services.IReservationService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class
ReservationRestController {
    @Autowired
    private IReservationService iReservationService;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return iReservationService.addReservation(reservation);
    }

/*
    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return iReservationService.updateReservation(reservation);
    }*/

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        Reservation et = iReservationService.retrieveReservationById(reservation.getIdR());


        if (reservation.getEtudiants() != null) {
            et.setEtudiants(reservation.getEtudiants());
        }
        if (reservation.getEstValide() != null) {
            et.setEstValide(reservation.getEstValide());
        }
        if (reservation.getAnneUniversitaire() != null) {
            et.setAnneUniversitaire(reservation.getAnneUniversitaire());
        }

        return iReservationService.updateReservation(et);
    }

    @GetMapping("/retrieveAllReservation")
    public List<Reservation> retrieveAllReservation() {
        return iReservationService.retrieveAllReservation();
    }


    @GetMapping("/retrieveReservationById/{idR}")

    public Reservation retrieveReservationById(@PathVariable String idR) {
        return iReservationService.retrieveReservationById(idR);
    }

    @DeleteMapping("/deleteReservation/{idR}")
    public void deleteReservation(@PathVariable String idR) {
        iReservationService.deleteReservation(idR);
    }


    @GetMapping("/getReservationByDate/{dateDebut}/{dateFin}")
    public Long getReservationByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateDebut, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFin) {
    return iReservationService.getReservationByDate(dateDebut,dateFin);
    }
}

