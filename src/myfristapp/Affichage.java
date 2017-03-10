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
   
    private static Scanner sc;
    
    public Affichage(){ 
         
    }
     

    public static void main(String[] args) {

        

    }
    
    
    public Users createUser(){
        
        //Initialisation scanner        
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
    
    public int menu(){
        
        //Initialisation scanner
        sc = new Scanner(System.in);
        
        System.out.println("Que souhaitez vous faire : taper \n 1 pour voir votre profil, \n 2 pour modifier vos informations, \n 3 pour écrire un message, \n 4 pour afficher un message, \n 5 pour ajouter un ami, \n 6 pour afficher les infos des amis\n______________________________\n");
                int choix = sc.nextInt();
                sc.nextLine();
                System.out.println("______________________________\n");
                return choix;
    }
    
    public int menuModif() {
        
        //Initialisation scanner
        sc = new Scanner(System.in);
        
         System.out.println("Que souhaitez vous modifier : \n 1 Votre Prénom, \n 2 Votre Nom, \n 3 Votre Ville, \n 4 Votre Date de Naissance\n______________________________\n ");
                int choix = sc.nextInt();
                sc.nextLine();
                
                return choix;
    }
    
    
    
    
}
