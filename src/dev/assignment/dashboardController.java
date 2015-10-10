/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.assignment;

import com.sun.prism.shader.DrawSemiRoundRect_Color_AlphaTest_Loader;
import dev.entity.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author eldin
 */
public class dashboardController implements Initializable{
    
    public static String username;
    
    int subFee;
    int subMonth;
    
    @FXML
    private Label slotLabel;
    
    @FXML
    private Label monthLabel;
    
    @FXML
    private RadioButton threeRadio;
    
    @FXML
    private RadioButton sixRadio;
    
    @FXML
    private RadioButton twelveRadio;
    
    @FXML
    private TextField balanceTF;
    
    @FXML
    private Label balanceLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      setInfo();
      setRadioGroup();
    }
    
    private void setRadioGroup(){
        ToggleGroup group = new ToggleGroup();
        threeRadio.setToggleGroup(group);
        sixRadio.setToggleGroup(group);
        twelveRadio.setToggleGroup(group);
        
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
        @Override
        public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {

            RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
            System.out.println("Selected Radio Button - "+chk.getText());

            if (chk.getText().contains("10")){
                subFee = 10;
                subMonth = 3;
                System.out.println(subFee);
            } else if (chk.getText().contains("15")){
                subFee = 15;
                subMonth = 6;
                System.out.println(subFee);
            } else if (chk.getText().contains("25")){
                subFee = 25;
                subMonth = 12;
                System.out.println(subFee);
            }
        }
    });
    }
    
    private void setInfo(){
        dashboard db = new dashboard();
       EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Dev_assignmentPU");
        EntityManager em = emFactory.createEntityManager();
        Users user = em.find(Users.class, username);
        
        int charSlots = user.getCharacterSlots();
        int balance = user.getBalance();
        int monthsPayed = user.getMonthsPayed();
        
      String balanceS = Integer.toString(balance);
      
      balanceLabel.setText(balanceS);
      monthLabel.setText(Integer.toString(monthsPayed));
      slotLabel.setText(Integer.toString(charSlots));
      
      
      em.close();
      emFactory.close();
    }
    
    @FXML
    private void addSlot(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Dev_assignmentPU");
        
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Users user = em.find(Users.class, username);
        
        int slots = Integer.parseInt(slotLabel.getText());
        int addedSlots = slots + 1;
        int balance = Integer.parseInt(balanceLabel.getText());
        int afterBalance = balance - 5;
         if (afterBalance < 0){
            JOptionPane.showMessageDialog(null, "Insufficient funds.");
            afterBalance = afterBalance + 5;
        } else {
             user.setBalance(afterBalance);
             user.setCharacterSlots(addedSlots);
             
             balanceLabel.setText(Integer.toString(afterBalance));
             slotLabel.setText(Integer.toString(addedSlots));
         }
        
        em.getTransaction().commit();
        
        em.close();
        emFactory.close();
    }
    
    @FXML
    private void addBalance(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Dev_assignmentPU");
        
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Users user = em.find(Users.class, username);
        
        int balance = 0;
        try {
            balance = Integer.parseInt(balanceTF.getText());
        } catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "You can only enter numbers here.");
        }
        int balanceNow = Integer.parseInt(balanceLabel.getText());
        int calculatedBalance = balance + balanceNow;
        balanceLabel.setText(Integer.toString(calculatedBalance));
        
        user.setBalance(calculatedBalance);
        
        em.getTransaction().commit();
        
        em.close();
        emFactory.close();
        
    }
    
    @FXML
    private void subscribe(ActionEvent event){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Dev_assignmentPU");
        
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Users user = em.find(Users.class, username);
        
        int currBalance = Integer.parseInt(balanceLabel.getText());
        int afterBalance = currBalance - subFee;
        int currMonth = Integer.parseInt(monthLabel.getText());
        int addedMonth = currMonth + subMonth;
        if (afterBalance < 0){
            JOptionPane.showMessageDialog(null, "Insufficient funds.");
            afterBalance = afterBalance + subFee;
        } else {
            user.setBalance(afterBalance);
            user.setMonthsPayed(addedMonth);
        em.getTransaction().commit();
        
        balanceLabel.setText(Integer.toString(afterBalance));
        monthLabel.setText(Integer.toString(addedMonth));
        
        em.close();
        emFactory.close();
        }
        
    }
    
    @FXML
    private void backToChar(ActionEvent event) throws Exception{
        charScreen cs = new charScreen();
        cs.start(new Stage());
        
        dashboard db = new dashboard();
        db.close();
        
        
    }
    
}
