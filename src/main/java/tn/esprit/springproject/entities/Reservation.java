package tn.esprit.springproject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    private String idR;
    private LocalDate anneUniversitaire;
    private Boolean estValide;
    private LocalDate dateDebut;
    private LocalDate dateFin;


    @ManyToMany(mappedBy = "reservations" , cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

    @Override
    public String toString() {
        return "Reservation{" +
                "idR='" + idR + '\'' +
                ", anneUniversitaire=" + anneUniversitaire +
                ", estValide=" + estValide +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
