package Elements;

/**
 * Titre :
 * Description :
 * Copyright :    Copyright (c) 2003
 * Société :
 * @author
 * @version 1.0
 */

public class Fou extends Piece {

  public Fou(int id, int coordonneesX, int coordonneesY, int couleurPion) {
    super(id,coordonneesX,coordonneesY,couleurPion);
  }
  public String afficherPiece() {
    return " F ";
  }

  /* test la validité du mouvement */
  public boolean testerDeplacementPiece (int nouvelleCoordX, int nouvelleCoordY) {
    /** @todo tester présence pièce sur chemin de déplacement */

    boolean deplacementPossible = false;
    int x = nouvelleCoordX - getCoordonneesX();
    int y = nouvelleCoordY - getCoordonneesY();
    if (x == y || x == -y) {
      deplacementPossible = true;
    }
    return deplacementPossible;
  }

    /* cherche toutes les cases à parcourir pour aller à la nouvelle position */
  public int[] cheminAParcourir (int nouvelleCoordX, int nouvelleCoordY) {
    /** @todo implémenter cette méthode */
    int ajoutX; // valeur à ajouter pour parcourir l'axe des X, 1 ou -1
    int ajoutY; // valeur à ajouter pour parcourir l'axe des Y, 1 ou -1
    int nbDeplacements;

    if (nouvelleCoordX > getCoordonneesX()) {
      ajoutX = 1;
      nbDeplacements = nouvelleCoordX - getCoordonneesX() - 1; // on enlève la case d'arrivée
    }
    else {
      ajoutX = -1;
      nbDeplacements = getCoordonneesX() - nouvelleCoordX - 1; // on enlève la case d'arrivée
    }
    if (nouvelleCoordY > getCoordonneesY()) {
      ajoutY = 1;
    }
    else {
      ajoutY = -1;
    }
    int coordX = getCoordonneesX() + ajoutX;
    int coordY = getCoordonneesY() + ajoutY;

    int i=0;
    if (nbDeplacements != 0) {
      int tab[] = new int[nbDeplacements*2];

      while (coordX != nouvelleCoordX) {
        tab[i] = coordX;
        coordX = coordX + ajoutX;
        tab[i+1] = coordY;
        coordY = coordY + ajoutY;
      }
      return tab;
    }
    return null;
  }

}