package Elements;

import java.lang.NullPointerException;

/**
 * Titre : Plateau
 * Description : le plateau de jeu
 * Copyright :    Copyright (c) 2003
 * Société : wizzzz
 * @author :
 * @version 1.0
 */

public class Plateau {

  private int joueurCourant = 0;
  private Piece tabPlateau[][];


    /* Création d'un nouveau plateau avec les pièces à leurs places initiales */
    /*  Plateau traditionnel de jeu d'échec */

  public Plateau() {

    Tour t10 = new Tour(1,0,0,0);
    Fou f10 = new Fou(1,1,0,0);
    Cavalier c10 = new Cavalier(1,2,0,0);
    Roi r10 = new Roi(1,3,0,0);
    Dame d10 = new Dame(1,4,0,0);
    Cavalier c20 = new Cavalier(2,5,0,0);
    Fou f20 = new Fou(2,6,0,0);
    Tour t20 = new Tour(2,7,0,0);
    Pion p10 = new Pion(1,0,1,0);
    Pion p20 = new Pion(2,1,1,0);
    Pion p30 = new Pion(3,2,1,0);
    Pion p40 = new Pion(4,3,1,0);
    Pion p50 = new Pion(5,4,1,0);
    Pion p60 = new Pion(6,5,1,0);
    Pion p70 = new Pion(7,6,1,0);
    Pion p80 = new Pion(8,7,1,0);
    Pion p11 = new Pion(1,0,6,1);
    Pion p21 = new Pion(2,1,6,1);
    Pion p31 = new Pion(3,2,6,1);
    Pion p41 = new Pion(4,3,6,1);
    Pion p51 = new Pion(5,4,6,1);
    Pion p61 = new Pion(6,5,6,1);
    Pion p71 = new Pion(7,6,6,1);
    Pion p81 = new Pion(8,7,6,1);
    Tour t11 = new Tour(1,0,7,1);
    Fou f11 = new Fou(1,1,7,1);
    Cavalier c11 = new Cavalier(1,2,7,1);
    Dame d11 = new Dame(1,3,7,1);
    Roi r11 = new Roi(1,4,7,1);
    Cavalier c21 = new Cavalier(2,5,7,1);
    Fou f21 = new Fou(2,6,7,1);
    Tour t21 = new Tour(2,7,7,1);

    Piece tab[][] = {
                  {t10,f10,c10,r10,d10,c20,f20,t20},
                  {p10,p20,p30,p40,p50,p60,p70,p80},
                  {null,null,null,null,null,null,null,null},
                  {null,null,null,null,null,null,null,null},
                  {null,null,null,null,null,null,null,null},
                  {null,null,null,null,null,null,null,null},
                  {p11,p21,p31,p41,p51,p61,p71,p81},
                  {t11,f11,c11,d11,r11,c21,f21,t21} };

    setTabPlateau(tab);
  }


    /* Création d'un nouveau plateau avec les pièces à leurs places initiales */
    /*  Plateau chargée depuis une sauvegarde par exemple */

  public Plateau(Piece tab[]) {
   /** @todo implémenter méthode qui construit le plateau à partir d'un tableau de pièces*/
   Piece plateau[][] = new Piece[8][8];
   for (int i=0; i<tab.length; i++) {
    plateau[tab[i].getCoordonneesY()][tab[i].getCoordonneesX()] = tab[i];
   }
   setTabPlateau(plateau);
  }


    /* Affichage du plateau de jeu avec les pièces */

  public void afficher() {
    System.out.println("     0     1     2     3     4     5     6     7   ");
    System.out.println("   ----------------------------------------------- ");
    for (int i=0; i<this.tabPlateau.length; i++) {
      System.out.print(i + " |");
      for (int j=0; j<this.tabPlateau[0].length; j++) {
        Piece p = this.tabPlateau[i][j];
        if (p!=null) {
          System.out.print(p.afficherPiece() + p.getCouleurPion() + " |");
        }
        else {
          System.out.print("     |");
        }
      }
      System.out.println(" " + i);
    }
    System.out.println("   ----------------------------------------------- ");
    System.out.println("     0     1     2     3     4     5     6     7   ");
  }


