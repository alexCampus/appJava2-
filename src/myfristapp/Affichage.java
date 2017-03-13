/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfristapp;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author alexandre.depembroke
 */
public class Affichage {
   
    private static Scanner sc=  new Scanner(System.in);;
    
    public Affichage(){ 
         
    }
     
    
    
    public Users createUser(){    
        
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
       
        System.out.println("Que souhaitez vous faire : taper \n 1 pour voir votre profil, \n 2 pour modifier vos informations, \n 3 pour écrire un message, \n 4 pour afficher un message, \n 5 pour ajouter un ami, \n 6 pour afficher les infos des amis\n______________________________\n");
                int choix = sc.nextInt();
                sc.nextLine();
                System.out.println("______________________________\n");
                return choix;
    }
    
    public int menuModif() {      
        
         System.out.println("Que souhaitez vous modifier : \n 1 Votre Prénom, \n 2 Votre Nom, \n 3 Votre Ville, \n 4 Votre Date de Naissance\n______________________________\n ");
                int choix = sc.nextInt();
                sc.nextLine();
                
                return choix;
    }
    
    public String switchModif(Users currentUser, int choix){        
       
         switch(choix)
            {
                case 1:
                    System.out.println("Taper votre nouveau prénom");
                    String newPrenom = sc.nextLine();
                    currentUser.setPrenom(newPrenom);
                    return "Vos infos ont bien été modifié!\n______________________________\n"; 
                    

                case 2:
                    System.out.println("Taper votre nouveau nom");
                    String newNom = sc.nextLine();
                    currentUser.setNom(newNom);
                    return "Vos infos ont bien été modifié!\n______________________________\n"; 
                   

                case 3:
                    System.out.println("Taper votre nouvelle ville");
                    String newVille = sc.nextLine();
                    currentUser.setVille(newVille);
                    return "Vos infos ont bien été modifié!\n______________________________\n"; 
                    

                case 4:
                    System.out.println("Taper votre nouvelle année de naissance");
                    int newBirthYear = sc.nextInt();
                    sc.nextLine();
                    currentUser.setBirthYear(newBirthYear);
                   return "Vos infos ont bien été modifié!\n______________________________\n"; 
                    

                default:
                    return  "erreur\n______________________________\n";
                  
            }       
             
         }
    
     public String insertCreateMsg(Users currentUser){
         System.out.println("Veuillez écrire votre message!\n______________________________\n");
                String message = sc.nextLine();
                currentUser.setMessages(message);
                return "Votre message a bien été enregistré!\n______________________________\n";  
     }
     
     public String seeMsg(int nbMsg, Users currentUser){        
        
        System.out.println("Quel message souhaitez vous afficher? (taper son numero)");
        int choix = sc.nextInt();
        sc.nextLine();
        System.out.println("______________________________\n");

        //gère les différents choix du user et retourne le message correspondant 
        if(choix >0 && choix <= nbMsg)
        {
            return currentUser.getOneMessage(choix-1);
        }
        else{
            return "Désolé, mais votre choix ne correspond à aucun message.";
        }     
     }
     
     public String addFriends(IntWrapper nbUsers, ArrayList<Users> usersTab){
         System.out.println("Quel amis souhaitez vous aimé? (taper son numero)");
             int choix = sc.nextInt();
            sc.nextLine();
            System.out.println("______________________________\n");

            //gère les différents choix du user et valide le lien d'amitié 
            if(choix >0 && choix <= nbUsers.getValue())
            {
                usersTab.get(choix -1).toBeFriend();      

                return "Vous etes maintenant amis avec " + usersTab.get(choix-1).getPrenom() + " " + usersTab.get(choix-1).getNom() + "\n______________________________\n";
            }
            else{
                return "Désolé, mais votre choix ne correspond à aucun amis.\n______________________________\n";
            }
     }
     
     public String seeFriend(IntWrapper nbUsers, ArrayList<Users> usersTab, Users currentUser ){
         System.out.println("Quel amis souhaitez vous afficher? (taper son numero)");
            int choix = sc.nextInt();
            sc.nextLine();   
            System.out.println("______________________________\n");


            //gère les différents choix du user et retourne l amis correspondant 
            if(choix >0 && choix <= nbUsers.getValue() && usersTab.get(choix-1).isFriend() == true)
            {
                return currentUser.getOneUser(choix-1) + "\n______________________________\n";
            }
            else{
                return "Désolé, mais votre choix ne correspond à aucun amis.\n______________________________\n";
            }
     }
     
     public String infoFriend(IntWrapper nbUsers, IntWrapper id, Users userTab){        
            
            id.setValue(id.getValue() + 1);
            nbUsers.setValue(nbUsers.getValue()+ 1);
            return id.getValue() + " " + userTab.getPrenom() + " " + userTab.getNom();
    }
     
     public char reponseBoucle(){
            char reponse = sc.next().charAt(0);
            sc.nextLine();
            System.out.println("______________________________\n");
            return reponse;
     }
       
           
    
}
