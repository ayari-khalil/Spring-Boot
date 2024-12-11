package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idB;
    private String nomB;
    private long capaciteB;

    @JsonIgnore
    @ManyToOne
    private Foyer foyer;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "bloc")
    private Set<Chambre> chambres;

}
