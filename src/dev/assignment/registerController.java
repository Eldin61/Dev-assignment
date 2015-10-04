/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.assignment;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author eldin
 */
public class registerController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }
    
    @FXML
    private TextField userTF;
    
    @FXML
    private PasswordField passTF;
    
    @FXML
    private TextField firstTF;
    
    @FXML
    private TextField lastTF;
    
    @FXML 
    private TextField ibanTF;
    
    @FXML
    private void registerUser(ActionEvent event){
        System.out.println("pressed register");
        createUser create = new createUser();
        
        String username = userTF.getText();
        String password = passTF.getText();
        String firstname = firstTF.getText();
        String lastname = lastTF.getText();
        String iban = ibanTF.getText();
        
        int balance = 0;
        int slots = 3;
        int monthspayed = 0;
        String lastpayed = "n.v.t";        
        
        create.create(username, password, balance, firstname, lastname, iban, slots, monthspayed, false, lastpayed);
       
    }
    
    @FXML
    private void previous() throws Exception{
        DevAssignment dev = new DevAssignment();
        dev.start(new Stage());
        
        register reg = new register();
        reg.close();
    }
    
}
