/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.assignment;

import dev.entity.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eldin
 */
public class dashboardController implements Initializable{
    
    public static String username;
    
    @FXML
    private Label balanceLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      dashboard db = new dashboard();
       EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Dev_assignmentPU");
        EntityManager em = emFactory.createEntityManager();
        Users user = em.find(Users.class, username);
        
        int charSlots = user.getCharacterSlots();
        int balance = user.getBalance();
        int monthsPayed = user.getMonthsPayed();
        
      String balanceS = Integer.toString(balance);
      
      balanceLabel.setText(balanceS);
    }
    
    @FXML
    private void backToChar(ActionEvent event) throws Exception{
        charScreen cs = new charScreen();
        cs.start(new Stage());
        
        dashboard db = new dashboard();
        db.close();
        
        
    }
    
}
