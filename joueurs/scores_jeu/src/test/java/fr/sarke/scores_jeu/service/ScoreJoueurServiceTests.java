package fr.sarke.scores_jeu.service;

import fr.sarke.scores_jeu.model.ScoreJoueur;
import fr.sarke.scores_jeu.repository.ScoreJoueurRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ScoreJoueurServiceTests {

    @Mock
    ScoreJoueurRepo scoreJoueurRepo;

    @InjectMocks
    ScoreJoueurService scoreJoueurService;

    @Test
    public void joueurExists_Test(){
        String joueurA = "A";
        String joueurB = "B";
        String joueurC = "C";

        ScoreJoueur sJSaved1 = ScoreJoueur.builder()
                .id(1L)
                .joueur(joueurA)
                .score(0).build();

        ScoreJoueur sJSaved2 = ScoreJoueur.builder()
                .id(2L)
                .joueur(joueurB)
                .score(0).build();

        List<ScoreJoueur> listeJoueurs = List.of(sJSaved1, sJSaved2);

        when(scoreJoueurRepo.findAll()).thenReturn(listeJoueurs);

        Assertions.assertTrue(scoreJoueurService.joueurExists(joueurA));
        Assertions.assertTrue(scoreJoueurService.joueurExists(joueurB));
        Assertions.assertFalse(scoreJoueurService.joueurExists(joueurC));

    }

    @Test
    public void addJoueur_Test() {

        String joueurA = "A";
        String joueurB = "B";

        ScoreJoueur sJ1 = ScoreJoueur.builder()
                .joueur(joueurA)
                .score(0).build();

        ScoreJoueur sJSaved1 = ScoreJoueur.builder()
                .id(1L)
                .joueur(joueurA)
                .score(0).build();

        ScoreJoueur sJSaved2 = ScoreJoueur.builder()
                .id(2L)
                .joueur(joueurB)
                .score(0).build();

        List<ScoreJoueur> listeJoueurs = List.of(sJSaved2);

        when(scoreJoueurRepo.save(sJ1)).thenReturn(sJSaved1);
        when(scoreJoueurRepo.findAll()).thenReturn(listeJoueurs);

        ScoreJoueur sJObtenu = scoreJoueurService.addJoueur(joueurA);

        Assertions.assertNotNull(sJObtenu);
        Assertions.assertNotNull(sJObtenu.getId());

        Assertions.assertEquals(joueurA, sJObtenu.getJoueur());
        Assertions.assertEquals(0, sJObtenu.getScore());

        Assertions.assertThrows(IllegalArgumentException.class, () -> scoreJoueurService.addJoueur(joueurB));
    }



}
