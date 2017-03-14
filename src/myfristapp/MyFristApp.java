/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfristapp;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alexandre.depembroke
 */
public class MyFristApp {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        
        //variable pour réponse de boucle
        char reponse = ' ';
        char reponseDisconnect = ' ';
        //bool pour check messages
        boolean checkMsg = false;
        //var  pour recuperer tableau
        ArrayList<String> messagesTab = new ArrayList<>();
        int nbMsg;
        //var permettant de checker choix utilisateur
        int choix = 0;
        //var user ajout tableau user
        ArrayList<Users> usersTab = new ArrayList<>();
      
        Users currentUser = new Users();
         Personn mesUsers;
        //var firend ajout tableau friends
        ArrayList<Users> friends = new ArrayList<>();
        IntWrapper nbUsers=new  IntWrapper();
        IntWrapper id =new  IntWrapper();
        
        //Initialisation scanner
        Scanner sc;
        sc = new Scanner(System.in);
        mesUsers = new Personn();
        
         Affichage monMenu = new Affichage();
            do{  
             do{
            
            System.out.println("Que souhaitez vous faire : \n 1 Inscription, \n  \n 2 Connexion,\n \n 3 Quitter,\n \n \n______________________________\n");
            try {
                     choix = sc.nextInt();
                 } catch (InputMismatchException IME) {
                    System.out.println("Vous n'avez pas saisi un chiffre.");
                 }
           
            sc.nextLine();
            System.out.println("______________________________\n");
            
            
            switch(choix)
            {
                case 1:
                    System.out.println("Bienvenue, veuillez saisir vos informations. \n \n______________________________\n");
                    currentUser =  monMenu.createUser();
                    messagesTab = currentUser.getAllMessages();
                    
                    mesUsers.setUsers(currentUser);
                    
                    usersTab = mesUsers.getAllUsers();
                    friends = currentUser.getAllFriends();
                    reponse = 'O';
                    reponseDisconnect = 'N';
                    break;
                    
                case 2:
                    System.out.println("2");
                    reponse = 'Z';
                    break;
                    
                case 3:
                    System.out.println("3");
                    reponse = 'Z';
                    reponseDisconnect = 'N';
                    break;
                    
                default:
                    reponseDisconnect = 'O';
                    break;
            }
            
        }while(reponseDisconnect == 'O');        
       
              
           //création du user courant                
               
           
                
               
          
                 //boucle permettant les différents choix
            while(reponse == 'O') {
                           
               //recupération du choix utilisateur
               choix = monMenu.menu(currentUser);
               
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
                        
                        //Verification du cast Moderateur ou Users
                         if(currentUser.getClass().getName().equals("myfristapp.Moderateur"))
                        {
                             System.out.println("Vous etes moderateur de niveau : " + ((Moderateur)currentUser).getLevelModeration());
                        }

                        //si il n'y a aucun messages
                        if(checkMsg == false){
                            System.out.println("Désolé vous n'avez pas encore de message\n______________________________\n");
                           
                        }
                        reponse = 'O';
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
                        
                        nbUsers.setValue(-1);
                        id.setValue(0);
                        
                        for (Users user : usersTab) {
                           monMenu.infoFriend(nbUsers, id, user);
                            if(user != null && user.getNom() != currentUser.getNom()) {
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
                        
                    case 8:
                        System.out.println("Deconnexion");
                        reponse = 'N';
                        break;
                    
                    case 9:
                       int idUser = 1;
                        
                        if(currentUser.getClass().getName().equals("myfristapp.Moderateur"))
                        {
                           for(Users user : usersTab)
                           {
                                if(user != null && user.getNom() != currentUser.getNom()) 
                                {
                                    
                                    id.setValue(0);
                                    
                                    System.out.println(idUser   + " " + user.getPrenom() + " " + user.getNom() + " : ");
                                    idUser ++;
                                    for(String msg : user.getAllMessages())
                                    {
                                        id.setValue(id.getValue() + 1);
                                        System.out.println("Message " + id.getValue() + " : " +  msg);
                                    }
                                    System.out.println("\n_______________________________\n");
                                }
                           }
                           
                           System.out.println("Selectionnez le user");
                           choix = sc.nextInt()-1;
                            sc.nextLine();
                            nbMsg = usersTab.get(choix).getAllMessages().size();
                            if(nbMsg > 0 && choix <= nbMsg)
                            {
                                System.out.println(monMenu.deleteMsg(nbMsg, usersTab.get(choix)));
                            }
                           
                        }
                        break;
                        
                    case 10:
                    if(currentUser.getClass().getName().equals("myfristapp.Moderateur"))
                    {
                       if(((Moderateur)currentUser).getLevelModeration() == 2)
                        {
                            nbUsers.setValue(-1);
                            id.setValue(0);

                            for (Users user : usersTab) {
                               monMenu.infoFriend(nbUsers, id, user);
                                if(user != null && user.getNom() != currentUser.getNom()) {
                                   System.out.println(id.getValue() + " " + user.getPrenom() + " " + user.getNom());

                                }
                            }
                            if(nbUsers.getValue() > 0) 
                            {
                                System.out.println(monMenu.deleteUser(mesUsers, usersTab));
                            }
                            
                        }
                    }
                    break;
                    
                    default:
                        System.out.println("default");

                 }
                /*
                do{
                    
                    System.out.println("Voulez vous continuer? (O/N)");
                    reponse = monMenu.reponseBoucle();
                    
                }while(reponse != 'N' && reponse != 'O');
                */
            };
                       
            }while(reponse == 'N');
        System.out.println("Au revoir !");
  
    }
}
