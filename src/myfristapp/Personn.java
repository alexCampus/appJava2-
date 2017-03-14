/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfristapp;

import java.util.ArrayList;

/**
 *
 * @author alexandre.depembroke
 */
public class Personn {
    
     private final ArrayList<Users> users = new ArrayList<>();
     
    public Personn(){
        
    }
    
     public ArrayList<Users> getAllUsers(){
        return users;
    }
     
     
    
    public String getOneUser(int nb){
        return users.get(nb).presenteMoi();
    }
    
      public void setUsers(Users pUser)
    {
        users.add(pUser);
        
    }
      
      public void deleteOneUser(int nb){
        users.remove(nb);
    }
    
}
