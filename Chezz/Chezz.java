//import Elements.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


//import java.io.*;

/**
 * Titre : Chezzzz
 * Description : classe principale
 * Copyright :    Copyright (c) 2003
 * Société : wizzzz
 * @author
 * @version 1.0
 */

public class Chezz {

  public Chezz() {
  }

  public static void main(String[] args) {
    Elements.Plateau plateau = new Elements.Plateau();
    plateau.afficher();

    /***********************************************/
    // IHM
    //Interface interface1 = new Interface();
    
    
    /***********************************************/
    
    while (true) {
        //lecture des coordonnées au clavier
      try {
        InputStreamReader isr = new InputStreamReader (System.in) ;
        BufferedReader br = new BufferedReader (isr) ;
        System.out.println("Joueur " + plateau.getJoueurCourant());
        System.out.println("X actuel ?");
        String lu = br.readLine () ;
        int x = Integer.parseInt (lu) ;
        System.out.println("Y actuel ?");
        lu = br.readLine () ;
        int y = Integer.parseInt (lu) ;
        System.out.println("Nouveau X ?");
        lu = br.readLine () ;
        int nx = Integer.parseInt (lu) ;
        System.out.println("Nouveau Y ?");
        lu = br.readLine () ;
        int ny = Integer.parseInt (lu) ;

        plateau.deplacerPiece(x,y,nx,ny);
        plateau.afficher();
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }

  }
}