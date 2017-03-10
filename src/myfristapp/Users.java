/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfristapp;

import java.util.Arrays;

/**
 *
 * @author alexandre.depembroke
 */
public class Users {
    
    //initialisation des différentes variables
    private String nom;
    private String prenom;
    private String ville;
    private int birthYear;
    private int age;
    private String messages[];
    private int nbMessage;
    private String presenteMoi;
    private Users users[];
    private int nbUser;
    private boolean isFriend;
    
    //Constructeur d'un User
    public Users(String pNom, String pPrenom, String pVille, int pBirthYear){
        System.out.println("Création de l'utilisateur " + pPrenom + " " + pNom);
        System.out.println("______________________________\n");
        nom = pNom;
        prenom = pPrenom;
        ville = pVille;
        birthYear = pBirthYear;
        nbMessage = 0;
        messages = new String[20];
        users = new Users[20];
        nbUser = 0;
        isFriend = false;
      
    }
    
   
    
    // ACCESSEURS
    
    public String getNom(){
        return nom;
    }
    
    public String getPrenom(){
        return prenom;
    }
    
    public String getVille(){
        return ville;
    }
    
    public int getBirthYear(){
        return birthYear;
    }
    
    public int getAge(){
        age = 2017 - birthYear;
        return age;
    }
    
    public boolean isFriend(){
        return isFriend;
    }
    
    public String [] getAllMessages(){       
            return messages;        
    }
    
    public String getOneMessage(int nb){
        return messages[nb];
    }
    
    public Users [] getAllUsers(){
        return users;
    }
    
    public String getOneUser(int nb){
        return users[nb].presenteMoi();
    }
    
    public String presenteMoi(){
        presenteMoi  = "\n - Prénom  : " + this.getPrenom() + "\n - Nom : " + this.getNom() +  "\n - Ville : " + this.getVille() + " \n - Année de Naissance :  " + this.getBirthYear() + "\n - Age : " + this.getAge() + "\n - Messages : ";
        return presenteMoi;
    }
    
   
    
    
    
    // MUTATEUR
    
    public void setPrenom(String pPrenom)
    {
        prenom  = pPrenom;
    }
    
    public void setNom(String pNom)
    {
        nom  = pNom;
    }
    
    public void setVille(String pVille)
    {
        ville  = pVille;
    }
    public void setBirthYear(int pBirthYear)
    {
        birthYear  = pBirthYear;
    }
    
    public void setMessages(String pMessage)
    {       
        messages[nbMessage] = pMessage;
        nbMessage ++;
        
    }
    
    public void setUsers(Users pUser)
    {
        users[nbUser] = pUser;
        nbUser ++;
    }
    
    public void toBeFriend(){
        
         isFriend = true;
    }

    
    
}
