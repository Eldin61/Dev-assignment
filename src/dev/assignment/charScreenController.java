/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.assignment;

import dev.entity.Charaters;
import dev.entity.Users;
import entitymanagers.findUser;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

import sun.plugin2.message.CustomSecurityManagerAckMessage;


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
    private ComboBox inputClass;
    
    @FXML
    private ComboBox inputRace;
    
    @FXML
    private TextField inputName;
    
    @FXML
    public ComboBox charSelectDD;
    
    @FXML
    public Label charNameLabel;
    
    @FXML
    public Label className;
            
    @FXML
    public Label raceName;
            
    @FXML
    public Label levelName;
    
    public ObservableList<Charaters> characterlist = FXCollections.observableArrayList();
    
    public HashMap<String, Charaters> characterrefresh = new HashMap<String, Charaters>();
    
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
    private void CreateCharacter(ActionEvent event) throws Exception{
        Charaters newCharacter = new Charaters();
        
        newCharacter.setName(inputName.getText());
        newCharacter.setLevel((int) (Math.random() * 99 + 1));
        newCharacter.setRace(inputRace.getValue().toString());
        newCharacter.setClass1(inputClass.getValue().toString());
        
        em.getTransaction().begin();
        em.persist(newCharacter);
        em.getTransaction().commit();
       
    
        setOwns(inputName.getText(), user);

        
    }
    
    @FXML
    private void getStats(ActionEvent event) throws Exception{
         
        String value=charSelectDD.getValue().toString();
        
        String name = charSelectDD.getValue().toString();
        Charaters nickname = characterrefresh.get(name);
        charNameLabel.setText(nickname.getName());
        className.setText(nickname.getClass1());
        raceName.setText(nickname.getRace());
        levelName.setText(nickname.getLevel()+ "");
      
        
        
           
    }
    
    @FXML
    private void loadChars(ActionEvent event) throws Exception{

           Users uname = em.find(Users.class, user);
           
           
           for (Charaters item : uname.getCharatersCollection()) { // loop kijkt naar username > characters en pompt ze in een list
             characterrefresh.put(item.getName(), item);              
                            
            } charSelectDD.getItems().clear(); 
        charSelectDD.getItems().addAll(characterrefresh.keySet());
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
        } 
    }
        
    @FXML
    private void openDashboard(ActionEvent event) throws Exception{
        dashboard db = new dashboard();
        db.start(new Stage());

        charScreen cs = new charScreen();
        cs.close();
    }
    @FXML
    private void serverLogin(ActionEvent event) throws Exception{
        serverWindow sw = new serverWindow();
        sw.start(new Stage());
    }
    
}
