package Elements;

/**
 * Titre :
 * Description :
 * Copyright :    Copyright (c) 2003
 * Soci�t� :
 * @author
 * @version 1.0
 */

public class Cavalier extends Piece {

  public Cavalier(int id, int coordonneesX, int coordonneesY, int couleurPion) {
    super(id,coordonneesX,coordonneesY,couleurPion);
  }
  public String afficherPiece() {
    return " C ";
  }

  /* test la validit� du mouvement */
  public boolean testerDeplacementPiece(int nouvelleCoordX, int nouvelleCoordY) {

    boolean deplacementPossible = false;
    int x = nouvelleCoordX - getCoordonneesX();
    int y = nouvelleCoordY - getCoordonneesY();
    if (((y==3 || y==-3) && (x==1 || x==-1))
            || ((x==3 || x==-3) && (y==1 || y==-1))) {
      deplacementPossible = true;
    }
    return deplacementPossible;
  }

  /* cherche toutes les cases � parcourir pour aller � la nouvelle position */
  public int[] cheminAParcourir (int nouvelleCoordX, int nouvelleCoordY) {
    /* il n'y a que la case d'arriv�e � tester, c'est fait dans la classe plateau*/
    return null;
  }

}