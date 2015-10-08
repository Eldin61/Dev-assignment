/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitymanagers;

import dev.entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Orlando
 */
public class findStats {
    
    public void findStats(String username) throws Exception{
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Dev_assignmentPU");
        EntityManager em = emFactory.createEntityManager();
        Users user = em.find(Users.class, username);
        
        try {   
             if (username.equals(user.getUserName())){
                 
             } else {                
            JOptionPane.showMessageDialog(null, "Bad Credentials!");
                    }
            } catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "Bad credentials!");
        
        }
    }
    
}
