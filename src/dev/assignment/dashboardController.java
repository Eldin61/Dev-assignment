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
import javafx.stage.Stage;

/**
 *
 * @author eldin
 */
public class dashboardController implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }
    
    @FXML
    private void backToChar(ActionEvent event) throws Exception{
        charScreen cs = new charScreen();
        cs.start(new Stage());
        
        dashboard db = new dashboard();
        db.close();
        
        
    }
    
}
