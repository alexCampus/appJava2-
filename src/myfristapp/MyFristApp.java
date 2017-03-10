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
        String messagesTab [];
        int nbMsg;
        //var permettant de checker choix utilisateur
        int choix;
        //var user ajout tableau user
        Users usersTab [];
        int nbUsers =0;
       
        
        //Initialisation scanner
        Scanner sc;
        sc = new Scanner(System.in);
        
                //création du user courant                
                Affichage monMenu = new Affichage();
                Users currentUser = monMenu.createUser();
              
                 
         do{  
             if(reponse == 'o')
             {
                 Users otherUsers = monMenu.createUser();
                  
                 currentUser.setUsers(otherUsers);
                    
             }

            //boucle permettant les différents choix
            do {
                messagesTab = currentUser.getAllMessages();
                usersTab = currentUser.getAllUsers();
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
                         int id = 1;
                        //parcourt le tableau message
                        for (String messagesTab1 : messagesTab) {
                            //verifie si il y a des messages et permet de compter le nombre d'entrée
                            if(messagesTab1 != null){
                                System.out.println(id + " -  " + messagesTab1.substring(0, 6) + "...");
                                nbMsg ++;
                                id ++;
                            }                        
                        }

                        System.out.println("Vous avez " + nbMsg + " messages.");

                        //permet le choix du message si des messages existent                    
                        if(nbMsg > 0)
                        {
                           System.out.println(monMenu.seeMsg(choix, nbMsg, currentUser));

                        }
                        break;

                    case 5:
                        
                        nbUsers =0;
                        id =0;
                        
                        for (Users userTab : usersTab) {
                            
                            if(userTab != null) {
                                System.out.println(id + " " + userTab.getPrenom() + " " + userTab.getNom());
                                nbUsers ++;
                                id ++; 
                            }
                        }
                        
                        System.out.println("Il existe  " + nbUsers + " potentiellement amis.");
                        
                        //permet le choix des amis si des amis existent
                        if(nbUsers > 0) 
                        {
                            System.out.println("Quel amis souhaitez vous aimé? (taper son numero)");
                            choix = sc.nextInt();
                            sc.nextLine();
                            System.out.println("______________________________\n");
                          
                            //gère les différents choix du user et valide le lien d'amitié 
                            if(choix >=0 && choix <= nbUsers)
                            {
                                usersTab[choix].toBeFriend();      
                              
                                System.out.println("Vous etes maintenant amis avec " + usersTab[choix].getPrenom() + " " + usersTab[choix].getNom() + "\n______________________________\n");
                            }
                            else{
                                System.out.println("Désolé, mais votre choix ne correspond à aucun amis.\n______________________________\n");
                            }
                            
                        }                        
                       
                        break;

                    case 6:
                        //usersTab = currentUser.getAllUsers();
                        nbUsers =0;
                        boolean isFriend;
                                                
                        for (Users userTab : usersTab) {
                           
                            if(userTab != null && userTab.isFriend() == true) {
                                 
                                 nbUsers ++;
                            }
                           
                        }
                        
                        System.out.println("Vous avez  " + nbUsers + " amis.");
                        
                        //permet le choix des amis si des amis existent
                        if(nbUsers > 0) 
                        {
                            System.out.println("Quel amis souhaitez vous afficher? (taper son numero)");
                            choix = sc.nextInt();
                            sc.nextLine();   
                            System.out.println("______________________________\n");
                               
                                   
                            //gère les différents choix du user et retourne l amis correspondant 
                            if(choix >0 && choix <= nbUsers && usersTab[choix-1].isFriend() == true)
                            {
                                System.out.println(currentUser.getOneUser(choix-1) + "\n______________________________\n");
                            }
                            else{
                                System.out.println("Désolé, mais votre choix ne correspond à aucun amis.\n______________________________\n");
                            }
                        }
                            
                       
                       
                        break;

                    default:
                        System.out.println("default");

                 }

                do{
                    System.out.println("Voulez vous continuer? (O/N)");
                    reponse = sc.next().charAt(0);
                    sc.nextLine();
                    System.out.println("______________________________\n");
                }while(reponse != 'N' && reponse != 'O');

            }while(reponse == 'O');
            
            do{
                    System.out.println("Voulez vous saisir un autre utilisateur? (o/n)");
                    reponse = sc.next().charAt(0);
                    sc.nextLine();
                    System.out.println("______________________________\n");
                }while(reponse != 'n' && reponse != 'o');
            
           
            
        }while(reponse == 'o');
        
        System.out.println("Au revoir !");
        
        
        
    }
}
