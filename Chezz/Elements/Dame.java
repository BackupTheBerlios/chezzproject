package Elements;

/**
 * Titre :
 * Description :
 * Copyright :    Copyright (c) 2003
 * Soci�t� :
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

  /* test la validit� du mouvement */
  public boolean testerDeplacementPiece (int nouvelleCoordX, int nouvelleCoordY) {
    /** @todo tester pr�sence pi�ce sur chemin de d�placement */

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

    /* cherche toutes les cases � parcourir pour aller � la nouvelle position */
  public int[] cheminAParcourir (int nouvelleCoordX, int nouvelleCoordY) {
    /** @todo impl�menter cette m�thode */
    int ajoutX;
    int ajoutY;
    int nbDeplacements=0;

      //combien il faut ajouter pour parcourir suivant l'axe des x
    if (nouvelleCoordX > getCoordonneesX()) {
      ajoutX = 1;
      nbDeplacements = nouvelleCoordX - getCoordonneesX() - 1; //enl�ve la premi�re case
    }
    else if (nouvelleCoordX < getCoordonneesX()) {
      ajoutX = -1;
      nbDeplacements = getCoordonneesX() - nouvelleCoordX - 1; //enl�ve la premi�re case
    }
    else {
      ajoutX = 0;
    }
      //combien il faut ajouter pour parcourir suivant l'axe des y
    if (nouvelleCoordY > getCoordonneesY()) {
      ajoutY = 1;
      nbDeplacements = nouvelleCoordY - getCoordonneesY() - 1; //enl�ve la premi�re case
    }
    else if (nouvelleCoordY < getCoordonneesY()) {
      ajoutY = -1;
      nbDeplacements = getCoordonneesY() - nouvelleCoordY - 1; //enl�ve la premi�re case
    }
    else {
      ajoutY = 0;
    }
    int coordX = getCoordonneesX() + ajoutX; // inutile de tester la case de d�part
    int coordY = getCoordonneesY() + ajoutY; // inutile de tester la case de d�part

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