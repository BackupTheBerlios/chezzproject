package Elements;

/**
 * Titre : Piece
 * Description : classe des pi�ces � jouer
 * Copyright :    Copyright (c) 2003
 * Soci�t� : wizzzz
 * @author
 * @version 1.0
 */

public abstract class Piece {

    private int id;   // 1 -> premi�re pi�ce de ce type, 2 -> deuxi�me, 3 -> troisi�me, ....
    private int coordonneesX;   // de 1 � 8
    private int coordonneesY;   // de 1 � 8
    private int couleurPion;   // 0 -> blanc, 1 -> noir

  public Piece(int id, int coordonneesX, int coordonneesY, int couleurPion) {
    this.id = id;
    setCoordonneesX(coordonneesX);
    setCoordonneesY(coordonneesY);
    this.couleurPion = couleurPion;
  }

  public void changementPlace(int coordX, int coordY) {
    setCoordonneesX(coordX);
    setCoordonneesY(coordY);
  }

  /* test la validit� du mouvement */
  public abstract boolean testerDeplacementPiece (int nouvelleCoordX, int nouvelleCoordY);
  public abstract String afficherPiece();
    /* cherche toutes les cases � parcourir pour aller � la nouvelle position */
  public abstract int[] cheminAParcourir (int nouvelleCoordX, int nouvelleCoordY);

  public int getCoordonneesX() {
    return coordonneesX;
  }
  public void setCoordonneesX(int coordonneesX) {
    this.coordonneesX = coordonneesX;
  }
  public int getCoordonneesY() {
    return coordonneesY;
  }
  public void setCoordonneesY(int coordonneesY) {
    this.coordonneesY = coordonneesY;
  }
  public int getCouleurPion() {
    return couleurPion;
  }
  public int getId() {
    return id;
  }
}