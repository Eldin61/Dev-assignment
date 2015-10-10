/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.assignment;

import entitymanagers.findUser;
import entitymanagers.findStats;

import com.sun.corba.se.impl.logging.ActivationSystemException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author eldin
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private AnchorPane content;
    
    @FXML
    private TextField userTF;
    
    @FXML
    private PasswordField passTF;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
            findUser find = new findUser();
            findStats stats = new findStats();
            charScreenController chara = new charScreenController();
            
            String username = userTF.getText();
            
            String password = passTF.getText();
            
            find.findUser(username, password);
            find.findStats(username);
            chara.charScreenController(username);

    }
    
    @FXML
    private void registerAccountAction() throws IOException{
        register reg = new register();
        reg.start(new Stage());
        
        DevAssignment dev = new DevAssignment();
        dev.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
