/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfristapp;

import java.util.Scanner;

/**
 *
 * @author alexandre.depembroke
 */
public class Affichage {
    
    public Affichage(){       
    }
    
    
    public Users createUser(){
        
        //Initialisation scanner
        Scanner sc;
        sc = new Scanner(System.in);
        
       
            //Définition des infos user    
                System.out.println("Veuillez saisir votre prénom");
                String prenom = sc.nextLine();
                System.out.println("______________________________\n");


                System.out.println("Veuillez saisir votre nom");
                String nom = sc.nextLine();
                System.out.println("______________________________\n");


                System.out.println("Veuillez saisir votre Ville");
                String ville = sc.nextLine();
                System.out.println("______________________________\n");


                System.out.println("Veuillez saisir votre année de naissance");
                int birthYear = sc.nextInt();
                sc.nextLine();
                System.out.println("______________________________\n");
                
                return new Users(nom, prenom ,ville, birthYear);
                
    }
    
    
    
    
}