    /* Fonction qui va déplacer une pièce, en vérifiant que c'est une pièce du joueur courant, */
    /*  que le déplacement est possible et valide */

  public boolean deplacerPiece(int coordX, int coordY, int nouvelleCoordX, int nouvelleCoordY) {
    Piece p = tabPlateau[coordY][coordX];
    try {
      // test présence pion sur la case de départ
      if (testerPresencePionSurCase(coordX,coordY) ) {
        // test si couleur de pion = couleur du joueur
        if (p.getCouleurPion() == joueurCourant) {
          if (!(nouvelleCoordX >= tabPlateau.length || nouvelleCoordY >= tabPlateau.length)
            && testerDeplacement(coordX, coordY, nouvelleCoordX, nouvelleCoordY)) {
              p.changementPlace(nouvelleCoordX, nouvelleCoordY);
              this.tabPlateau[nouvelleCoordY][nouvelleCoordX] = p;
              this.tabPlateau[coordY][coordX]=null;
              joueurCourant = (joueurCourant+1)%2;
              System.out.println("joueurCourant " + joueurCourant);
              return true;
          }
          else {
            System.out.println("Déplacement impossible.");
            return false;
          }
        }
        else {
          System.out.println("Ce pion ne vous appartient pas.");
          return false;
        }
      }
      else {
        System.out.println("Il n'y a pas de pion sur cette case de départ.");
        return false;
      }
    }
    catch (NullPointerException exNull) {
      exNull.printStackTrace();
      return false;
    }
  }

  /* fonction qui teste la présence d'une pièce sur une case */

  public boolean testerPresencePionSurCase(int X, int Y) {
    return tabPlateau[Y][X] != null;
  }

  /* fonction qui teste la validité du déplacement : */
  /*   non présence d'une pièce sur son chemin */
  /*   déplacement valide pour cette pièce */

  public boolean testerDeplacement(int coordX, int coordY, int nouvelleCoordX, int nouvelleCoordY) {
    /** @todo tester présence pièce sur la case de destination */

    boolean deplacementPossible = false;
        // test : pas de pion sur la case d'arrivée ou pion de l'autre couleur
    if (! testerPresencePionSurCase(nouvelleCoordX,nouvelleCoordY)
              ||  (testerPresencePionSurCase(nouvelleCoordX,nouvelleCoordY)
                  && tabPlateau[coordY][coordX].getCouleurPion()!=tabPlateau[nouvelleCoordY][nouvelleCoordX].getCouleurPion())){
        // test si nouvelles coordonnées différentes de l'origine
      if (coordX != nouvelleCoordX || coordY != nouvelleCoordY) {
        deplacementPossible = (!(this.testerPresencePieceSurChemin(coordX, coordY, nouvelleCoordX, nouvelleCoordY))
                        && tabPlateau[coordY][coordX].testerDeplacementPiece(nouvelleCoordX, nouvelleCoordY));
      }
    }
    return deplacementPossible;
  }

  /* test la présence d'une piece sur le chemin de déplacement de la pièce choisie */
  public boolean testerPresencePieceSurChemin (int x, int y, int nouvelleCoordX, int nouvelleCoordY) {
    int [] tabCheminAParcourir = getTabPlateau()[y][x].cheminAParcourir(nouvelleCoordX, nouvelleCoordY);

    if (tabCheminAParcourir != null) {
      /* tester sur les cases du tableau la présence d'une pièce */
      for (int i = 0; i<tabCheminAParcourir.length; i++) {
        if (testerPresencePionSurCase(tabCheminAParcourir[i],tabCheminAParcourir[i+1])) {
          return true;
        }
        i++;
      }
    }
    return false;
  }

  public Piece[][] getTabPlateau() {
    return tabPlateau;
  }
  public int getJoueurCourant() {
    return joueurCourant;
  }
  public void setJoueurCourant(int joueurCourant) {
    this.joueurCourant = joueurCourant;
  }
  public void setTabPlateau(Piece[][] tabPlateau) {
    this.tabPlateau = tabPlateau;
  }

}