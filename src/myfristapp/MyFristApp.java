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
public class MyFristApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //variable pour réponse de boucle
        char reponse = ' ';
        //bool pour check messages
        boolean checkMsg = false;
        //var  pour recuperer tableau
        ArrayList<String> messagesTab = new ArrayList<>();
        int nbMsg;
        //var permettant de checker choix utilisateur
        int choix;
        //var user ajout tableau user
        ArrayList<Users> usersTab = new ArrayList<>();
        //var firend ajout tableau friends
        ArrayList<Users> friends = new ArrayList<>();
        IntWrapper nbUsers=new  IntWrapper();
        IntWrapper id =new  IntWrapper();
        
        //Initialisation scanner
        Scanner sc;
        sc = new Scanner(System.in);
        
                //création du user courant                
                Affichage monMenu = new Affichage();
                Users currentUser = monMenu.createUser();
                Personn mesUsers = new Personn();
              
                 
         do{  
             if(reponse == 'o')
             {
                 Users otherUsers = monMenu.createUser();
                 
                 mesUsers.setUsers(otherUsers);
                  
             }

            //boucle permettant les différents choix
            do {
                
                //initialisation des variables ayant une pportée globale dans la boucle
                messagesTab = currentUser.getAllMessages();
                usersTab = mesUsers.getAllUsers();
                friends = currentUser.getAllFriends();
                
               //recupération du choix utilisateur
               choix = monMenu.menu();
               
                switch(choix)
                {
                    case 1:
                        
                        //recupère info user                        
                        System.out.println(currentUser.presenteMoi());

                        //parcourt le tableau message pour les afficher
                        for (String messagesTab1 : messagesTab) {
                            //verifie si il y a des messages
                            if(messagesTab1 != null){
                                System.out.println("    - " + messagesTab1);
                                checkMsg = true;
                            }                        
                        }

                        //si il n'y a aucun messages
                        if(checkMsg == false){
                            System.out.println("Désolé vous n'avez pas encore de message\n______________________________\n");
                           
                        }                       
                        break;

                        //Permet l'update des infos du user
                    case 2 :
                        
                         //recupération du choix utilisateur
                        choix = monMenu.menuModif();
                        
                        //Mise en place du switch de modification des informations du current user
                        System.out.println(monMenu.switchModif(currentUser, choix));
                        
                        break;

                        //Création des messages et insertion dans le tableau
                    case 3:
                        System.out.println(monMenu.insertCreateMsg(currentUser));
                        break;

                    case 4:
                       
                         nbMsg =0;
  
                         id.setValue(1);
                        //parcourt le tableau message
                        for (String messagesTab1 : messagesTab) {
                            //verifie si il y a des messages et permet de compter le nombre d'entrée
                            if(messagesTab1 != null){
                                System.out.println(id.getValue() + " -  " + messagesTab1.substring(0, 4) + "...");
                                nbMsg ++;
                                id.setValue(id.getValue()+1);
                            }                        
                        }

                        System.out.println("Vous avez " + nbMsg + " messages.");

                        //permet le choix du message si des messages existent                    
                        if(nbMsg > 0)
                        {
                           System.out.println(monMenu.seeMsg(nbMsg, currentUser));

                        }
                        break;
                        
                    case 5:
                        
                         nbMsg =0;
  
                         id.setValue(1);
                        //parcourt le tableau message
                        for (String messagesTab1 : messagesTab) {
                            //verifie si il y a des messages et permet de compter le nombre d'entrée
                            if(messagesTab1 != null){
                                System.out.println(id.getValue() + " -  " + messagesTab1);
                                nbMsg ++;
                                id.setValue(id.getValue()+1);
                            }                        
                        }

                        System.out.println("Vous avez " + nbMsg + " messages.");

                        //permet le choix du message si des messages existent                    
                        if(nbMsg > 0)
                        {
                           System.out.println(monMenu.deleteMsg(nbMsg, currentUser));

                        }
                        
                        break;

                    case 6:
                        
                        nbUsers.setValue(0);
                        id.setValue(0);
                        
                        for (Users user : usersTab) {
                           monMenu.infoFriend(nbUsers, id, user);
                            if(user != null && user.isFriend() == false) {
                               System.out.println(id.getValue() + " " + user.getPrenom() + " " + user.getNom());
                               
                            }
                        }
                        
                        System.out.println("Il existe  " + nbUsers.getValue() + " potentiellement amis.");
                        
                        //permet le choix des amis si des amis existent
                        if(nbUsers.getValue() > 0) 
                        {
                            System.out.println(monMenu.addFriends(nbUsers, usersTab, currentUser));
   
                        }                        
                       
                        break;

                    case 7:
                  
                        nbUsers.setValue(friends.size());
                        id.setValue(0);
                        boolean isFriend;
                                                
                        for (Users friend : friends) {
                           
                            if(friend != null && friend.isFriend() == true) {
                               System.out.println(monMenu.infoFriend(nbUsers, id, friend));
                               
                           
                            }
                           
                        }
                        
                        System.out.println("Vous avez  " + nbUsers.getValue() + " amis.");
                        
                        //permet le choix des amis si des amis existent
                        if(nbUsers.getValue() > 0) 
                        {
                           System.out.println(monMenu.seeFriend(nbUsers, usersTab, currentUser));
                        }                
                       
                        break;

                    default:
                        System.out.println("default");

                 }

                do{
                    
                    System.out.println("Voulez vous continuer? (O/N)");
                    reponse = monMenu.reponseBoucle();
                    
                }while(reponse != 'N' && reponse != 'O');

            }while(reponse == 'O');
            
            do{
                
                    System.out.println("Voulez vous saisir un autre utilisateur? (o/n)");
                    reponse = monMenu.reponseBoucle();
                    
                }while(reponse != 'n' && reponse != 'o');           
            
        }while(reponse == 'o');
        
        System.out.println("Au revoir !");
  
    }
}
