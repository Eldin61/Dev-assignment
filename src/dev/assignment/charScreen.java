/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author eldin
 */
public class charScreen extends Application {
    private static Stage primaryStage;
    Parent root;

    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("charScreen.fxml"));
        
        Scene scene = new Scene(root);
        primaryStage = stage;
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    
    public void close(){
        primaryStage.close();
    }
    
}
