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
@Setter @NoArgsConstructor @ToString
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idF;
    private String nomF;
    private long capaciteF;

    @OneToOne(mappedBy = "foyer")
    private Universite universite;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "foyer")
    private Set<Bloc> blocs;
}
