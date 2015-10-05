/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitymanagers;

import dev.entity.Users;
import dev.assignment.DevAssignment;
import dev.assignment.charScreen;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author eldin
 */
public class findUser {
    
    public void findUser(String username, String password) throws Exception{
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Dev_assignmentPU");
        EntityManager em = emFactory.createEntityManager();
        Users user = em.find(Users.class, username);
        
        try {
             if (username.equals(user.getUserName()) & password.equals(user.getPassword())){
            DevAssignment dev = new DevAssignment();
            
            dev.close();
            
            charScreen chars = new charScreen();
            
            chars.start(new Stage());
        } else {
            JOptionPane.showMessageDialog(null, "Bad Credentials!");
        }
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "Bad credentials!");
        }
        
    }
    
}
