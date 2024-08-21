package fr.sarke.scores_jeu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.sarke.scores_jeu.model.ScoreJoueur;
import fr.sarke.scores_jeu.repository.ScoreJoueurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreJoueurService {

    ScoreJoueurRepo scoreJoueurRepo;
    @Autowired
    public ScoreJoueurService(ScoreJoueurRepo scoreJoueurRepo) {
        this.scoreJoueurRepo = scoreJoueurRepo;
    }

    public boolean joueurExists(String joueur){

        List<ScoreJoueur> listeSJ = scoreJoueurRepo.findAll();
        List<String> listeJoueurs = listeSJ.stream().map(ScoreJoueur::getJoueur).toList();
        return listeJoueurs.contains(joueur);
        }

    public ScoreJoueur addJoueur(String nomJoueur) {

        if (joueurExists(nomJoueur)) {
            throw new IllegalArgumentException("Ce joueur existe déjà");
        }
        else {
            ScoreJoueur scoreJoueur = new ScoreJoueur();
            scoreJoueur.setJoueur(nomJoueur);
            scoreJoueur.setScore(0);
            return scoreJoueurRepo.save(scoreJoueur);
        }

    }

/*
    public ScoreJoueur getScoreJoueur(String nomJoueur) {
    }


    public int addScore(String joueur, int ajout){
    }
*/

}
