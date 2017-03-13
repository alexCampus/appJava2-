/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfristapp;

/**
 *
 * @author alexandre.depembroke
 */
public class Moderateur extends Users{
    
    private int moderationLevel;
    
  /*   public Moderateur() {
        super();
       this.moderationLevel = 1;
    }*/
    
    public Moderateur(String pNom, String pPrenom, String pVille, int pBirthYear, int pModerationLevel) {
        super(pNom, pPrenom, pVille, pBirthYear);
       moderationLevel = pModerationLevel;
    }
    
    public int getLevelModeration()
    {
        return moderationLevel;
    }
    
    public boolean isModerateur()
    {
        if(moderationLevel == 1 || moderationLevel == 2)
        {
            return true;
        }
        return false;
    }
    
}
