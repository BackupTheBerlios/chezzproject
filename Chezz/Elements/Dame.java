package Elements;

/**
 * Titre :
 * Description :
 * Copyright :    Copyright (c) 2003
 * Société :
 * @author
 * @version 1.0
 */

public class Dame extends Piece {

  public Dame(int id, int coordonneesX, int coordonneesY, int couleurPion) {
    super(id,coordonneesX,coordonneesY,couleurPion);
  }
  public String afficherPiece() {
    return " D ";
  }

  /* test la validité du mouvement */
  public boolean testerDeplacementPiece (int nouvelleCoordX, int nouvelleCoordY) {
    /** @todo tester présence pièce sur chemin de déplacement */

    boolean deplacementPossible = false;
    int x = nouvelleCoordX - getCoordonneesX();
    int y = nouvelleCoordY - getCoordonneesY();
      // tests des diagonales
    if (x == y || x == -y) {
      deplacementPossible = true;
    }
      // tests des lignes droites
    else if ((nouvelleCoordX == getCoordonneesX() && nouvelleCoordY != getCoordonneesY())
          || (nouvelleCoordY == getCoordonneesY() && nouvelleCoordX != getCoordonneesX())) {
      deplacementPossible = true;
    }


    return deplacementPossible;
  }

    /* cherche toutes les cases à parcourir pour aller à la nouvelle position */
  public int[] cheminAParcourir (int nouvelleCoordX, int nouvelleCoordY) {
    /** @todo implémenter cette méthode */
    int ajoutX;
    int ajoutY;
    int nbDeplacements=0;

      //combien il faut ajouter pour parcourir suivant l'axe des x
    if (nouvelleCoordX > getCoordonneesX()) {
      ajoutX = 1;
      nbDeplacements = nouvelleCoordX - getCoordonneesX() - 1; //enlève la première case
    }
    else if (nouvelleCoordX < getCoordonneesX()) {
      ajoutX = -1;
      nbDeplacements = getCoordonneesX() - nouvelleCoordX - 1; //enlève la première case
    }
    else {
      ajoutX = 0;
    }
      //combien il faut ajouter pour parcourir suivant l'axe des y
    if (nouvelleCoordY > getCoordonneesY()) {
      ajoutY = 1;
      nbDeplacements = nouvelleCoordY - getCoordonneesY() - 1; //enlève la première case
    }
    else if (nouvelleCoordY < getCoordonneesY()) {
      ajoutY = -1;
      nbDeplacements = getCoordonneesY() - nouvelleCoordY - 1; //enlève la première case
    }
    else {
      ajoutY = 0;
    }
    int coordX = getCoordonneesX() + ajoutX; // inutile de tester la case de départ
    int coordY = getCoordonneesY() + ajoutY; // inutile de tester la case de départ

    if (nbDeplacements != 0) {
      int tab [] = new int[nbDeplacements*2];
      int i = 0;
      while (!(coordX == nouvelleCoordX && coordY == nouvelleCoordY)) {
        tab[i] = coordX;
        coordX = coordX + ajoutX;
        tab[i+1] = coordY;
        coordY = coordY + ajoutY;
        i = i+2;
      }
      return tab;
    }

    return null;
  }

}