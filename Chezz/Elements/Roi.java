package Elements;

/**
 * Titre : Roi
 * Description : pi�ce de type roi
 * Copyright :    Copyright (c) 2003
 * Soci�t� : wizzzz
 * @author
 * @version 1.0
 */

public class Roi extends Piece {

  private boolean bouge = false;

  public Roi(int id, int coordonneesX, int coordonneesY, int couleurPion) {
    super(id,coordonneesX,coordonneesY,couleurPion);
  }

  public Roi(int id, int coordonneesX, int coordonneesY, int couleurPion, boolean bouge) {
    super(id,coordonneesX,coordonneesY,couleurPion);
    setBouge(bouge);
  }

  /* test la validit� du mouvement */
  public boolean testerDeplacementPiece (int nouvelleCoordX, int nouvelleCoordY) {

    boolean deplacementPossible = false;
    int diffX = nouvelleCoordX - getCoordonneesX();
    int diffY = nouvelleCoordY - getCoordonneesY();

    if (diffX >= -1 && diffX <= 1 && diffY >= -1 && diffY <= 1) {
      deplacementPossible = true;
    }

    return deplacementPossible;
  }

  public String afficherPiece(){
    return " R ";
  }


    /* cherche toutes les cases � parcourir pour aller � la nouvelle position */
  public int[] cheminAParcourir (int nouvelleCoordX, int nouvelleCoordY) {
    /* pour le roi il n'y a pas de chemin, il se d�place d'une case */
    /* cette case �tant celle d'arriv�e elle est test�e dans la classe plateau */
    return null;
  }

  public boolean isBouge() {
    return bouge;
  }
  public void setBouge(boolean bouge) {
    this.bouge = bouge;
  }
}