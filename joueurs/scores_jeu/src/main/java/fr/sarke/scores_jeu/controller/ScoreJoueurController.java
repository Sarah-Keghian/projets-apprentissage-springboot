package fr.sarke.scores_jeu.controller;

import fr.sarke.scores_jeu.model.ScoreJoueur;
import fr.sarke.scores_jeu.service.ScoreJoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreJoueurController {

    @Autowired
    ScoreJoueurService scoreJoueurService;

    @PostMapping("/add")
    public ResponseEntity<String> addScoreJoueur(@RequestBody String nomJoueur) {
        try {
            scoreJoueurService.addJoueur(nomJoueur);
            return ResponseEntity.ok("Joueur " + nomJoueur + " added");
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
