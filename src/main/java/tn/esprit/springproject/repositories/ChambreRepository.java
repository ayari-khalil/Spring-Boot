package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Chambre;
import tn.esprit.springproject.entities.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    public List<Chambre> findByBloc_IdBAndTypeC(Long idB, TypeChambre typeChambre);

    @Query("select c from Chambre c where c.bloc.idB= :idB and c.typeC = :typeChambre")
    public List<Chambre> getChambreByBloc_IdBAndTypeC(@Param("idB") Long idB,@Param("typeChambre") TypeChambre typeChambre);


}
