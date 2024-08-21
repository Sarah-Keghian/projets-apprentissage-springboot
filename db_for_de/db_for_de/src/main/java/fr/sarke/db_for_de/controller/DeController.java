package fr.sarke.db_for_de.controller;

import fr.sarke.db_for_de.model.De;
import fr.sarke.db_for_de.service.DeService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DeController {

    private final DeService deService;
    @Autowired
    public DeController(DeService deService) {this.deService = deService;}

    @GetMapping("/getAllDes")
    public ResponseEntity<List<De>> getAllDes(){

        return ResponseEntity.ok(deService.getAllDes());
    }

    @GetMapping("/getDeById/{id}")
    public ResponseEntity<De> getDeById(@PathVariable final Long id){

        Optional<De> de = deService.getDeById(id);

//        if (de.isPresent()){
//            return ResponseEntity.ok(de.get());
//        }
//        else {
//            return ResponseEntity.notFound().build();
//        }

        return de.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/addDe")
    public ResponseEntity<De> addDe(@RequestBody De de){
        return ResponseEntity.ok(deService.addDe(de));
    }

    @DeleteMapping("/deleteDeById/{id}")
    public ResponseEntity<De> deleteDeById(@PathVariable final Long id){

        De de = deService.deleteDeById(id);
        if (de == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(de);
        }
    }

    @PostMapping("/updateDeById/{id}")
    public ResponseEntity<De> updateDeById(@PathVariable final Long id, @RequestBody De de){

        De updatedDe = deService.updateDeById(id, de);
        if (updatedDe == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(updatedDe);
        }
    }

    @DeleteMapping("/deleteAllDes")
    public ResponseEntity<List<De>> deleteAllDes() {
        return ResponseEntity.ok(deService.deleteAllDes());
    }
}
