package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Bloc;

public interface BlocRepository extends JpaRepository<Bloc,Long> {

    @Query("select b from Bloc b where b.capaciteB = :capaciteB")
    Bloc getBlocByCapacite(@Param("capaciteB") Long capaciteB);
}
