package tn.esprit.springproject.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Bloc;
import tn.esprit.springproject.entities.Foyer;
import tn.esprit.springproject.services.FoyerServiceImp;
import tn.esprit.springproject.services.IBlocService;
import tn.esprit.springproject.services.IFoyerService;

import java.util.List;

@AllArgsConstructor
@RestController

public class BlocRestController {
    private IBlocService iBlocService;


    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc f) {
        return iBlocService.addBloc(f);
    }

    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {

        return iBlocService.updateBloc(bloc);
    }

    @GetMapping("/retrieveAllBloc")
    public List<Bloc> retrieveAllBloc() {
        return iBlocService.retrieveAllBloc();

    }

    @GetMapping("/retrieveBlocById/{idF}")
    public Bloc retrieveBlocById(@PathVariable long idF) {
        return iBlocService.retrieveBlocById(idF);

    }

    @DeleteMapping("/deleteBloc/{idF}")
    public void deleteBloc(@PathVariable long idF) {
        iBlocService.deleteBloc(idF);


    }

    @PostMapping("/affecterBlocAFoyer/{idB}/{idF}")
    public Bloc affecterBlocAFoyer(@PathVariable long idB,@PathVariable long idF) {
    return iBlocService.affecterBlocAFoyer(idB,idF);
    }

    @GetMapping("/getBlocByCapacite/{capaciteB}")
    public Bloc getBlocByCapacite(@PathVariable long capaciteB){
        return iBlocService.getBlocByCapacite(capaciteB);
    }

}
