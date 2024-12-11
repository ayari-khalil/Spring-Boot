package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idC;
    private Long numC;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @JsonIgnore
    @ManyToOne
    private Bloc bloc;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}
