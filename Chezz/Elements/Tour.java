package Elements;

/**
 * Titre :
 * Description :
 * Copyright :    Copyright (c) 2003
 * Société :
 * @author
 * @version 1.0
 */

public class Tour extends Piece {

  private boolean bouge = false;

  public Tour(int id, int coordonneesX, int coordonneesY, int couleurPion) {
    super(id,coordonneesX,coordonneesY,couleurPion);
  }

  public Tour(int id, int coordonneesX, int coordonneesY, int couleurPion, boolean bouge) {
    super(id,coordonneesX,coordonneesY,couleurPion);
    setBouge(bouge);
  }

  public String afficherPiece() {
    return " T ";
  }

  /* test la validité du mouvement */
  public boolean testerDeplacementPiece (int nouvelleCoordX, int nouvelleCoordY) {
    /** @todo tester présence pièce sur chemin de déplacement */

    boolean deplacementPossible = false;
    if ((nouvelleCoordX == getCoordonneesX() && nouvelleCoordY != getCoordonneesY())
          || (nouvelleCoordY == getCoordonneesY() && nouvelleCoordX != getCoordonneesX())) {
      deplacementPossible = true;
    }
    return deplacementPossible;
  }

    /* cherche toutes les cases à parcourir pour aller à la nouvelle position */
  public int[] cheminAParcourir (int nouvelleCoordX, int nouvelleCoordY) {
    int coordInchangee; // une des 2 coordonnees ne va pas changer, x ou y
    int coordDeDepart;  // le départ de la coordonnee qui change
    int coordDArrivee;  // l'arrivée de la coordonnee qui change
    int sensDuPion; // 1 si il descend ou va vers la droite et -1 si il remonte ou vers la gauche

      // si c'est la coordonnée de x qui change
    if (nouvelleCoordX != getCoordonneesX()) {
      coordInchangee = nouvelleCoordY;
      coordDeDepart = getCoordonneesX();
      coordDArrivee = nouvelleCoordX;
    }
    else { // c'est y qui change
      coordInchangee = nouvelleCoordX;
      coordDeDepart = getCoordonneesY();
      coordDArrivee = nouvelleCoordY;
    }
    int nbDeplacement;
    if (coordDArrivee > coordDeDepart) {
      sensDuPion = 1; // si coord d'arrivée > à celle du départ, le pion descend ou va à droite
      nbDeplacement = coordDArrivee - coordDeDepart - 1; // on enlève la case d'arrivée
    }
    else {
      sensDuPion = -1; // si coord d'arrivée > à celle du départ, le pion monte ou va à gauche
      nbDeplacement = coordDeDepart - coordDArrivee - 1; // on enlève la case d'arrivée
    }

    int i = coordDeDepart + sensDuPion; // pas besoin de tester la case où est le pion
    int j = 0;
    if (!(nbDeplacement==0)) {
      int tab[] = new int[(nbDeplacement)*2];
      while (i != coordDArrivee) {
        if (getCoordonneesX() != nouvelleCoordX) {
          tab[j] = i;
          tab[j+1] = coordInchangee;
        }
        else {
          tab[j] = coordInchangee;
          tab[j+1] = i;
        }
        i = i + sensDuPion;
        j = j+2;
      }
      return tab;
    }
    return null;
  }

  public void setBouge(boolean bouge) {
    this.bouge = bouge;
  }
  public boolean isBouge() {
    return bouge;
  }
}