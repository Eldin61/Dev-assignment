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
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    
    private Button statButton;
    
    public void charScreenController(String username) throws Exception{
//        uName.setText(user);
    }
    
    @FXML
    private void getStats(ActionEvent event) throws Exception{
//        FXMLDocumentController dc = new FXMLDocumentController();
//        String username = dc.sendUname;
        uName.setText(user);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }
    
}
