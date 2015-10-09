/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.assignment;

import dev.entity.Charaters;
import dev.entity.Users;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eldin
 */
public class charScreenController implements Initializable{
    
    @FXML 
    private Label uName;
    public static String user;
    @FXML 
    private Label charname;
    
    @FXML 
    private Label classname;
    
    @FXML
    private Button statButton;
    
    @FXML
    private Button create;
    
    @FXML
    ComboBox inputClass;
    @FXML
    ComboBox inputRace;
    @FXML
    TextField inputName;
    
    public void charScreenController(String username) throws Exception{
      user = username;
    }
    
    @FXML
    Collection nCharacters = Users.getInstance().getCharatersCollection();
    String Username = Users.getInstance().getUserName();
    private fxmlController controller = new fxmlController();
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Dev_assignmentPU");
        EntityManager em = emFactory.createEntityManager();
    
    @FXML
    public void CreateCharacter(){

        
    }
    
    @FXML
    private void getStats(ActionEvent event) throws Exception{
        CreateCharacter();
        uName.setText(user);
        
        Charaters newCharacter = new Charaters();
        
        newCharacter.setName(inputName.getText());
        newCharacter.setLevel(1);
        newCharacter.setRace(inputRace.getValue().toString());
        newCharacter.setClass1(inputClass.getValue().toString());
        
        em.getTransaction().begin();
        em.persist(newCharacter);
        em.getTransaction().commit();
       
    
        setOwns(inputName.getText(), user);
        System.out.print("new user");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputClass.getItems().addAll(
            "Hond",
            "Kip",
            "Paard",
            "Koe",
            "Geit" 
        );   
            
            inputRace.getItems().addAll(
            "Rood",
            "Wit",
            "Blauw",
            "Groen",
            "Paars" 
        );   
    }
    
    public void setOwns(String Charname, String username){

        em.getTransaction().begin();
        try {
            em.createNativeQuery("INSERT INTO owns(name, user_name) VALUES (?,?)")
                    .setParameter(1, Charname)
                    .setParameter(2, username)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
