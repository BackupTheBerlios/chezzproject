package Elements;


/**
 * Titre :
 * Description :
 * Copyright :    Copyright (c) 2003
 * Soci�t� :
 * @author
 * @version 1.0
 */

public class Pion extends Piece {

  private boolean bouge = false;

  public Pion(int id, int coordonneesX, int coordonneesY, int couleurPion) {
    super(id,coordonneesX,coordonneesY,couleurPion);
  }

  public Pion(int id, int coordonneesX, int coordonneesY, int couleurPion, boolean bouge) {
    super(id,coordonneesX,coordonneesY,couleurPion);
    setBouge(bouge);
  }

  public String afficherPiece() {
    return " P ";
  }

  /* test la validit� du mouvement */
  public boolean testerDeplacementPiece (int nouvelleCoordX, int nouvelleCoordY) {

    boolean deplacementPossible = false;
    int x = nouvelleCoordX - getCoordonneesX();
    int y = nouvelleCoordY - getCoordonneesY();
      //cas simple de d�placement /** @todo tester pas de pion car on ne mange pas tout droit */
    if ((y == 1 && x == 0 && getCouleurPion()==0)
      || (y == -1 && x == 0 && getCouleurPion()==1)) {
        deplacementPossible = true;
    }
    //cas ou le pion n'a pas boug� /** @todo tester pas de pion car on ne mange pas tout droit */
    else if (!isBouge() &&
        ((y == 2 && x == 0 && getCouleurPion()==0)
        || (y == -2 && x == 0 && getCouleurPion()==1))) {
        deplacementPossible = true;
    }


    /** @todo tester le cas ou on mange une pi�ce en diagonal */
//    else if () {
//    }

    if (deplacementPossible) {
      setBouge(true);
    }
    return deplacementPossible;
  }

    /* cherche toutes les cases � parcourir pour aller � la nouvelle position */
  public int[] cheminAParcourir (int nouvelleCoordX, int nouvelleCoordY) {
    /** @todo impl�menter cette m�thode */
    if ((!isBouge()) && (nouvelleCoordY-getCoordonneesY() == 2 || nouvelleCoordY-getCoordonneesY() == -2)) {
      int [] tab = {nouvelleCoordX,((getCoordonneesY()+nouvelleCoordY)/2)};
      return tab;
    }
    else {
      return null;
    }
  }




  public boolean isBouge() {
    return bouge;
  }
  public void setBouge(boolean bouge) {
    this.bouge = bouge;
  }
}