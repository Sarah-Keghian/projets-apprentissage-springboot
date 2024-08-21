package fr.sarke.db_for_de.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode

public class De {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int nbFaces;
    private int position;

//    public De(int nbFaces, int position) {
//        if (nbFaces < 1) {
//            throw new IllegalArgumentException("Le nombre de faces doit être supérieur à 0");
//        } else if (position < 1 || position > nbFaces) {
//            throw new IllegalArgumentException
//                    ("La position doit être comprise entre 1 et " + nbFaces);
//        } else {
//            this.position = position;
//            this.nbFaces = nbFaces;
//        }
//
//
//    }
//
//    public void setPosition(int position) {
//        if (position < 1 || position > this.nbFaces) {
//            throw new IllegalArgumentException("La position doit être comprise entre 1 et  " + nbFaces);
//        } else {
//            this.position = position;
//        }
//    }
//
//    public void setNbFaces(int nbFaces) {
//        if (nbFaces < 0) {
//            throw new IllegalArgumentException("Le nombre de faces doit être supérieur à 0");
//        } else {
//            this.nbFaces = nbFaces;
//        }
//    }
}
