package fr.sarke.h2.application.controller;

import fr.sarke.h2.application.model.Livre;
import fr.sarke.h2.application.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class H2Controller {

    @Autowired
    private LivreRepository livreRepository;

    @GetMapping("/getAllLivres")
    public ResponseEntity<List<Livre>> getAllLivres(){
        try{
            List<Livre> listeLivres = new ArrayList<Livre>();
            livreRepository.findAll().forEach(listeLivres::add);

            if (listeLivres.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listeLivres, HttpStatus.OK);

        } catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getLivreParId/{id}")
    public ResponseEntity<Livre> getLivreParId(@PathVariable Long id){
        Optional<Livre> donneeLivre = livreRepository.findById(id);

        if (donneeLivre.isPresent()){
            return new ResponseEntity<>(donneeLivre.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addLivre")
    public ResponseEntity<Livre> addLivre(@RequestBody Livre livre){
        Livre livreObj = livreRepository.save(livre);

        return new ResponseEntity<>(livreObj, HttpStatus.OK);
    }

//    @PostMapping("/addListeLivres")
//    public ResponseEntity<ArrayList<Livre>> addListeLivres(ArrayList<Livre> listeLivres){
//
//        if (listeLivres.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        else if (!listeLivres.getClass().equals(ArrayList.class)){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        livreRepository.saveAll(listeLivres);
//        return new ResponseEntity<>(listeLivres, HttpStatus.OK);
//    }

    @PostMapping("/updateLivreParId/{id}")
    public ResponseEntity<Livre> updateLivreParId(@PathVariable Long id, @RequestBody Livre newDonneeLivre){
        Optional<Livre> ancienLivre = livreRepository.findById(id);
        if (ancienLivre.isPresent()){
            Livre updatedLivre = ancienLivre.get();
            updatedLivre.setAuthor(newDonneeLivre.getAuthor());
            updatedLivre.setTitle(newDonneeLivre.getTitle());

            Livre livreObj = livreRepository.save(updatedLivre);

            return new ResponseEntity<>(livreObj, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteLivreParId/{id}")
    public ResponseEntity<HttpStatus> deleteLivreParId(@PathVariable Long id){
        livreRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}

