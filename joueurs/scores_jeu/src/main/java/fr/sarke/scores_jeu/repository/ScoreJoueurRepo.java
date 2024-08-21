package fr.sarke.scores_jeu.repository;

import fr.sarke.scores_jeu.model.ScoreJoueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreJoueurRepo extends JpaRepository<ScoreJoueur, Long> {
}
