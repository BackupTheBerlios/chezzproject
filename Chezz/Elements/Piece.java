package Elements;

/**
 * Titre : Piece
 * Description : classe des pièces à jouer
 * Copyright :    Copyright (c) 2003
 * Société : wizzzz
 * @author
 * @version 1.0
 */

public abstract class Piece {

    private int id;   // 1 -> première pièce de ce type, 2 -> deuxième, 3 -> troisième, ....
    private int coordonneesX;   // de 1 à 8
    private int coordonneesY;   // de 1 à 8
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

  /* test la validité du mouvement */
  public abstract boolean testerDeplacementPiece (int nouvelleCoordX, int nouvelleCoordY);
  public abstract String afficherPiece();
    /* cherche toutes les cases à parcourir pour aller à la nouvelle position */
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