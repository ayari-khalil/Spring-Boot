package tn.esprit.springproject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idE;
    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;


}
