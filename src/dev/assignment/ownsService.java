/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.assignment;

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
 * @author Orlando
 */
public class ownsService {
    
    public  void testshit(){
    
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Dev_assignmentPU");
        EntityManager em = emFactory.createEntityManager();

        Users user = new Users();
        user.getCharatersCollection();
        System.out.println(user.getCharatersCollection());
    }
}
