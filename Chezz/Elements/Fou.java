package Elements;

/**
 * Titre :
 * Description :
 * Copyright :    Copyright (c) 2003
 * Soci�t� :
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

  /* test la validit� du mouvement */
  public boolean testerDeplacementPiece (int nouvelleCoordX, int nouvelleCoordY) {
    /** @todo tester pr�sence pi�ce sur chemin de d�placement */

    boolean deplacementPossible = false;
    int x = nouvelleCoordX - getCoordonneesX();
    int y = nouvelleCoordY - getCoordonneesY();
    if (x == y || x == -y) {
      deplacementPossible = true;
    }
    return deplacementPossible;
  }

    /* cherche toutes les cases � parcourir pour aller � la nouvelle position */
  public int[] cheminAParcourir (int nouvelleCoordX, int nouvelleCoordY) {
    /** @todo impl�menter cette m�thode */
    int ajoutX; // valeur � ajouter pour parcourir l'axe des X, 1 ou -1
    int ajoutY; // valeur � ajouter pour parcourir l'axe des Y, 1 ou -1
    int nbDeplacements;

    if (nouvelleCoordX > getCoordonneesX()) {
      ajoutX = 1;
      nbDeplacements = nouvelleCoordX - getCoordonneesX() - 1; // on enl�ve la case d'arriv�e
    }
    else {
      ajoutX = -1;
      nbDeplacements = getCoordonneesX() - nouvelleCoordX - 1; // on enl�ve la case d'arriv�e
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